package Data;

public class SandBlock extends AbstractBlock implements SmeltableBlock{
    public Block smelt() {
        return new GlassBlock();
    }
    public SandBlock() {
        super('S', true, false, "Sand Block");
    }
}
