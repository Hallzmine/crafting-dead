package com.craftingdead.mod.client.gui.screen;

import org.lwjgl.opengl.GL11;
import com.craftingdead.mod.CraftingDead;
import com.craftingdead.mod.client.gui.transition.ITransition;
import com.craftingdead.mod.client.gui.transition.Transitions;
import com.craftingdead.mod.client.util.RenderUtil;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;

public abstract class ModScreen extends Screen {

  private static final ResourceLocation BACKGROUND_TEXTURE =
      new ResourceLocation(CraftingDead.ID, "textures/gui/background.png");

  private static final ResourceLocation SMOKE_TEXTURE =
      new ResourceLocation(CraftingDead.ID, "textures/gui/smoke.png");

  private static long backgroundStartTime = Util.milliTime();

  private static long fogStartTime = Util.milliTime();

  protected ModScreen(ITextComponent title) {
    super(title);
  }

  @Override
  public void render(int mouseX, int mouseY, float partialTicks) {
    this.renderBackground();
    super.render(mouseX, mouseY, partialTicks);
  }

  @Override
  public void renderBackground() {
    if (this.minecraft.world != null) {
      this.fillGradient(0, 0, this.width, this.height, -1072689136, -804253680);
      return;
    }

    double pct =
        MathHelper.clamp(((Util.milliTime() - backgroundStartTime) / 1000.0F) / 10, 0.0F, 1.0F);
    if (pct == 1.0D) {
      backgroundStartTime = Util.milliTime();
    }

    RenderSystem.pushMatrix();
    {
      RenderSystem
          .translated(Math.sin(Math.toRadians(360 * pct)) * 2.5D,
              Math.cos(Math.toRadians(360 * pct)) * 2.5D, 0);
      double scale = 1.25D + Math.cos(Math.toRadians(360 * pct)) * 1.5D / 100.0D;
      RenderSystem.scaled(scale, scale, scale);

      double backgroundWidth = 2048;
      double backgroundHeight = 1152;
      double backgroundScale = RenderUtil.getScale(2048, 1152);
      backgroundWidth *= backgroundScale;
      backgroundHeight *= backgroundScale;

      RenderUtil.bind(BACKGROUND_TEXTURE);
      // Enable bilinear filtering
      RenderSystem.texParameter(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
      RenderUtil
          .drawTexturedRectangle((this.width / 2 - (backgroundWidth * scale) / 2),
              this.height / 2 - (backgroundHeight * scale) / 2, backgroundWidth, backgroundHeight);
    }
    RenderSystem.popMatrix();

    this.renderFog();
    this.renderFooter();
  }

  private void renderFooter() {
    final String footer = CraftingDead.DISPLAY_NAME + " " + CraftingDead.VERSION;
    RenderSystem.pushMatrix();
    {
      RenderSystem.translated(this.width / 2.0D, this.height - 5.0D, 0.0D);
      RenderSystem.scaled(0.5D, 0.5D, 0.5D);
      this.drawCenteredString(this.font, footer, 0, 0, 0xAAAAAA);
    }
    RenderSystem.popMatrix();
  }

  private void renderFog() {
    double fogWidth = 1920;
    double fogHeight = 1080;
    final double fogScale = RenderUtil.getScale(fogWidth, fogHeight);
    fogWidth *= fogScale;
    fogHeight *= fogScale;

    final double pct =
        MathHelper.clamp((Util.milliTime() - fogStartTime) / (1000.0D * 100.0D * 2.0D), 0.0D, 1.0D);
    if (pct == 1.0D) {
      fogStartTime = Util.milliTime();
    }

    RenderSystem.pushMatrix();
    {
      RenderSystem.scalef(4F, 4F, 4F);
      RenderSystem.enableBlend();
      RenderSystem.defaultBlendFunc();
      RenderSystem.color4f(1.0F, 1.0F, 1.0F, 0.3F);

      RenderUtil.bind(SMOKE_TEXTURE);

      final double smokeX = pct * this.width;

      RenderUtil.drawTexturedRectangle(smokeX, 0, fogWidth, fogHeight);
      RenderUtil.drawTexturedRectangle(smokeX - fogWidth, 0, fogWidth, fogHeight);

      RenderSystem.disableBlend();
    }
    RenderSystem.popMatrix();
  }

  public ITransition getTransition() {
    return Transitions.GROW;
  }
}