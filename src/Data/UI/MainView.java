package Data.UI;

import Data.Block.interfaces.Block;
import Data.Block.interfaces.SmeltableBlock;
import Data.Point;
import Exceptions.BlockErrorException;
import Exceptions.OutOfMapException;

public class MainView {
    public Map map;
    public Furnace furnace;
    public Inventory inventory;

    public MainView() {
        this.map = new Map(8, 8);
        this.furnace = new Furnace();
        this.inventory = new Inventory();
    }

    public void MoveIntoFurnace(Point point) throws OutOfMapException{
        SmeltableBlock blockToSmelt = this.map.getSmeltableBlock(point);
        this.furnace.setInput(blockToSmelt);

        this.map.insertBlockAtPoint(point, '.');
        this.inventory.addBlock(this.furnace.output);
    }
    public void fromInventoryIntoFurnace(int index) throws BlockErrorException {
        SmeltableBlock block = this.inventory.getSmeltableItem(index);
        this.furnace.setInput(block);
    }
    public void fromFurnaceIntoInventory(){
        this.inventory.addBlock(this.furnace.getOutput());
    }
    public void pickUpBlock(Point p) throws OutOfMapException, BlockErrorException {
        Block b = this.map.gimmiePickable(p);
        this.inventory.addBlock(b);
    }
    public void toggleInventoryComparator(){
        this.inventory.switchBlockComparator();
    }
    public void smelt(){
        this.furnace.smeltInput();
    }
    public void DisplayInOut(){
        this.map.DisplayOnOut();
        this.furnace.DisplayOnOut();
        this.inventory.printInInventory();
    }
}
