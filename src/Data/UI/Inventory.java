package Data.UI;

import Data.Block.interfaces.Block;
import Data.Block.interfaces.InventoryBlock;
import Data.Block.interfaces.SmeltableBlock;
import Data.Block.comparator.AlphabeticalBlockComparator;
import Data.Block.comparator.BlockComparator;
import Exceptions.BlockErrorException;

import java.util.ArrayList;
import java.util.Comparator;

public class Inventory {
    private ArrayList<Block> blocks;
    private Comparator<Block> blockComparator;

    public Inventory(){
        this.blocks = new ArrayList<Block>();
        this.blockComparator = new AlphabeticalBlockComparator();
    }

    public void switchBlockComparator(){
        if(this.blockComparator instanceof AlphabeticalBlockComparator){
            this.blockComparator = new BlockComparator();
        }
        else{
            this.blockComparator = new AlphabeticalBlockComparator();
        }
    }
    public void sortInventory(){
        this.blocks.sort(this.blockComparator);
    }
    public void addBlock(Block b){
        this.blocks.add(b);
        this.sortInventory();
    }
    public boolean isSmeltable(int index){
        return this.blocks.get(index) instanceof SmeltableBlock;
    }
    public SmeltableBlock getSmeltableItem(int index) throws BlockErrorException {
        if(!this.isSmeltable(index)){
            throw new BlockErrorException();
        }
        return (SmeltableBlock) this.blocks.get(index);
    }
    public void printInInventory(){
        for (InventoryBlock block : this.blocks) {
            System.out.print(block.displayInInventory());
        }
        System.out.println();
    }
}
