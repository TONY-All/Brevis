package me.arasple.mc.brevis.api

import me.arasple.mc.brevis.module.shortcut.Shortcut
import me.arasple.mc.brevis.module.shortcut.Track
import me.arasple.mc.brevis.module.shortcut.TrackType
import taboolib.common.platform.function.console
import taboolib.common5.Coerce
import taboolib.module.configuration.Config
import taboolib.module.configuration.Configuration
import taboolib.module.lang.sendLang

/**
 * @author Arasple
 * @date 2021/2/14 16:58
 */
class Settings {

    val maxTrack by lazy {
        CONF.getInt("Shortcut.Max-Cache-Track", 5).coerceAtLeast(2)
    }

    val shortcuts by lazy {
        val start = System.nanoTime()
        CONF.getConfigurationSection("Register")?.getKeys(false)!!.mapNotNull {
            CONF.getConfigurationSection("Register.$it")?.run {
                val tracks = getStringList("courses").mapNotNull { line ->
                    val course = line.split(";", limit = 2)
                    val span = course.getOrNull(1)?.toLong() ?: -1L
                    val name = course[0].split("-", limit = 2)
                    val type = TrackType.of(name[0])
                    if (type == null) null
                    else {
                        val value = name.getOrNull(1)?.toInt() ?: -1
                        Track(type, value, span)
                    }
                }
                val reaction = get("reaction")
                val react =
                    if (reaction is List<*>) reaction.joinToString("\n") { line -> line.toString() } else reaction.toString()

                if (tracks.isNotEmpty()) {
                    return@mapNotNull Shortcut(
                        courses = tracks,
                        reaction = react
                    )
                }
                return@mapNotNull null
            }
        }.also {
            console().sendLang("Shortcut-Loaded", it.size, Coerce.format((System.nanoTime() - start).div(1000000.0)))
        }
    }


    companion object {

        @Config("settings.yml", migrate = true, autoReload = true)
        private lateinit var CONF: Configuration

        internal var INSTANCE = Settings()

        fun init() {
            CONF.onReload { onReload() }.also { onReload() }
        }

        fun onReload() {
            INSTANCE = Settings()
            INSTANCE.shortcuts
        }

    }

}