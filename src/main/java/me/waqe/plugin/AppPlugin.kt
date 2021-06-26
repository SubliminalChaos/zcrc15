package me.waqe.plugin

import me.waqe.plugin.cmds.PlayerVaultCmd
import me.waqe.plugin.cmds.VersionCmd
import me.waqe.plugin.events.InvCloseEvent
import me.waqe.plugin.events.JoinEvent
import org.bukkit.event.Listener
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin


class App : JavaPlugin(), Listener {
    companion object {
        lateinit var instance: App
    }

//    val menus: MutableMap<String, > = HashMap()
    var menus: MutableMap<String?, Array<ItemStack?>?>? = HashMap()

    override fun onEnable() {
        instance = this
        //this.reloadConfig()
        //this.saveDefaultConfig()

        server.pluginManager.registerEvents(JoinEvent(this),this)
        this.server.pluginManager.registerEvents(InvCloseEvent(this), this)
        getCommand("version")?.setExecutor(VersionCmd())
        getCommand("pv")?.setExecutor(PlayerVaultCmd())

    }

    override fun onDisable() {

    }


}
