package liquidmechanics.common.tileentity;

import liquidmechanics.api.IReadOut;
import liquidmechanics.api.ITankOutputer;
import liquidmechanics.api.helpers.TankHelper;
import liquidmechanics.common.block.BlockReleaseValve;
import liquidmechanics.common.handlers.LiquidData;
import liquidmechanics.common.handlers.LiquidHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.liquids.ILiquidTank;
import net.minecraftforge.liquids.ITankContainer;
import net.minecraftforge.liquids.LiquidContainerRegistry;
import net.minecraftforge.liquids.LiquidStack;
import net.minecraftforge.liquids.LiquidTank;
import universalelectricity.prefab.implement.IRedstoneReceptor;

public class TileEntityReleaseValve extends TileEntity implements ITankOutputer, IReadOut, IRedstoneReceptor
{
    public LiquidData type = LiquidHandler.air;
    public LiquidTank tank = new LiquidTank(LiquidContainerRegistry.BUCKET_VOLUME);
    public TileEntity[] connected = new TileEntity[6];
    private int count = 0;
    public boolean isPowered = false;
    public boolean converted = false;

    @Override
    public void updateEntity()
    {
        super.updateEntity();
        this.connected = TankHelper.getSourounding(worldObj, xCoord, yCoord, zCoord);
        if (!this.worldObj.isRemote && count++ == 10)
        {
            BlockReleaseValve.checkForPower(worldObj, xCoord, yCoord, zCoord);
            if (tank.getLiquid() == null)
            {
                tank.setLiquid(LiquidHandler.getStack(this.type, 1));
            }
            if (tank.getLiquid() != null && tank.getLiquid().amount < tank.getCapacity() && !isPowered)
            {
                for (int i = 0; i < 6; i++)
                {
                    ForgeDirection dir = ForgeDirection.getOrientation(i);
                    if (connected[i] instanceof ITankContainer && !(connected[i] instanceof TileEntityPipe))
                    {
                        ILiquidTank[] tanks = ((ITankContainer) connected[i]).getTanks(dir);
                        for (int t = 0; t < tanks.length; t++)
                        {
                            LiquidStack ll = tanks[t].getLiquid();
                            if (ll != null && LiquidHandler.isEqual(ll, this.type))
                            {
                                int drainVol = tank.getCapacity() - tank.getLiquid().amount - 1;
                                LiquidStack drained = ((ITankContainer) connected[i]).drain(t, drainVol, true);
                                int f = this.tank.fill(drained, true);
                            }
                        }
                    }
                }
            }
            count = 0;
            LiquidStack stack = tank.getLiquid();
            if (stack != null && !isPowered)
                for (int i = 0; i < 6; i++)
                {

                    if (connected[i] instanceof TileEntityPipe)
                    {
                        int ee = ((TileEntityPipe) connected[i]).fill(ForgeDirection.getOrientation(i), stack, true);
                        this.tank.drain(ee, true);
                    }

                }
        }
    }

    @Override
    public int fill(ForgeDirection from, LiquidStack resource, boolean doFill)
    {
        return 0;
    }

    @Override
    public int fill(int tankIndex, LiquidStack resource, boolean doFill)
    {
        if (tankIndex != 0 || resource == null)
            return 0;
        return tank.fill(resource, doFill);
    }

    @Override
    public LiquidStack drain(ForgeDirection from, int maxDrain, boolean doDrain)
    {
        return null;
    }

    @Override
    public LiquidStack drain(int tankIndex, int maxDrain, boolean doDrain)
    {
        return null;
    }

    @Override
    public ILiquidTank[] getTanks(ForgeDirection direction)
    {
        return new ILiquidTank[] { this.tank };
    }

    @Override
    public ILiquidTank getTank(ForgeDirection direction, LiquidStack type)
    {
        return null;
    }

    @Override
    public int presureOutput(LiquidData type, ForgeDirection dir)
    {
        if (type == this.type) { return LiquidData.getPressure(type); }
        return 0;
    }

    @Override
    public boolean canPressureToo(LiquidData type, ForgeDirection dir)
    {
        if (type == this.type)
            return true;
        return false;
    }

    @Override
    public String getMeterReading(EntityPlayer user, ForgeDirection side)
    {
        if (type == null) return "Error: No Type";
        String output = "";
        LiquidStack stack = tank.getLiquid();
        if (stack != null)
            output += (stack.amount / LiquidContainerRegistry.BUCKET_VOLUME) + " " + LiquidData.getName(type) + " on = " + !this.isPowered;
        if (stack != null)
            return output;
        return "0/0 " + LiquidData.getName(type) + " on = " + !this.isPowered;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        this.type = LiquidHandler.get(nbt.getString("name"));
        this.converted = nbt.getBoolean("converted");
        if (!converted)
        {
            int t = nbt.getInteger("type");
            this.type = LiquidHandler.getFromMeta(t);
            this.converted = true;
        }
        if (this.type == null) type = LiquidHandler.air;
        int vol = nbt.getInteger("liquid");
        this.tank.setLiquid(LiquidHandler.getStack(type, vol));
    }

    /**
     * Writes a tile entity to NBT.
     */
    @Override
    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setBoolean("converted", this.converted);
        int s = 0;
        if (tank.getLiquid() != null) s = tank.getLiquid().amount;
        nbt.setInteger("liquid", s);

        nbt.setString("name", LiquidData.getName(type));
    }

    public void setType(LiquidData dm)
    {
        this.type = dm;

    }

    @Override
    public void onPowerOn()
    {
        this.isPowered = true;

    }

    @Override
    public void onPowerOff()
    {
        this.isPowered = false;

    }

}
