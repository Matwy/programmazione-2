package Data.Block;
import Data.Block.interfaces.Block;
import Data.Block.interfaces.SmeltableBlock;
public class NullBlock extends AbstractSolidBlock implements SmeltableBlock{
    public NullBlock() {
        super(' ', "NullBlock");
        this.pickable = false;
    }

    @Override
    public Block smelt() {
        return new NullBlock();
    }
}
