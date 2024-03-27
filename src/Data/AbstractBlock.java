package Data;

public abstract class AbstractBlock implements Block {
    protected char Type;
    protected boolean gravity;
    protected boolean fallThrough;
    private String blockName;

    public AbstractBlock(char type, boolean gravity, boolean fallThrough, String blockName) {
        Type = type;
        this.gravity = gravity;
        this.fallThrough = fallThrough;
        this.blockName = blockName;
    }

    public char Display() {
        return this.Type;
    }
    public boolean isFallThrough() {
        return this.fallThrough;
    }

    public boolean isGravity() {
        return this.gravity;
    }

    @Override
    public String toString(){
        return this.blockName;
    }
}
