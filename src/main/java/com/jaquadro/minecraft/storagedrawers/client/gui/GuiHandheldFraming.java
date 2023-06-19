package com.jaquadro.minecraft.storagedrawers.client.gui;

import com.jaquadro.minecraft.storagedrawers.StorageDrawers;
import com.jaquadro.minecraft.storagedrawers.block.tile.TileEntityFramingTable;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiHandheldFraming extends GuiFraming {
    private static TileEntityFramingTable tileFramingTable;
    public GuiHandheldFraming(InventoryPlayer inventory) {
        // TE is only used for name, which we already override, just give new one
        super(inventory, getTEFramingTable());
    }

    // This method prevents a new TE being created each time the menu is opened.
    private static TileEntityFramingTable getTEFramingTable() {
        if (tileFramingTable == null) {
            tileFramingTable = new TileEntityFramingTable();
        }
        return tileFramingTable;
    }

    @Override
    protected void drawGuiContainerForegroundLayer (int mouseX, int mouseY) {
        String name = I18n.format(StorageDrawers.MOD_ID + ".gui.handheldFramingTable.title");
        fontRenderer.drawString(name, 8, 6, 4210752);
        fontRenderer.drawString(I18n.format("container.inventory"), 8, ySize - 96 + 2, 4210752);
    }
}
