package Data.UI;
import Data.Block.AbstractBlock;
import Data.Block.interfaces.Block;
import Data.Block.interfaces.SmeltableBlock;
import Data.Point;
import Exceptions.BlockErrorException;
import Exceptions.OutOfMapException;
import Data.Block.*;

import java.util.Random;

public class Map {

    private Block[][] mapBlocks;
    private int sizeX, sizeY;
    private final int RANDOM_BLOCKS_TO_ADD=8;

    public Map(int sizex, int sizey)
    {
        this.sizeX = sizex;
        this.sizeY = sizey;
        this.mapBlocks = new AbstractBlock[sizex][sizey];

        for(int i=0; i<mapBlocks.length; i++)
            for (int j=0; j<mapBlocks.length; j++)
                this.mapBlocks[i][j] = new AirBlock();
        this.AddSea();
        Random rand = new Random();
        for (int i = 0 ; i < RANDOM_BLOCKS_TO_ADD; i++){
            Block b = new SandBlock();
            int row = rand.nextInt(this.sizeX);
            int col = rand.nextInt(this.sizeY);
            try {
                this.insertBlockAtPoint(new Point(row, col), b);
            } catch (OutOfMapException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private Block getBlock(Point p) throws OutOfMapException {
        if(!this.isInMapBound(p)){
            throw new OutOfMapException();
        }
        Block b = this.mapBlocks[p.x][p.y];
        this.mapBlocks[p.x][p.y] = new AirBlock();

        for(int i = p.y-1; i > 0 && this.mapBlocks[p.x][i].isGravity(); i--){
            this.swapCell(new Point(p.x, i), new Point(p.x, i+1));

            // Se un blocco solido con gravity cade su una torcia
            // viene cambiato con AirBlock e si fanno cadere i blocchi sopra
            if(this.isInMapBound(new Point(p.x, i+2)) &&
                this.mapBlocks[p.x][i+2] instanceof TorchBlock &&
                !this.mapBlocks[p.x][i+1].isFallThrough())
            {
                this.mapBlocks[p.x][i+1] = new AirBlock();  // penso sia sbagliato comunque
                i++;
            }

        }
        return b;
    }
    public boolean isPickable(Point p){
        return this.mapBlocks[p.x][p.y].isPickable();
    }
    public Block gimmiePickable(Point p) throws BlockErrorException, OutOfMapException {
        if(!this.isPickable(p)){
            throw new BlockErrorException();
        }
        return this.getBlock(p);
    }

    public boolean isInMapBound(Point point){
        return point.x < this.sizeX && point.y < this.sizeY;
    }
    public boolean isSmeltable(Point point) throws OutOfMapException{
        if(!isInMapBound(point))
            throw new OutOfMapException();

        return this.mapBlocks[point.x][point.y] instanceof SmeltableBlock;
    }
    public SmeltableBlock getSmeltableBlock(Point point) throws OutOfMapException{

        if(isSmeltable(point)){
            return (SmeltableBlock) this.mapBlocks[point.x][point.y];
        }
        return new NullBlock();
    }

    public void AddSea(){
        for(int i = 0; i < 3; i++)
            this.AddRiver();
    }
    public void AddRiver(){
        try {
            this.addRowOfWater();
        } catch (OutOfMapException e) {
            throw new RuntimeException(e);
        }
    }
    private void addRowOfWater() throws OutOfMapException{
        for(int i = 0; i < this.sizeX; i++){
            this.insertBlockAtPoint(new Point(i, 0), new WaterBlock());
        }
    }
//    private void ChangeCell(Point point, char blockType)
//    {
//        this.mapBlocks[point.x][point.y].setType(blockType);
//    }

    private void swapCell(Point point1, Point point2)
    {
        Block b1 = this.mapBlocks[point1.x][point1.y];
        Block b2 = this.mapBlocks[point2.x][point2.y];

        this.mapBlocks[point1.x][point1.y] = b2;
        this.mapBlocks[point2.x][point2.y] = b1;
    }

    public void insertBlockAtPoint(Point insertPoint, Block block) throws OutOfMapException{
        if(!isInMapBound(insertPoint))
            throw new OutOfMapException();

        // Insert The block
        this.mapBlocks[insertPoint.x][insertPoint.y] = block;

        if(!block.isGravity())
            return;

        // if the block has gravity swap it down until
        // there is one block without fallthrough or i goes to the map bound
        int i = insertPoint.y + 1;
        while(i < this.sizeY && this.mapBlocks[insertPoint.x][i].isFallThrough()){
            this.swapCell(new Point(insertPoint.x, i-1), new Point(insertPoint.x, i));
            i++;
        }
        if(!block.isFallThrough() && this.mapBlocks[insertPoint.x][i] instanceof TorchBlock){
            this.mapBlocks[insertPoint.x][i] = new AirBlock();
        }
    }

    public void insertBlockAtPoint(Point insertPoint, char blockType) throws OutOfMapException{
        AbstractBlock block = switch (blockType) {
            case 'S' -> new SandBlock();
            case 'W' -> new WaterBlock();
            default -> new AirBlock();
        };
        this.insertBlockAtPoint(insertPoint, block);
    }

    public void DisplayOnOut()
    {
        for(int i=0; i < this.sizeY; i++){
            for (int j=0; j < this.sizeX; j++)
                System.out.print(this.mapBlocks[j][i].Display() + " ");
            System.out.println();
        }
    }
}
