package Data.UI;

import Data.Block.SmeltableBlock;
import Data.Point;
import Exceptions.OutOfMapException;

public class MainView {
    public Map map;
    public Furnace furnace;

    public MainView() {
        this.map = new Map(8, 8);
        this.furnace = new Furnace();
    }

    public void MoveIntoFurnace(Point point) throws OutOfMapException{
        SmeltableBlock blockToSmelt = this.map.getSmeltableBlock(point);
        this.furnace.setInput(blockToSmelt);
        this.map.insertBlockAtPoint(point, '.');
    }
    public void DisplayInOut(){
        this.map.DisplayOnOut();
        this.furnace.DisplayOnOut();
    }
}
