package Data;

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

    private void DisplayOnOut(){
        System.out.println("|| "
                +this.input.Display()
                +" --> "
                +this.output.Display()
                +" ||");
    }
}