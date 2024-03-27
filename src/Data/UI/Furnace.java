package Data.UI;

import Data.Block.Block;
import Data.Block.NullBlock;
import Data.Block.SmeltableBlock;

public class Furnace {
    public SmeltableBlock input;
    public Block output;

    public Furnace() {
        this.input = new NullBlock();
        this.output = new NullBlock();
    }

    private void smeltInput(){
        this.output = this.input.smelt();
        this.input = new NullBlock();
    }
    public void setInput(SmeltableBlock inputBlock){
        this.input = inputBlock;
        this.smeltInput();
    }

    public void DisplayOnOut(){
        System.out.println("|| "
                +this.input.Display()
                +" --> "
                +this.output.Display()
                +" ||");
    }
}
