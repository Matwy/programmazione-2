package Data.UI;

import Data.Block.interfaces.SmeltableBlock;
import Data.Point;
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
    public void DisplayInOut(){
        this.map.DisplayOnOut();
        this.furnace.DisplayOnOut();
    }
}
