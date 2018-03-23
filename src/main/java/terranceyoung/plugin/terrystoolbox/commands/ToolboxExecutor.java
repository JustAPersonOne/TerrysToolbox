package terranceyoung.plugin.terrystoolbox.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import terranceyoung.plugin.terrystoolbox.TerrysToolbox;
import terranceyoung.plugin.terrystoolbox.utils.StringArrayToString;
import terranceyoung.plugin.terrystoolbox.utils.StringReplacer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToolboxExecutor implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(args.length == 0) {
            helpCommand(sender);
            return true;
        }

        if(args[0].equalsIgnoreCase("help")) {
            helpCommand(sender);
        }
        else if(args[0].equalsIgnoreCase("version")) {
            versionCommand(sender);
        }
        else if(args[0].equalsIgnoreCase("update")) {
            updateCommand(sender);
        }
        else if (args[0].equalsIgnoreCase("save")) {
            saveCommand(sender);
        }
        else if (args[0].equalsIgnoreCase("convert")) {
            convertCommand(sender, args);
        }
        else {
            sender.sendMessage(ChatColor.GOLD + "Sorry! " + ChatColor.DARK_RED + "That is not a command!");
            helpCommand(sender);
        }

        return true;
    }

    private void helpCommand(CommandSender sender) {
        if(!sender.hasPermission("terrystoolbox.help")) {
            sender.sendMessage(ChatColor.DARK_RED + "Sorry! " + ChatColor.RED + "You don't have permission to use that command!");
        }
        else {
            sender.sendMessage(ChatColor.GOLD + "Terrance Young's Toolbox" + ChatColor.YELLOW + " - A User's Guide");
            sender.sendMessage(ChatColor.YELLOW + "------------------------");
            sender.sendMessage(ChatColor.GOLD + "/tyatbac help: " + ChatColor.YELLOW + "This dialog.");
            sender.sendMessage(ChatColor.GOLD + "/tyatbac version: " + ChatColor.YELLOW + "Shows the version of Terrance Young's Toolbox.");
            sender.sendMessage(ChatColor.GOLD + "/tyatbac update: " + ChatColor.YELLOW + "Updates player data files with the current online players.");
            sender.sendMessage(ChatColor.GOLD + "/tyatbac save: " + ChatColor.YELLOW + "Saves all Terry's Toolbox related data (But not dependent plugin data!).");
            sender.sendMessage(ChatColor.GOLD + "/tyatbac convert <text>: " + ChatColor.YELLOW + "Tests coloured text conversion.");
        }
    }

    private void versionCommand(CommandSender sender) {
        if(!sender.hasPermission("terrystoolbox.version")) {
            sender.sendMessage(ChatColor.DARK_RED + "Sorry! " + ChatColor.RED + "You don't have permission to use that command!");
        }
        else {
            sender.sendMessage(ChatColor.GOLD + "Terrance Young's Toolbox" + ChatColor.YELLOW + " - Version 1.1.0");
        }
    }

    private void updateCommand(CommandSender sender) {
        if(!sender.hasPermission("terrystoolbox.update")) {
            sender.sendMessage(ChatColor.DARK_RED + "Sorry! " + ChatColor.RED + "You don't have permission to use that command!");
        }
        else {
            TerrysToolbox.playerData.addAllOnlinePlayers();
            sender.sendMessage(ChatColor.GOLD + "Updated player data with all online players");
        }
    }

    private void saveCommand(CommandSender sender) {
        if(!sender.hasPermission("terrystoolbox.save")) {
            sender.sendMessage(ChatColor.DARK_RED + "Sorry! " + ChatColor.RED + "You don't have permission to use that command!");
        }
        else {
            TerrysToolbox.playerData.save();
            sender.sendMessage(ChatColor.GOLD + "Saved all Terry's Toolbox data");
        }
    }

    private void convertCommand(CommandSender sender, String[] args) {
        if(!sender.hasPermission("terrystoolbox.convert")) {
            sender.sendMessage(ChatColor.DARK_RED + "Sorry! " + ChatColor.RED + "You don't have permission to use that command!");
        }
        else {
            String convertedString = StringArrayToString.convertStringArrayToString(args, " ");

            sender.sendMessage(StringReplacer.replaceString(convertedString));
        }
    }
}
