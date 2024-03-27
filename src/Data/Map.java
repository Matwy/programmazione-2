package Data;
import Exceptions.OutOfMapException;

public class Map {

    private Block[][] mapBlocks;
    private int sizeX, sizeY;

    public Map(int sizex, int sizey)
    {
        this.sizeX = sizex;
        this.sizeY = sizey;
        this.mapBlocks = new Block[sizex][sizey];

        for(int i=0; i<mapBlocks.length; i++)
            for (int j=0; j<mapBlocks[i].length; j++)
                this.mapBlocks[i][j] = new Block();
    }

    private void ChangeCell(Point point, char blockType)
    {
        this.mapBlocks[point.x][point.y].setType(blockType);
    }

    private void swapCell(Point point1, Point point2)
    {
        Block b1 = this.mapBlocks[point1.x][point1.y];
        Block b2 = this.mapBlocks[point2.x][point2.y];

        this.mapBlocks[point1.x][point1.y] = b2;
        this.mapBlocks[point2.x][point2.y] = b1;
    }

    public void insertBlockAtPoint(Point insertPoint, Block block) throws OutOfMapException{
        if(insertPoint.x >= this.sizeX || insertPoint.y >= this.sizeY)
            throw new OutOfMapException();

        // Insert The block
        this.mapBlocks[insertPoint.x][insertPoint.y] = block;

        // if the block has gravity swap it down until
        // there is one block without fallthrough or i goes to the map bound
        int i = insertPoint.x + 1;
        while(block.isGravity() && i < this.sizeY && this.mapBlocks[i][insertPoint.y].isFallThrough()){
            this.swapCell(insertPoint, new Point(i, insertPoint.y));
        }

    }
    public void insertBlockAtPoint(Point insertPoint, char blockType) throws OutOfMapException{
        Block block = new Block(blockType);
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
