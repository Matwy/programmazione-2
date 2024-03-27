package Data;

public class Block {
    private char Type;
    private boolean gravity;
    private boolean fallThrough;
    public Block()
    {
        this.Type = '.';
        this.gravity = false;
        this.fallThrough = true;
    }

    public Block(char type)
    {
        this.Type = type;
        this.gravity = true;
        this.fallThrough = false;
    }

    public boolean isFallThrough() {
        return fallThrough;
    }

    public boolean isGravity() {
        return gravity;
    }
    public void setType(char type){
        this.Type = type;
    }

    public char Display()
    {
        return this.Type;
    }
}
