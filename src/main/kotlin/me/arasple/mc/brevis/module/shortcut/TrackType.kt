package me.arasple.mc.brevis.module.shortcut

/**
 * @author Arasple
 * @date 2021/2/25 11:39
 */
inline class TrackType(val index: Int) {

    companion object {

        val SNEAKING = TrackType(0)

        val OFFHAND = TrackType(1)

        val SWAP = TrackType(2)

        val JUMP = TrackType(3)

        val INTERACT = TrackType(4)

        fun of(name: String): TrackType? {
            return when (name.toUpperCase()) {
                "SNEAK", "SNEAKING" -> SNEAKING
                "OFFHAND", "F" -> OFFHAND
                "SWAP" -> SWAP
                "JUMP" -> JUMP
                "INTERACT" -> INTERACT
                else -> null
            }
        }

    }

}