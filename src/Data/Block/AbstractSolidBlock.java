package Data.Block;

public class AbstractSolidBlock extends AbstractBlock{
    public AbstractSolidBlock(char type, String blockName) {
        super(type, false, false, blockName);
        this.pickable = true;
    }
}
