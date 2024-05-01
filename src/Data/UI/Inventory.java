package Data.UI;

import Data.Block.interfaces.Block;
import Data.Block.interfaces.InventoryBlock;
import Data.Block.interfaces.SmeltableBlock;
import Exceptions.BlockErrorException;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Block> blocks;

    public Inventory(){}

    public void addBlock(Block b){
        this.blocks.add(b);
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
    }
}
