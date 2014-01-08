package resonantinduction.transport;

import java.io.File;
import java.util.Arrays;
import java.util.logging.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;

import org.modstats.Modstats;

import resonantinduction.api.coding.TaskRegistry;
import resonantinduction.blocks.BlockBasalt;
import resonantinduction.blocks.BlockColorGlass;
import resonantinduction.blocks.BlockColorGlowGlass;
import resonantinduction.blocks.BlockColorSand;
import resonantinduction.blocks.BlockGasOre;
import resonantinduction.blocks.BlockOre;
import resonantinduction.blocks.BlockOre.OreData;
import resonantinduction.blocks.GasOreGenerator;
import resonantinduction.blocks.ItemBlockColored;
import resonantinduction.core.ResonantInductionTabs;
import resonantinduction.core.Settings;
import resonantinduction.core.debug.BlockDebug;
import resonantinduction.core.multimeter.ItemReadoutTools;
import resonantinduction.core.network.PacketIDTile;
import resonantinduction.core.recipe.RecipeLoader;
import resonantinduction.core.resource.ItemBlockOre;
import resonantinduction.core.resource.ItemOreDirv;
import resonantinduction.core.resource.ItemParts;
import resonantinduction.core.resource.ItemParts.Parts;
import resonantinduction.energy.battery.BlockBatteryBox;
import resonantinduction.energy.battery.ItemBattery;
import resonantinduction.energy.battery.ItemBlockEnergyStorage;
import resonantinduction.fluid.EnumGas;
import resonantinduction.fluid.pipes.BlockPipe;
import resonantinduction.fluid.pipes.FluidPartsMaterial;
import resonantinduction.fluid.pipes.ItemBlockPipe;
import resonantinduction.fluid.pump.BlockConstructionPump;
import resonantinduction.fluid.pump.BlockDrain;
import resonantinduction.fluid.pump.BlockPumpMachine;
import resonantinduction.mechanics.armbot.BlockArmbot;
import resonantinduction.mechanics.armbot.command.TaskBreak;
import resonantinduction.mechanics.armbot.command.TaskDrop;
import resonantinduction.mechanics.armbot.command.TaskEnd;
import resonantinduction.mechanics.armbot.command.TaskFire;
import resonantinduction.mechanics.armbot.command.TaskGOTO;
import resonantinduction.mechanics.armbot.command.TaskGive;
import resonantinduction.mechanics.armbot.command.TaskGrabEntity;
import resonantinduction.mechanics.armbot.command.TaskGrabItem;
import resonantinduction.mechanics.armbot.command.TaskHarvest;
import resonantinduction.mechanics.armbot.command.TaskIF;
import resonantinduction.mechanics.armbot.command.TaskIdle;
import resonantinduction.mechanics.armbot.command.TaskPlace;
import resonantinduction.mechanics.armbot.command.TaskReturn;
import resonantinduction.mechanics.armbot.command.TaskRotateBy;
import resonantinduction.mechanics.armbot.command.TaskRotateTo;
import resonantinduction.mechanics.armbot.command.TaskStart;
import resonantinduction.mechanics.armbot.command.TaskTake;
import resonantinduction.mechanics.armbot.command.TaskUse;
import resonantinduction.mechanics.generator.BlockSmallSteamGen;
import resonantinduction.mechanics.generator.BlockSolarPanel;
import resonantinduction.mechanics.processor.BlockProcessor;
import resonantinduction.misc.EntityFarmEgg;
import resonantinduction.misc.EnumBird;
import resonantinduction.tool.BehaviorDispenseEgg;
import resonantinduction.tool.ItemColoredDust;
import resonantinduction.tool.ItemCommonTool;
import resonantinduction.tool.ItemFarmEgg;
import resonantinduction.transport.belt.BlockConveyorBelt;
import resonantinduction.transport.crate.BlockCrate;
import resonantinduction.transport.crate.ItemBlockCrate;
import resonantinduction.transport.encoder.BlockEncoder;
import resonantinduction.transport.encoder.ItemDisk;
import resonantinduction.transport.fluid.BlockKitchenSink;
import resonantinduction.transport.fluid.BlockReleaseValve;
import resonantinduction.transport.fluid.BlockTank;
import resonantinduction.transport.fluid.ItemFluidCan;
import resonantinduction.transport.hopper.BlockAdvancedHopper;
import resonantinduction.transport.imprinter.BlockImprinter;
import resonantinduction.transport.imprinter.ItemImprinter;
import resonantinduction.transport.levitator.BlockLevitator;
import resonantinduction.transport.levitator.ItemBlockContractor;
import resonantinduction.transport.levitator.TileEMLevitator;
import resonantinduction.transport.logistic.BlockDetector;
import resonantinduction.transport.logistic.BlockManipulator;
import resonantinduction.transport.logistic.BlockRejector;
import resonantinduction.transport.vechicle.EntityTestCar;
import resonantinduction.transport.vechicle.ItemVehicleSpawn;
import calclavia.lib.network.PacketHandler;
import calclavia.lib.ore.OreGenReplaceStone;
import calclavia.lib.ore.OreGenerator;

import com.builtbroken.minecraft.CoreRegistry;
import com.builtbroken.minecraft.DarkCore;
import com.builtbroken.minecraft.EnumMaterial;
import com.builtbroken.minecraft.EnumOrePart;
import com.builtbroken.minecraft.FluidHelper;
import com.builtbroken.minecraft.LaserEntityDamageSource;
import com.builtbroken.minecraft.TranslationHelper;
import com.builtbroken.minecraft.helpers.PlayerKeyHandler;
import com.builtbroken.minecraft.prefab.ItemBlockHolder;
import com.builtbroken.minecraft.save.SaveManager;
import com.builtbroken.minecraft.tilenetwork.prefab.NetworkUpdateHandler;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.Metadata;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = ResonantInductionTransport.MOD_ID, name = ResonantInductionTransport.MOD_NAME, version = ResonantInductionTransport.VERSION, useMetadata = true)
@NetworkMod(channels = { ResonantInductionTransport.CHANNEL }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class ResonantInductionTransport
{
	public static final String TEXTURE_DIRECTORY = "textures/";
	public static final String BLOCK_DIRECTORY = TEXTURE_DIRECTORY + "blocks/";
	public static final String ITEM_DIRECTORY = TEXTURE_DIRECTORY + "items/";
	public static final String MODEL_DIRECTORY = TEXTURE_DIRECTORY + "models/";
	public static final String GUI_DIRECTORY = TEXTURE_DIRECTORY + "gui/";
	public static final String CHANNEL = "ALChannel";

	// @Mod
	public static final String MOD_ID = "AssemblyLine";
	public static final String MOD_NAME = "Assembly Line";

	public static final String DOMAIN = "al";
	public static final String PREFIX = DOMAIN + ":";

	public static String DIRECTORY_NO_SLASH = "assets/" + DOMAIN + "/";
	public static String DIRECTORY = "/" + DIRECTORY_NO_SLASH;
	public static String LANGUAGE_PATH = DIRECTORY + "languages/";
	public static String SOUND_PATH = DIRECTORY + "audio/";

	@SidedProxy(clientSide = "com.builtbroken.assemblyline.client.ClientProxy", serverSide = "com.builtbroken.assemblyline.CommonProxy")
	public static CommonProxy proxy;

	@Instance(ResonantInductionTransport.MOD_ID)
	public static ResonantInductionTransport instance;

	@Metadata(ResonantInductionTransport.MOD_ID)
	public static ModMetadata meta;

	private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US", "de_DE" };

	public static final Configuration CONFIGURATION = new Configuration(new File(Loader.instance().getConfigDir(), "AssemblyLine.cfg"));

	public static Logger FMLog = Logger.getLogger(ResonantInductionTransport.MOD_NAME);

	public static boolean VINALLA_RECIPES = false;

	public static int entitiesIds = 60;

	private static PacketIDTile tilePacket;

	public static Block blockEMContractor;

	public static PacketIDTile getTilePacket()
	{
		if (tilePacket == null)
		{
			tilePacket = new PacketIDTile(ResonantInductionTransport.CHANNEL);
		}
		return tilePacket;
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		CONFIGURATION.load();

		blockEMContractor = new BlockLevitator(Settings.getNextBlockID());
		GameRegistry.registerBlock(blockEMContractor, ItemBlockContractor.class, blockEMContractor.getUnlocalizedName());
		GameRegistry.registerTileEntity(TileEMLevitator.class, blockEMContractor.getUnlocalizedName());

		DarkCore.instance().preLoad();
		Modstats.instance().getReporter().registerMod(this);
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(new FluidHelper());
		MinecraftForge.EVENT_BUS.register(SaveManager.instance());
		TickRegistry.registerTickHandler(NetworkUpdateHandler.instance(), Side.SERVER);
		TickRegistry.registerScheduledTickHandler(new PlayerKeyHandler(ResonantInductionTransport.CHANNEL), Side.CLIENT);
		MinecraftForge.EVENT_BUS.register(new LaserEntityDamageSource(null));
		NetworkRegistry.instance().registerGuiHandler(this, proxy);

		TaskRegistry.registerCommand(new TaskDrop());
		TaskRegistry.registerCommand(new TaskGive());
		TaskRegistry.registerCommand(new TaskTake());
		TaskRegistry.registerCommand(new TaskGrabItem());
		TaskRegistry.registerCommand(new TaskGrabEntity());
		TaskRegistry.registerCommand(new TaskRotateBy());
		TaskRegistry.registerCommand(new TaskRotateTo());
		TaskRegistry.registerCommand(new TaskUse());
		TaskRegistry.registerCommand(new TaskIF());
		TaskRegistry.registerCommand(new TaskGOTO());
		TaskRegistry.registerCommand(new TaskReturn());
		TaskRegistry.registerCommand(new TaskEnd());
		TaskRegistry.registerCommand(new TaskFire());
		TaskRegistry.registerCommand(new TaskHarvest());
		TaskRegistry.registerCommand(new TaskPlace());
		TaskRegistry.registerCommand(new TaskBreak());
		TaskRegistry.registerCommand(new TaskStart());
		TaskRegistry.registerCommand(new TaskIdle());

		this.registerObjects();
		proxy.preInit();
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		DarkCore.instance().Load();

		FMLog.info("Loaded: " + TranslationHelper.loadLanguages(LANGUAGE_PATH, LANGUAGES_SUPPORTED) + " languages.");

		for (EnumGas gas : EnumGas.values())
		{
			FluidRegistry.registerFluid(gas.getGas());
		}
		if (RecipeLoader.blockGas != null)
		{
			EnumGas.NATURAL_GAS.getGas().setBlockID(RecipeLoader.blockGas);
		}
		if (RecipeLoader.blockGas != null)
		{
			GameRegistry.registerWorldGenerator(new GasOreGenerator());
		}
		if (RecipeLoader.blockOre != null)
		{
			for (OreData data : OreData.values())
			{
				if (data.doWorldGen)
				{
					OreGenReplaceStone gen = data.getGeneratorSettings();
					if (gen != null)
					{
						OreGenerator.addOre(gen);
					}
				}
			}
		}
		if (RecipeLoader.itemParts != null)
		{
			for (Parts part : Parts.values())
			{
				OreDictionary.registerOre(part.name, new ItemStack(RecipeLoader.itemParts, 1, part.ordinal()));
			}
		}
		proxy.init();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		DarkCore.instance().postLoad();
		proxy.postInit();
		RecipeLoader.instance().loadRecipes();
		CONFIGURATION.save();
	}

	/** Separated method for registering & creating objects */
	public void registerObjects()
	{

		/* BLOCKS */
		RecipeLoader.blockConveyorBelt = CoreRegistry.createNewBlock("ALBlockConveyor", ResonantInductionTransport.MOD_ID, BlockConveyorBelt.class);
		RecipeLoader.blockManipulator = CoreRegistry.createNewBlock("Manipulator", ResonantInductionTransport.MOD_ID, BlockManipulator.class);
		RecipeLoader.blockCrate = (BlockCrate) CoreRegistry.createNewBlock("Crate", ResonantInductionTransport.MOD_ID, BlockCrate.class, ItemBlockCrate.class);
		RecipeLoader.blockImprinter = CoreRegistry.createNewBlock("Imprinter", ResonantInductionTransport.MOD_ID, BlockImprinter.class);
		RecipeLoader.blockDetector = CoreRegistry.createNewBlock("Detector", ResonantInductionTransport.MOD_ID, BlockDetector.class);

		RecipeLoader.blockRejector = CoreRegistry.createNewBlock("Rejector", ResonantInductionTransport.MOD_ID, BlockRejector.class);
		RecipeLoader.blockEncoder = CoreRegistry.createNewBlock("Encoder", ResonantInductionTransport.MOD_ID, BlockEncoder.class);
		RecipeLoader.blockArmbot = CoreRegistry.createNewBlock("Armbot", ResonantInductionTransport.MOD_ID, BlockArmbot.class);
		RecipeLoader.blockTurntable = CoreRegistry.createNewBlock("Turntable", ResonantInductionTransport.MOD_ID, BlockTurntable.class);
		RecipeLoader.processorMachine = CoreRegistry.createNewBlock("ALBlockProcessor", ResonantInductionTransport.MOD_ID, BlockProcessor.class, ItemBlockHolder.class);

		RecipeLoader.blockAdvancedHopper = CoreRegistry.createNewBlock("ALBlockHopper", ResonantInductionTransport.MOD_ID, BlockAdvancedHopper.class, ItemBlockHolder.class);
		RecipeLoader.blockPipe = CoreRegistry.createNewBlock("FMBlockPipe", ResonantInductionTransport.MOD_ID, BlockPipe.class, ItemBlockPipe.class);
		RecipeLoader.blockPumpMachine = CoreRegistry.createNewBlock("FMBlockPump", ResonantInductionTransport.MOD_ID, BlockPumpMachine.class, ItemBlockHolder.class);
		RecipeLoader.blockReleaseValve = CoreRegistry.createNewBlock("FMBlockReleaseValve", ResonantInductionTransport.MOD_ID, BlockReleaseValve.class, ItemBlockHolder.class);
		RecipeLoader.blockTank = CoreRegistry.createNewBlock("FMBlockTank", ResonantInductionTransport.MOD_ID, BlockTank.class, ItemBlockPipe.class);

		RecipeLoader.blockSink = CoreRegistry.createNewBlock("FMBlockSink", ResonantInductionTransport.MOD_ID, BlockKitchenSink.class, ItemBlockHolder.class);
		RecipeLoader.blockDrain = CoreRegistry.createNewBlock("FMBlockDrain", ResonantInductionTransport.MOD_ID, BlockDrain.class, ItemBlockHolder.class);
		RecipeLoader.blockConPump = CoreRegistry.createNewBlock("FMBlockConstructionPump", ResonantInductionTransport.MOD_ID, BlockConstructionPump.class, ItemBlockHolder.class);
		RecipeLoader.blockSteamGen = CoreRegistry.createNewBlock("DMBlockSteamMachine", ResonantInductionTransport.MOD_ID, BlockSmallSteamGen.class, ItemBlockHolder.class);
		RecipeLoader.blockOre = CoreRegistry.createNewBlock("DMBlockOre", ResonantInductionTransport.MOD_ID, BlockOre.class, ItemBlockOre.class);

		RecipeLoader.blockWire = CoreRegistry.createNewBlock("DMBlockWire", ResonantInductionTransport.MOD_ID, BlockWire.class, ItemBlockWire.class);
		RecipeLoader.blockDebug = CoreRegistry.createNewBlock("DMBlockDebug", ResonantInductionTransport.MOD_ID, BlockDebug.class, ItemBlockHolder.class);
		RecipeLoader.blockStainGlass = CoreRegistry.createNewBlock("DMBlockStainedGlass", ResonantInductionTransport.MOD_ID, BlockColorGlass.class, ItemBlockColored.class);
		RecipeLoader.blockColorSand = CoreRegistry.createNewBlock("DMBlockColorSand", ResonantInductionTransport.MOD_ID, BlockColorSand.class, ItemBlockColored.class);
		RecipeLoader.blockBasalt = CoreRegistry.createNewBlock("DMBlockBasalt", ResonantInductionTransport.MOD_ID, BlockBasalt.class, ItemBlockColored.class);

		RecipeLoader.blockGlowGlass = CoreRegistry.createNewBlock("DMBlockGlowGlass", ResonantInductionTransport.MOD_ID, BlockColorGlowGlass.class, ItemBlockColored.class);
		RecipeLoader.blockSolar = CoreRegistry.createNewBlock("DMBlockSolar", ResonantInductionTransport.MOD_ID, BlockSolarPanel.class, ItemBlockHolder.class);
		RecipeLoader.blockGas = CoreRegistry.createNewBlock("DMBlockGas", ResonantInductionTransport.MOD_ID, BlockGasOre.class, ItemBlockHolder.class);
		RecipeLoader.blockBatBox = CoreRegistry.createNewBlock("DMBlockBatBox", ResonantInductionTransport.MOD_ID, BlockBatteryBox.class, ItemBlockEnergyStorage.class);

		/* ITEMS */
		RecipeLoader.itemTool = CoreRegistry.createNewItem("DMReadoutTools", ResonantInductionTransport.MOD_ID, ItemReadoutTools.class, true);
		RecipeLoader.battery = CoreRegistry.createNewItem("DMItemBattery", ResonantInductionTransport.MOD_ID, ItemBattery.class, true);
		RecipeLoader.wrench = CoreRegistry.createNewItem("DMWrench", ResonantInductionTransport.MOD_ID, ItemWrench.class, true);
		RecipeLoader.itemGlowingSand = CoreRegistry.createNewItem("DMItemGlowingSand", ResonantInductionTransport.MOD_ID, ItemColoredDust.class, true);
		RecipeLoader.itemDiggingTool = CoreRegistry.createNewItem("ItemDiggingTools", ResonantInductionTransport.MOD_ID, ItemCommonTool.class, true);

		RecipeLoader.itemVehicleTest = CoreRegistry.createNewItem("ItemVehicleTest", ResonantInductionTransport.MOD_ID, ItemVehicleSpawn.class, true);
		RecipeLoader.itemImprint = new ItemImprinter(CONFIGURATION.getItem("Imprint", DarkCore.getNextItemId()).getInt());
		RecipeLoader.itemDisk = new ItemDisk(CONFIGURATION.getItem("Disk", DarkCore.getNextItemId()).getInt());
		RecipeLoader.itemFluidCan = CoreRegistry.createNewItem("ItemFluidCan", ResonantInductionTransport.MOD_ID, ItemFluidCan.class, true);
		RecipeLoader.itemParts = CoreRegistry.createNewItem("DMCraftingParts", ResonantInductionTransport.MOD_ID, ItemParts.class, true);

		RecipeLoader.itemMetals = CoreRegistry.createNewItem("DMOreDirvParts", ResonantInductionTransport.MOD_ID, ItemOreDirv.class, true);
		// ALRecipeLoader.itemMPWire = CoreRegistry.createNewItem("DMMPWire", AssemblyLine.MOD_ID,
		// ItemWire.class, true);

		TileEntityAssembly.refresh_diff = CONFIGURATION.get("TileSettings", "RefreshRandomRange", 9, "n = value of config, 1 + n, random number range from 1 to n that will be added to the lowest refresh value").getInt();
		TileEntityAssembly.refresh_min_rate = CONFIGURATION.get("TileSettings", "RefreshLowestValue", 20, "Lowest value the refresh rate of the tile network will be").getInt();

		// Entities
		if (ResonantInductionTransport.CONFIGURATION.get("Override", "Eggs", true).getBoolean(true))
		{
			Item.itemsList[Item.egg.itemID] = null;
			Item.egg = null;
			Item.egg = new ItemFarmEgg(88);
			GameRegistry.registerItem(Item.egg, "FTEgg", MOD_ID);
			EntityRegistry.registerGlobalEntityID(EntityFarmEgg.class, "FarmEgg", EntityRegistry.findGlobalUniqueEntityId());
			EntityRegistry.registerModEntity(EntityFarmEgg.class, "FarmEgg", entitiesIds++, this, 64, 1, true);
			BlockDispenser.dispenseBehaviorRegistry.putObject(Item.egg, new BehaviorDispenseEgg());
		}

		EntityRegistry.registerGlobalEntityID(EntityTestCar.class, "TestCar", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(EntityTestCar.class, "TestCar", 60, this, 64, 1, true);

		for (EnumBird bird : EnumBird.values())
		{
			if (bird != EnumBird.VANILLA_CHICKEN && CONFIGURATION.get("Entities", "Enable_" + bird.name(), true).getBoolean(true))
			{
				bird.register();
			}
		}
		// Post object creation, normally creative tab icon setup
		if (RecipeLoader.blockPipe != null)
		{
			ResonantInductionTabs.tabHydraulic().setIconItemStack(FluidPartsMaterial.IRON.getStack());
		}
		else
		{
			ResonantInductionTabs.tabHydraulic().setIconItemStack(new ItemStack(Item.bucketWater));
		}
		if (RecipeLoader.itemMetals != null)
		{
			ResonantInductionTabs.tabIndustrial().itemStack = EnumMaterial.getStack(RecipeLoader.itemMetals, EnumMaterial.IRON, EnumOrePart.GEARS, 1);
			RecipeLoader.parseOreNames(CONFIGURATION);
		}
		else
		{

		}
		if (RecipeLoader.blockConveyorBelt != null)
		{
			ResonantInductionTabs.tabAutomation().setIconItemStack(new ItemStack(RecipeLoader.blockConveyorBelt));
		}
		else
		{
			ResonantInductionTabs.tabAutomation().setIconItemStack(new ItemStack(Block.pistonStickyBase));
		}

	}

	public void loadModMeta()
	{
		meta.modId = ResonantInductionTransport.MOD_ID;
		meta.name = ResonantInductionTransport.MOD_NAME;
		meta.version = ResonantInductionTransport.VERSION;
		meta.description = "Simi Realistic factory system for minecraft bring in conveyor belts, robotic arms, and simple machines";
		meta.url = "http://www.universalelectricity.com/coremachine";
		meta.logoFile = "/al_logo.png";

		meta.authorList = Arrays.asList(new String[] { "DarkGuardsman" });
		meta.credits = "Archadia - Developer" + "LiQuiD - Dev of BioTech\n" + "Hangcow - Ex-Dev Greater Security\n" + "Calclavia - Ex-CoDev of assembly line\n" + "Briman0094 - Ex-CoDev of assembly line\n" + "Elrath18 - Colored Glass, Sand, & Stone\n" + "Doppelgangerous - Researcher\n" + "Freesound.org - Sound effects\n" + "MineMan1(wdtod) - asset creation\n" + "AlphaToOmega - asset creation\n" + "pinksheep - asset creation\n" + "X-wing9 - asset creation\n" + "Azkhare - asset creation\n" + "Vexatos - German Translation\n" + "crafteverywhere - Chinese Translations\n" + "PancakeCandy - French & Dutch Translations\n";
		meta.autogenerated = false;

	}
}