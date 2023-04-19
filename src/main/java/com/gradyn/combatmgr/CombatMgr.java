package com.gradyn.combatmgr;

import com.gradyn.combatmgr.commands.DuelCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class CombatMgr extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("duel").setExecutor(new DuelCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
