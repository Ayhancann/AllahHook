package dev.lvstrng.argon.module.modules.client;

import dev.lvstrng.argon.event.events.TickListener;
import dev.lvstrng.argon.module.Category;
import dev.lvstrng.argon.module.Module;
import dev.lvstrng.argon.utils.EncryptedString;

public final class Crasher extends Module implements TickListener {
    public Crasher() {
        super(EncryptedString.of("Crasher"), EncryptedString.of("Packet CRLF"), -1, Category.CLIENT);
    }

    @Override
    public void onEnable() {
        eventManager.add(TickListener.class, this);
        super.onEnable();
    }

    @Override
    public void onDisable() {
        eventManager.remove(TickListener.class, this);
        super.onDisable();
    }

    @Override
    public void onTick() {
        mc.player.setSprinting(mc.player.input.pressingForward);
    }
}
