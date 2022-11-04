package me.arasple.mc.brevis.module.shortcut

import me.arasple.mc.brevis.api.Settings
import org.bukkit.entity.Player

/**
 * @author Arasple
 * @date 2021/2/25 11:32
 */
class Session(private val holder: Player, private val tracks: MutableList<Track>) {

    companion object {

        private val sessions = mutableMapOf<String, Session>()

        fun get(player: Player): Session {
            return sessions.computeIfAbsent(player.name) {
                Session(player, mutableListOf())
            }
        }

        fun delete(player: Player) {
            sessions.remove(player.name)
        }

    }

    fun post(track: Track): Boolean {
        getValidTracks().add(track)
        return check()
    }

    private fun check(): Boolean {
        var matched = false
        Settings.INSTANCE.shortcuts
            .filter { it.match(tracks.takeLast(it.courses.size)) }
            .run {
                if (isNotEmpty()) {
                    matched = true
                    tracks.clear()
                    forEach { track ->
                        // TODO INTERRUPT
                        track.react(holder)
                    }
                }
            }
        return matched
    }

    // 清空缓存
    private fun getValidTracks(): MutableList<Track> {
        Settings.INSTANCE.maxTrack.run {
            while (tracks.size > this) {
                tracks.removeFirst()
            }
        }

        return tracks
    }


    override fun toString(): String {
        """
            Holder: ${holder.name}
            Tracks: ${tracks.joinToString(", ") { "${it.type.index}" }}
        """.trimIndent().let {
            return it
        }
    }

}