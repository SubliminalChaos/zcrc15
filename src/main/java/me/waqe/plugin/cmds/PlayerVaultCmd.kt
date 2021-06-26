package me.waqe.plugin.cmds

import me.waqe.plugin.App.Companion.instance
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class PlayerVaultCmd : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) return true
        val inv = Bukkit.createInventory(sender, 54, "${sender.name}'s Player Vault")

        // player in hashmap?  then get contents
        if (instance.menus?.containsKey(sender.uniqueId.toString()) == true) {
            sender.sendMessage("vault exists in hashmap!")
            // a vault exists in hashmap for this player
            inv.contents = instance.menus?.get(sender.uniqueId.toString())!!
        }

        sender.openInventory(inv)
        return true
    }
}
