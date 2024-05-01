package Data.comparator;

import Data.Block.interfaces.Block;
import java.util.Comparator;

public class BlockComparator implements Comparator<Block> {
    @Override
    public int compare(Block o1, Block o2) {
        return o1.Display()-o2.Display();
    }
}
