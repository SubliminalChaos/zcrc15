package me.waqe.plugin.events

import me.waqe.plugin.App
import me.waqe.plugin.App.Companion.instance
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryCloseEvent

class InvCloseEvent(instance: App) : Listener {
    @EventHandler
    fun onGUIClose(e: InventoryCloseEvent) {
        if (e.view.title.contains(e.player.name + "'s Player Vault"))
            instance.menus?.put(e.player.uniqueId.toString(), e.inventory.contents)
    }
}
