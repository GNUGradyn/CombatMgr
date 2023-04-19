package com.gradyn.combatmgr.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DuelCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only in game players can initiate a duel");
            return true;
        }
        Player player = ((Player) sender);

        if (args.length != 1) return false;

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage(String.format("Player %s not found or is not online", args[0]));
            return true;
        }

        if (target.getUniqueId() == player.getUniqueId()) {
            sender.sendMessage("You cannot duel yourself!");
            return true;
        }

        return true;
    }
}
