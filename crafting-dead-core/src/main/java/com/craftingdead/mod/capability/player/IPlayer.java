package com.craftingdead.mod.capability.player;

import java.util.UUID;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.util.INBTSerializable;

public interface IPlayer<E extends PlayerEntity> extends INBTSerializable<CompoundNBT> {

  void tick();

  /**
   * When the player is damaged; with potions and armour taken into account.
   * 
   * @param source - the source of damage
   * @param amount - the amount of damage taken
   * @return the new damage amount
   */
  float onDamaged(DamageSource source, float amount);

  /**
   * When the player is attacked.
   * 
   * @param source - the source of damage
   * @param amount - the amount of damage taken
   * @return if the event should be cancelled
   */
  boolean onAttacked(DamageSource source, float amount);

  /**
   * When the player kills another entity.
   *
   * @param target - the {@link Entity} killed
   * @return if the event should be cancelled
   */
  boolean onKill(Entity target);

  /**
   * When the player's health reaches 0.
   *
   * @param cause - the cause of death
   * @return if the event should be cancelled
   */
  boolean onDeath(DamageSource cause);

  /**
   * When the trigger button is pressed.
   *
   * @param triggerPressed - if the button is pressed
   */
  void setTriggerPressed(boolean triggerPressed, boolean sendUpdate);

  boolean isAiming();

  void toggleAiming(boolean sendUpdate);

  void toggleFireMode(boolean sendUpdate);

  void reload(boolean sendUpdate);

  void openPlayerContainer();
  
  void infect(float chance);

  int getDaysSurvived();

  void setDaysSurvived(int daysSurvived);

  int getZombiesKilled();

  void setZombiesKilled(int zombiesKilled);

  int getPlayersKilled();

  void setPlayersKilled(int playersKilled);

  int getWater();

  void setWater(int water);

  int getMaxWater();

  void setMaxWater(int maxWater);

  int getStamina();

  void setStamina(int stamina);

  int getMaxStamina();

  void setMaxStamina(int stamina);

  IInventory getInventory();

  E getEntity();

  UUID getId();
}