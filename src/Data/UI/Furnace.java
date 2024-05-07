package Data.UI;

import Data.Block.interfaces.Block;
import Data.Block.NullBlock;
import Data.Block.interfaces.SmeltableBlock;

public class Furnace {
    public SmeltableBlock input;
    public Block output;

    public Furnace() {
        this.input = new NullBlock();
        this.output = new NullBlock();
    }

    public void smeltInput(){
        this.output = this.input.smelt();
        this.input = new NullBlock();
    }
    public void setInput(SmeltableBlock inputBlock){
        this.input = inputBlock;
        this.smeltInput();
    }
    public SmeltableBlock getInput(){
        return this.input;
    }

    public Block getOutput(){
        Block b = this.output;
        this.output = new NullBlock();
        return b;
    }
    public void DisplayOnOut(){
        System.out.println("|| "
                +this.input.Display()
                +" --> "
                +this.output.Display()
                +" ||");
    }
}
