package Data.comparator;

import Data.Block.interfaces.Block;

import java.util.Comparator;

public class AlphabeticalBlockComparator implements Comparator<Block> {
    @Override
    public int compare(Block b1, Block b2) {
        return b1.Display() - b2.Display();
    }
}
