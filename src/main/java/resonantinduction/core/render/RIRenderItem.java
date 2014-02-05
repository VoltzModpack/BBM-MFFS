package resonantinduction.core.render;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import resonantinduction.electrical.battery.ItemBlockBattery;
import resonantinduction.electrical.battery.RenderBattery;
import resonantinduction.electrical.multimeter.ItemMultimeter;
import resonantinduction.electrical.multimeter.RenderMultimeter;
import resonantinduction.electrical.transformer.ItemTransformer;
import resonantinduction.electrical.transformer.RenderTransformer;
import resonantinduction.mechanical.gear.ItemGear;
import resonantinduction.mechanical.gear.ItemGearShaft;
import resonantinduction.mechanical.gear.RenderGear;
import resonantinduction.mechanical.gear.RenderGearShaft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * @author Calclavia
 * 
 */
@SideOnly(Side.CLIENT)
public class RIRenderItem implements IItemRenderer
{
	public static final RIRenderItem INSTANCE = new RIRenderItem();

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		GL11.glPushMatrix();

		if (item.getItem() instanceof ItemBlockBattery)
		{
			RenderBattery.INSTANCE.renderInventory(type, item, data);
		}
		else if (item.getItem() instanceof ItemGear)
		{
			RenderGear.INSTANCE.renderInventory(null, item.getItemDamage(), 0, null);
		}
		else if (item.getItem() instanceof ItemGearShaft)
		{
			RenderGearShaft.INSTANCE.renderInventory(null, item.getItemDamage(), 0, null);
		}
		else if (item.getItem() instanceof ItemMultimeter)
		{
			RenderMultimeter.render();
		}
		else if (item.getItem() instanceof ItemTransformer)
		{
			GL11.glTranslated(0, -0.2f, 0);
			RenderTransformer.INSTANCE.doRender();
		}

		GL11.glPopMatrix();
	}

}