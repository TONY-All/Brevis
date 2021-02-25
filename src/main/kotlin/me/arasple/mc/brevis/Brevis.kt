package me.arasple.mc.brevis

import io.izzel.taboolib.Version
import io.izzel.taboolib.loader.Plugin
import io.izzel.taboolib.loader.PluginBoot
import io.izzel.taboolib.module.locale.TLocale
import me.arasple.mc.brevis.api.Settings
import org.bukkit.Bukkit

/**
 * @author Arasple
 * @date 2021/2/25 11:12
 */
object Brevis : Plugin() {

    override fun onLoad() {
        TLocale.sendToConsole("Plugin.Loading", Bukkit.getBukkitVersion())
    }

    override fun onEnable() {
        if (Version.isBefore(Version.v1_9)) {
            TLocale.sendToConsole("Plugin.UnsupportedVersion", plugin.description.version)
            PluginBoot.setDisabled(true)
            return
        }

        TLocale.sendToConsole("Plugin.Enabled", plugin.description.version)
        Settings.init()
    }

    override fun onDisable() {

    }

}