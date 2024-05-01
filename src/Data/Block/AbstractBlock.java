package Data.Block;
import Data.Block.interfaces.Block;

public abstract class AbstractBlock implements Block {
    protected char Type;
    protected boolean gravity;
    protected boolean fallThrough;
    protected boolean pickable;
    private String blockName;

    public AbstractBlock(char type, boolean gravity, boolean fallThrough, String blockName) {
        Type = type;
        this.gravity = gravity;
        this.fallThrough = fallThrough;
        this.pickable = false;
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
    public boolean isPickable() {
        return this.pickable;
    }
    @Override
    public String toString(){
        return this.blockName;
    }
}
