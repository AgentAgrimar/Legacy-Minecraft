package wily.legacy.client.screen;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.ConfirmLinkScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.WinScreen;
import net.minecraft.network.chat.Component;
//import wily.legacy.client.LegacyTip;

public class HelpOptionsScreen extends RenderableVListScreen {
    public HelpOptionsScreen(Screen parent) {
        super(parent,Component.translatable("options.title"), r-> {});
        renderableVList.addRenderables(Button.builder(Component.translatable("legacy.menu.change_skin"),ConfirmLinkScreen.confirmLink(this,"https://www.minecraft.net/en-us/msaprofile/mygames/editskin")).build()
            ,Button.builder(Component.translatable("legacy.menu.how_to_play"),ConfirmLinkScreen.confirmLink(this,"https://help.minecraft.net/hc/en-us/sections/12618583497869")).build()
            ,openScreenButton(Component.translatable("controls.title"),()-> new RenderableVListScreen(this,Component.translatable("controls.title"),r->r.addRenderables(Button.builder(Component.translatable("options.mouse_settings.title"), button -> this.minecraft.setScreen(new PanelVListScreen(r.screen,250,110,Component.translatable("options.mouse_settings.title"), minecraft.options.invertYMouse(), minecraft.options.mouseWheelSensitivity(), minecraft.options.discreteMouseScroll(), minecraft.options.touchscreen()))).build(),Button.builder(Component.translatable("controls.keybinds.title"), button -> this.minecraft.setScreen(new LegacyKeyBindsScreen(r.screen,minecraft.options))).build(),Button.builder(Component.translatable("legacy.controls.controller"), button -> this.minecraft.setScreen(new ControllerMappingScreen(r.screen,minecraft.options))).build()))).build()
            ,openScreenButton(Component.translatable("legacy.menu.settings"),()->new SettingsScreen(this)).build()
            ,openScreenButton(Component.translatable("credits_and_attribution.button.credits"),()->new RenderableVListScreen(this,Component.translatable("credits_and_attribution.screen.title"),r-> r.addRenderables(openScreenButton(Component.translatable("credits_and_attribution.button.credits"),()->new WinScreen(false, () -> this.minecraft.setScreen(r.screen))).build(),Button.builder(Component.translatable("credits_and_attribution.button.attribution"), ConfirmLinkScreen.confirmLink(this,"https://aka.ms/MinecraftJavaAttribution")).build(),Button.builder(Component.translatable("credits_and_attribution.button.licenses"), ConfirmLinkScreen.confirmLink(this,"https://aka.ms/MinecraftJavaLicenses")).build()))).build()
        );
        this.parent = parent;
    }
}
