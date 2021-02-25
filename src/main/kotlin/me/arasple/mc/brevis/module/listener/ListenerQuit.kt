package me.arasple.mc.brevis.module.listener

import io.izzel.taboolib.module.inject.TListener
import me.arasple.mc.brevis.module.shortcut.Session
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerQuitEvent

/**
 * @author Arasple
 * @date 2021/2/25 13:15
 */
@TListener
class ListenerQuit : Listener {

    @EventHandler
    fun e(e: PlayerQuitEvent) {
        Session.delete(e.player)
    }

}