package Data.Block;
import Data.Block.interfaces.SmeltableBlock;
import Data.Block.interfaces.Block;

public class SandBlock extends AbstractBlock implements SmeltableBlock{
    public Block smelt() {
        return new GlassBlock();
    }
    public SandBlock() {
        super('S', true, false, "Sand Block");
        this.pickable = true;
    }
}
