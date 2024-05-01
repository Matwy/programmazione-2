package Data.Block.interfaces;

public interface Block extends InventoryBlock{

    public char Display();
    public boolean isFallThrough();
    public boolean isGravity();
    public boolean isPickable();
}
