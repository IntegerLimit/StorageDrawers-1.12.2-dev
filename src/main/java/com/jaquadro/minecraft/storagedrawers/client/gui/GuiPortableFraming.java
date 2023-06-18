package com.jaquadro.minecraft.storagedrawers.client.gui;

import com.jaquadro.minecraft.storagedrawers.block.tile.TileEntityFramingTable;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiPortableFraming extends GuiFraming {
    public GuiPortableFraming(InventoryPlayer inventory) {
        super(inventory, new TileEntityFramingTable());
    }
}
