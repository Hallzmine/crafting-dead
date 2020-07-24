package com.craftingdead.core.capability;

import com.craftingdead.core.capability.actionprovider.DefaultActionProvider;
import com.craftingdead.core.capability.actionprovider.IActionProvider;
import com.craftingdead.core.capability.clothing.DefaultClothing;
import com.craftingdead.core.capability.clothing.IClothing;
import com.craftingdead.core.capability.gun.DefaultGun;
import com.craftingdead.core.capability.gun.IGun;
import com.craftingdead.core.capability.hat.DefaultHat;
import com.craftingdead.core.capability.hat.IHat;
import com.craftingdead.core.capability.hydration.DefaultHydration;
import com.craftingdead.core.capability.hydration.IHydration;
import com.craftingdead.core.capability.living.DefaultLiving;
import com.craftingdead.core.capability.living.ILiving;
import com.craftingdead.core.capability.magazine.DefaultMagazine;
import com.craftingdead.core.capability.magazine.IMagazine;
import com.craftingdead.core.capability.paint.DefaultPaint;
import com.craftingdead.core.capability.paint.IPaint;
import com.craftingdead.core.capability.rendererprovider.DefaultRendererProvider;
import com.craftingdead.core.capability.rendererprovider.IRendererProvider;
import com.craftingdead.core.capability.scope.DefaultScope;
import com.craftingdead.core.capability.scope.IScope;
import com.craftingdead.core.capability.storage.DefaultStorage;
import com.craftingdead.core.capability.storage.IStorage;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class ModCapabilities {

  @CapabilityInject(ILiving.class)
  public static final Capability<ILiving<?>> LIVING = null;

  @CapabilityInject(IGun.class)
  public static final Capability<IGun> GUN = null;

  @CapabilityInject(IPaint.class)
  public static final Capability<IPaint> PAINT = null;

  @CapabilityInject(IMagazine.class)
  public static final Capability<IMagazine> MAGAZINE = null;

  @CapabilityInject(IStorage.class)
  public static final Capability<IStorage> STORAGE = null;

  @CapabilityInject(IScope.class)
  public static final Capability<IScope> SCOPE = null;

  @CapabilityInject(IHydration.class)
  public static final Capability<IHydration> HYDRATION = null;

  @CapabilityInject(IClothing.class)
  public static final Capability<IClothing> CLOTHING = null;

  @CapabilityInject(IHat.class)
  public static final Capability<IHat> HAT = null;

  @CapabilityInject(IActionProvider.class)
  public static final Capability<IActionProvider> ACTION_PROVIDER = null;
  
  @CapabilityInject(IRendererProvider.class)
  public static final Capability<IRendererProvider> RENDERER_PROVIDER = null;

  public static void registerCapabilities() {
    CapabilityManager.INSTANCE.register(ILiving.class, new EmptyStorage<>(), DefaultLiving::new);
    CapabilityManager.INSTANCE.register(IGun.class, new EmptyStorage<>(), DefaultGun::new);
    CapabilityManager.INSTANCE.register(IPaint.class, new EmptyStorage<>(), DefaultPaint::new);
    CapabilityManager.INSTANCE
        .register(IMagazine.class, new EmptyStorage<>(), DefaultMagazine::new);
    CapabilityManager.INSTANCE.register(IStorage.class, new EmptyStorage<>(), DefaultStorage::new);
    CapabilityManager.INSTANCE.register(IScope.class, new EmptyStorage<>(), DefaultScope::new);
    CapabilityManager.INSTANCE
        .register(IHydration.class, new EmptyStorage<>(), DefaultHydration::new);
    CapabilityManager.INSTANCE
        .register(IClothing.class, new EmptyStorage<>(), DefaultClothing::new);
    CapabilityManager.INSTANCE.register(IHat.class, new EmptyStorage<>(), DefaultHat::new);
    CapabilityManager.INSTANCE.register(IActionProvider.class, new EmptyStorage<>(),
        DefaultActionProvider::new);
    CapabilityManager.INSTANCE.register(IRendererProvider.class, new EmptyStorage<>(),
        DefaultRendererProvider::new);
  }

  private static class EmptyStorage<C> implements Capability.IStorage<C> {

    @Override
    public INBT writeNBT(Capability<C> capability, C instance, Direction side) {
      return null;
    }

    @Override
    public void readNBT(Capability<C> capability, C instance, Direction side, INBT nbt) {}
  }
}