package com.builtbroken.mffs.field.mode;

import com.builtbroken.mc.core.registry.implement.IRecipeContainer;
import com.builtbroken.mc.lib.transform.vector.Pos;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import com.builtbroken.mffs.ModularForceFieldSystem;
import com.builtbroken.mffs.Reference;
import com.builtbroken.mffs.api.machine.IFieldMatrix;
import com.builtbroken.mffs.api.machine.IProjector;
import com.builtbroken.mffs.api.modules.IProjectorMode;
import com.builtbroken.mffs.base.ItemMFFS;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.IIcon;

import java.util.List;

/**
 * Internal item for MFFS that contains all mods, with the exception of custom, for the force field
 */
public class ItemMode extends ItemMFFS implements IProjectorMode, IRecipeContainer
{
    public ItemMode()
    {
        this.setMaxStackSize(1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void render(ItemStack stack, IProjector projector, double x, double y, double z, float f, long ticks)
    {
        Modes.get(stack).mode.render(stack, projector, x, y, z, f, ticks);
    }

    @Override
    public List<Pos> getExteriorPoints(ItemStack stack, IFieldMatrix projector)
    {
        return Modes.get(stack).mode.getExteriorPoints(stack, projector);
    }

    @Override
    public List<Pos> getInteriorPoints(ItemStack stack, IFieldMatrix projector)
    {
        return Modes.get(stack).mode.getInteriorPoints(stack, projector);
    }

    @Override
    public boolean isInField(ItemStack stack, IFieldMatrix projector, Pos position)
    {
        return Modes.get(stack).mode.isInField(stack, projector, position);
    }

    @Override
    public float getFortronCost(ItemStack stack, float amplifier)
    {
        float v = Modes.get(stack).mode.getFortronCost(stack, amplifier);
        return v > 0 ? v : 8;
    }

    @Override
    public void genRecipes(List<IRecipe> recipes)
    {
        recipes.add(newShapedRecipe(Modes.SPHERE.toStack(), " F ", "FFF", " F ", 'F', ModularForceFieldSystem.focusMatrix));
        recipes.add(newShapedRecipe(Modes.CUBE.toStack(), "FFF", "FFF", "FFF", 'F', ModularForceFieldSystem.focusMatrix));
        recipes.add(newShapedRecipe(Modes.TUBE.toStack(), "FFF", "   ", "FFF", 'F', ModularForceFieldSystem.focusMatrix));
        recipes.add(newShapedRecipe(Modes.PYRAMID.toStack(), "F  ", "FF ", "FFF", 'F', ModularForceFieldSystem.focusMatrix));
        recipes.add(newShapedRecipe(Modes.CYLINDER.toStack(), "S", "S", "S", 'S', Modes.SPHERE.toStack()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item items, CreativeTabs tab, List list)
    {
        for (Modes m : Modes.values())
        {
            list.add(m.toStack());
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg)
    {
        for (Modes m : Modes.values())
        {
            m.icon = reg.registerIcon(Reference.prefix + m.name);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta)
    {
        return Modes.get(meta).icon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getUnlocalizedName(ItemStack stack)
    {
        return "item." + Reference.prefix + Modes.get(stack).name;
    }

    /** Internal enum for mods created by MFFS directly, implement {@link IProjectorMode} for custom types */
    public enum Modes
    {
        CUBE(new ModeCube(), "modeCube"),
        CYLINDER(new ModeCylinder(), "modeCylinder"),
        PYRAMID(new ModePyramid(), "modePyramid"),
        SPHERE(new ModeSphere(), "modeSphere"),
        TUBE(new ModeTube(), "modeTube");

        public final IProjectorMode mode;
        public final String name;

        @SideOnly(Side.CLIENT)
        public IIcon icon;

        Modes(IProjectorMode mode, String name)
        {
            this.mode = mode;
            this.name = name;
        }

        public ItemStack toStack()
        {
            return new ItemStack(ModularForceFieldSystem.modeCard, 1, ordinal());
        }

        public static Modes get(ItemStack stack)
        {
            if (stack != null && stack.getItemDamage() >= 0 && stack.getItemDamage() < values().length)
            {
                return values()[stack.getItemDamage()];
            }
            return CUBE;
        }

        public static Modes get(int meta)
        {
            if (meta >= 0 && meta < values().length)
            {
                return values()[meta];
            }
            return CUBE;
        }
    }
}