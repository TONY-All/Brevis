package me.arasple.mc.brevis.module.listener

import io.izzel.taboolib.Version
import io.izzel.taboolib.module.inject.TListener
import me.arasple.mc.brevis.module.shortcut.Track
import me.arasple.mc.brevis.module.shortcut.TrackType
import me.arasple.mc.brevis.util.getSession
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.EquipmentSlot

/**
 * @author Arasple
 * @date 2021/2/25 11:30
 */
@TListener
class ListenerInteract : Listener {

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    fun e(e: PlayerInteractEvent) {
        if (Version.isAfter(Version.v1_9) && e.hand == EquipmentSlot.OFF_HAND) return

        e.isCancelled = e.player.getSession().post(Track(TrackType.INTERACT, e.action.ordinal))
    }

}