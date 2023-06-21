package com.jaquadro.minecraft.storagedrawers.inventory;

import com.jaquadro.minecraft.storagedrawers.block.tile.TileEntityFramingTable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class ContainerHandheldFramingTable extends ContainerFramingTable {
    private final World world;
    private static TileEntityFramingTable tileFramingTable = null;

    // TODO Test if inputing player inv saves data
    public ContainerHandheldFramingTable(InventoryPlayer inventory, World world) {
        // TE is only used for slot registration, simply give a new one
        super(inventory, inventory);
        this.world = world;
    }

    // This method prevents a new TE being created each time the menu is opened.
    private static TileEntityFramingTable getTEFramingTable() {
        if (tileFramingTable == null) {
            tileFramingTable = new TileEntityFramingTable();
        }
        return tileFramingTable;
    }

    /*
    @Override
    public void onContainerClosed(@NotNull EntityPlayer player) {
        super.onContainerClosed(player);

        if (!world.isRemote) {
            this.clearContainer(player, this.world, tableInventory);
        }
    }
     */

    @Override
    public boolean canInteractWith(@NotNull EntityPlayer player) {
        return !world.isRemote;
    }
}
