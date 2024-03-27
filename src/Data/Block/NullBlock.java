package Data;

public class NullBlock extends AbstractSolidBlock implements SmeltableBlock{
    public NullBlock() {
        super(' ', "NullBlock");
    }

    @Override
    public Block smelt() {
        return new NullBlock();
    }
}
