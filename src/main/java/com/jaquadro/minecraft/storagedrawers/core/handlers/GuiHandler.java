package com.jaquadro.minecraft.storagedrawers.core.handlers;

import com.jaquadro.minecraft.storagedrawers.block.tile.TileEntityDrawers;
import com.jaquadro.minecraft.storagedrawers.block.tile.TileEntityFramingTable;
import com.jaquadro.minecraft.storagedrawers.client.gui.GuiDrawers;
import com.jaquadro.minecraft.storagedrawers.client.gui.GuiFraming;
import com.jaquadro.minecraft.storagedrawers.client.gui.GuiPortableFraming;
import com.jaquadro.minecraft.storagedrawers.inventory.ContainerDrawers;
import com.jaquadro.minecraft.storagedrawers.inventory.ContainerFramingTable;
import com.jaquadro.minecraft.storagedrawers.inventory.ContainerPortableFramingTable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
    public static int drawersGuiID = 0;
    public static int framingGuiID = 1;
    public static int portableFramingGUIID = 2;

    @Override
    public Object getServerGuiElement (int ID, EntityPlayer player, World world, int x, int y, int z) {
        // Open Portable GUI
        if (ID == portableFramingGUIID)
            return new ContainerPortableFramingTable(player.inventory, world);

        TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
        if (tile instanceof TileEntityDrawers tileDrawers)
            return new ContainerDrawers(player.inventory, tileDrawers);
        if (tile instanceof TileEntityFramingTable tileFramingTable)
            return new ContainerFramingTable(player.inventory, tileFramingTable);

        return null;
    }

    @Override
    public Object getClientGuiElement (int ID, EntityPlayer player, World world, int x, int y, int z) {
        // Open Portable GUI
        if (ID == portableFramingGUIID)
            return new GuiPortableFraming(player.inventory);

        TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
        if (tile instanceof TileEntityDrawers tileDrawers)
            return new GuiDrawers(player.inventory, tileDrawers);
        if (tile instanceof TileEntityFramingTable tileFramingTable)
            return new GuiFraming(player.inventory, tileFramingTable);

        return null;
    }
}
