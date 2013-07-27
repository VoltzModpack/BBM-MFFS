package dark.core.helpers;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFluid;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.fluids.IFluidHandler;
import universalelectricity.core.vector.Vector3;

public class FluidHelper
{
    public static List<Pair<Integer, Integer>> replacableBlockMeta = new ArrayList<Pair<Integer, Integer>>();
    public static List<Block> replacableBlocks = new ArrayList<Block>();
    public static List<Block> nonBlockDropList = new ArrayList<Block>();

    static
    {
        replacableBlocks.add(Block.crops);
        replacableBlocks.add(Block.deadBush);
        nonBlockDropList.add(Block.deadBush);
        //TODO have waterlily raise and lower when automaticly filling or draining a block rather than remove it
        replacableBlocks.add(Block.waterlily);
        replacableBlocks.add(Block.mushroomRed);
        replacableBlocks.add(Block.mushroomBrown);
        replacableBlocks.add(Block.netherStalk);
        replacableBlocks.add(Block.sapling);
        replacableBlocks.add(Block.melonStem);
        nonBlockDropList.add(Block.melonStem);
        replacableBlocks.add(Block.pumpkinStem);
        nonBlockDropList.add(Block.pumpkinStem);
        replacableBlocks.add(Block.tallGrass);
        replacableBlocks.add(Block.torchWood);
    }

    /** Gets the block's fluid if it has one
     *
     * @param world - world we are working in
     * @param vector - 3D location in world
     * @return @Fluid that the block is */
    public static Fluid getLiquidFromBlock(World world, Vector3 vector)
    {
        return FluidHelper.getFluidFromBlockID(vector.getBlockID(world));
    }

    /** Gets a fluid from blockID */
    public static Fluid getFluidFromBlockID(int id)
    {
        if (Block.blocksList[id] instanceof IFluidBlock)
        {
            return ((IFluidBlock) Block.blocksList[id]).getFluid();
        }
        else if (id == Block.waterStill.blockID || id == Block.waterMoving.blockID)
        {
            return FluidRegistry.getFluid("water");
        }
        else if (id == Block.lavaStill.blockID || id == Block.lavaMoving.blockID)
        {
            return FluidRegistry.getFluid("lava");
        }
        return null;
    }

    public static FluidStack getStack(FluidStack stack, int amount)
    {
        if (stack != null)
        {
            return new FluidStack(stack.getFluid(), amount);
        }
        return stack;
    }

    public static FluidStack drainBlock(World world, Vector3 node, boolean doDrain)
    {
        if (world == null || node == null)
        {
            return null;
        }

        int blockID = node.getBlockID(world);
        int meta = node.getBlockMetadata(world);
        Block block = Block.blocksList[blockID];
        if (block != null)
        {
            if (block instanceof IFluidBlock && ((IFluidBlock) block).canDrain(world, node.intX(), node.intY(), node.intZ()))
            {
                return ((IFluidBlock) block).drain(world, node.intX(), node.intY(), node.intZ(), doDrain);
            }
            else if (block.blockID == Block.waterStill.blockID && node.getBlockMetadata(world) == 0)
            {
                if (doDrain)
                {
                    Vector3 vec = node.clone().modifyPositionFromSide(ForgeDirection.UP);
                    if (vec.getBlockID(world) == Block.waterlily.blockID)
                    {
                        vec.setBlock(world, 0, 0, 2);
                        node.setBlock(world, blockID, meta);
                    }
                    else
                    {
                        node.setBlock(world, 0, 0, 2);
                    }
                }
                return new FluidStack(FluidRegistry.getFluid("water"), FluidContainerRegistry.BUCKET_VOLUME);
            }
            else if (block.blockID == Block.lavaStill.blockID && node.getBlockMetadata(world) == 0)
            {
                if (doDrain)
                {
                    node.setBlock(world, 0, 0, 2);
                }
                return new FluidStack(FluidRegistry.getFluid("lava"), FluidContainerRegistry.BUCKET_VOLUME);
            }
        }
        return null;
    }

    /** Checks to see if a non-fluid block is able to be filled with fluid */
    public static boolean isFillableBlock(World world, Vector3 node)
    {
        if (world == null || node == null || isFillableFluid(world, node))
        {
            return false;
        }

        int blockID = node.getBlockID(world);
        int meta = node.getBlockMetadata(world);
        Block block = Block.blocksList[blockID];
        if (block == null || block.blockID == 0 || block.isAirBlock(world, node.intX(), node.intY(), node.intZ()))
        {
            return true;
        }
        else if (block.isBlockReplaceable(world, node.intX(), node.intY(), node.intZ()) || replacableBlockMeta.contains(new Pair<Integer, Integer>(blockID, meta)) || replacableBlocks.contains(block))
        {
            return true;
        }
        return false;
    }

    /** Checks to see if a fluid related block is able to be filled */
    public static boolean isFillableFluid(World world, Vector3 node)
    {
        if (world == null || node == null)
        {
            return false;
        }

        int blockID = node.getBlockID(world);
        int meta = node.getBlockMetadata(world);
        Block block = Block.blocksList[blockID];

        if (block instanceof IFluidBlock)
        {
            //TODO when added change this to call canFill and fill
            return meta != 0;
        }
        else if (block instanceof BlockFluid)
        {
            return meta != 0;
        }
        return false;
    }

    /** Helper method to fill a location with a fluid
     *
     * Note: This does not update the block to prevent the liquid from flowing
     *
     * @return */
    public static int fillBlock(World world, Vector3 node, FluidStack stack, boolean doFill)
    {
        if ((isFillableBlock(world, node) || isFillableFluid(world, node)) && stack != null && stack.amount >= FluidContainerRegistry.BUCKET_VOLUME)
        {
            if (doFill)
            {
                int blockID = node.getBlockID(world);
                int meta = node.getBlockMetadata(world);
                Block block = Block.blocksList[blockID];
                Vector3 vec = node.clone().modifyPositionFromSide(ForgeDirection.UP);

                if (block != null)
                {
                    if (block.blockID == Block.waterlily.blockID && vec.getBlockID(world) == 0)
                    {
                        vec.setBlock(world, blockID, meta);
                    }
                    else if (block != null && replacableBlocks.contains(block) && !nonBlockDropList.contains(block))
                    {
                        block.dropBlockAsItem(world, node.intX(), node.intY(), node.intZ(), meta, 1);
                        block.breakBlock(world, node.intX(), node.intY(), node.intZ(), blockID, meta);
                    }
                }

                node.setBlock(world, stack.getFluid().getBlockID(), 0, 2);
            }
            return FluidContainerRegistry.BUCKET_VOLUME;
        }
        return 0;
    }

    public static int fillTanksAllSides(World world, Vector3 origin, FluidStack stack,boolean doFill, ForgeDirection...ignore )
    {
        int filled = 0;
        FluidStack fillStack = stack != null ? stack.copy() : null;
        for(ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS)
        {
            if(fillStack == null || fillStack.amount <= 0)
            {
                return 0;
            }
            if(ignore != null)
            {
                for(int i =0; i < ignore.length; i++)
                {
                    if(direction == ignore[i])
                    {
                        continue;
                    }
                }
            }
            TileEntity entity = origin.clone().modifyPositionFromSide(direction).getTileEntity(world);
            if(entity instanceof IFluidHandler && ((IFluidHandler) entity).canFill(direction.getOpposite(), fillStack.getFluid()))
            {
                int f = ((IFluidHandler)entity).fill(direction.getOpposite(), fillStack, doFill);
               filled += f;
               fillStack.amount -=f;
            }

        }
        return filled;
    }
}
