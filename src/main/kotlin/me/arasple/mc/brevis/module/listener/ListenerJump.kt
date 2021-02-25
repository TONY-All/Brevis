package me.arasple.mc.brevis.module.listener

import io.izzel.taboolib.common.event.PlayerJumpEvent
import io.izzel.taboolib.module.inject.TListener
import me.arasple.mc.brevis.module.shortcut.Track
import me.arasple.mc.brevis.module.shortcut.TrackType
import me.arasple.mc.brevis.util.getSession
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener

/**
 * @author Arasple
 * @date 2021/2/25 11:30
 */
@TListener
class ListenerJump : Listener {

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    fun e(e: PlayerJumpEvent) {
        e.isCancelled = e.player.getSession().post(Track(TrackType.JUMP))
    }

}