package com.craftingdead.mod.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.craftingdead.mod.CraftingDead;
import com.craftingdead.mod.capability.SimpleCapability;
import com.craftingdead.mod.capability.player.ServerPlayer;
import com.craftingdead.mod.init.ModCapabilities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Contains common logic for the mod, implemented by the physical client and
 * physical server as integrated and dedicated servers allowing each side to
 * adjust the {@link LogicalServer} for side specific requirements
 * 
 * @author Sm0keySa1m0n
 *
 */
public abstract class LogicalServer {

	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * The {@link MinecraftServer}
	 */
	protected MinecraftServer minecraftServer;

	public void start(MinecraftServer minecraftServer) {
		this.minecraftServer = minecraftServer;
		LOGGER.info("Starting logical server");
	}

	// ================================================================================
	// Forge Events
	// ================================================================================

	@SubscribeEvent
	public void onPlayerClone(PlayerEvent.Clone event) {
		ServerPlayer that = (ServerPlayer) event.getOriginal().getCapability(ModCapabilities.PLAYER, null);
		ServerPlayer player = (ServerPlayer) event.getEntityPlayer().getCapability(ModCapabilities.PLAYER, null);
		player.copyFrom(that, event.isWasDeath());
	}

	@SubscribeEvent
	public void onAttachCapabilitiesEntity(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof EntityPlayerMP) {
			ServerPlayer player = new ServerPlayer((EntityPlayerMP) event.getObject(),
					CraftingDead.instance().getLogicalServer());
			event.addCapability(new ResourceLocation(CraftingDead.MOD_ID, "player"),
					new SimpleCapability.Provider<>(player, ModCapabilities.PLAYER));
		}
	}

}