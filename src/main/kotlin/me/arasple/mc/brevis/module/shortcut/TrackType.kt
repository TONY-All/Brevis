package me.arasple.mc.brevis.module.shortcut

/**
 * @author Arasple
 * @date 2021/2/25 11:39
 */
@JvmInline
value class TrackType(val index: Int) {

    companion object {

        val SNEAKING = TrackType(0)

        val OFFHAND = TrackType(1)

        val SWAP = TrackType(2)

        val JUMP = TrackType(3)

        val INTERACT = TrackType(4)

        val DROP = TrackType(5)

        fun of(name: String): TrackType? {
            return when (name.uppercase()) {
                "SNEAK", "SNEAKING", "SHIFT" -> SNEAKING
                "OFFHAND", "F" -> OFFHAND
                "SWAP" -> SWAP
                "JUMP", "SPACE" -> JUMP
                "INTERACT" -> INTERACT
                "DROP", "THROW", "Q" -> DROP
                else -> null
            }
        }

    }

}