package me.arasple.mc.brevis.module.listener

import me.arasple.mc.brevis.module.shortcut.Session
import me.arasple.mc.brevis.module.shortcut.Track
import me.arasple.mc.brevis.module.shortcut.TrackType
import me.arasple.mc.brevis.util.getSession
import org.bukkit.event.player.*
import org.bukkit.inventory.EquipmentSlot
import taboolib.common.platform.event.EventPriority
import taboolib.common.platform.event.SubscribeEvent
import taboolib.common.platform.function.info
import taboolib.module.nms.MinecraftVersion
import taboolib.platform.event.PlayerJumpEvent

/**
 * @author Arasple
 * @date 2021/2/25 11:30
 */
object ListenerAction {

    @SubscribeEvent(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    fun e(e: PlayerInteractEvent) {
        if (MinecraftVersion.major >= 1 && e.hand == EquipmentSlot.OFF_HAND) return

        e.isCancelled = e.player.getSession().post(Track(TrackType.INTERACT, e.action.ordinal))
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    fun e(e: PlayerJumpEvent) {
        e.isCancelled = e.player.getSession().post(Track(TrackType.JUMP))
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    fun e(e: PlayerSwapHandItemsEvent) {
        e.isCancelled = e.player.getSession().post(Track(TrackType.OFFHAND))
    }

    @SubscribeEvent
    fun e(e: PlayerQuitEvent) {
        Session.delete(e.player)
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    fun e(e: PlayerToggleSneakEvent) {
        if (e.isSneaking) {
            e.player.getSession().post(Track(TrackType.SNEAKING))
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    fun e(e: PlayerItemHeldEvent) {
        e.isCancelled = e.player.getSession().post(Track(TrackType.SWAP, e.newSlot + 1))
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    fun e(e: PlayerDropItemEvent) {
        info("Called")
        e.isCancelled = e.player.getSession().post(Track(TrackType.DROP))
    }



}