package me.arasple.mc.brevis

import me.arasple.mc.brevis.api.Settings
import org.bukkit.Bukkit
import taboolib.common.platform.Plugin
import taboolib.common.platform.function.console
import taboolib.module.lang.sendLang
import taboolib.module.nms.MinecraftVersion
import taboolib.platform.BukkitPlugin

/**
 * @author Arasple
 * @date 2021/2/25 11:12
 */
object Brevis : Plugin() {

    override fun onLoad() {
        console().sendLang("Plugin-Loading", Bukkit.getBukkitVersion())
    }

    override fun onEnable() {
        if (MinecraftVersion.major < 1) {
            console().sendLang("Plugin-Unsupported-Version", BukkitPlugin.getInstance().description.version)
            Bukkit.getPluginManager().disablePlugin(BukkitPlugin.getInstance())
            return
        }

        console().sendLang("Plugin-Enabled", BukkitPlugin.getInstance().description.version)
        Settings.init()
    }

    override fun onDisable() {

    }

}