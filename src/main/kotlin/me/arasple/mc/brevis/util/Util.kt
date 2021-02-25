package me.arasple.mc.brevis.util

import me.arasple.mc.brevis.module.shortcut.Session
import org.bukkit.entity.Player

/**
 * @author Arasple
 * @date 2021/2/25 12:02
 */
fun Player.getSession(): Session {
    return Session.get(this)
}