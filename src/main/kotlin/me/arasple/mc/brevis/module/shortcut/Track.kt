package me.arasple.mc.brevis.module.shortcut

/**
 * @author Arasple
 * @date 2021/2/25 11:32
 */
class Track(
    val type: TrackType,
    val value: Int = -1,
    private val span: Long = -1,
    val index: Long = System.currentTimeMillis(),
) {

    override fun equals(other: Any?): Boolean {

        return other is Track && other.type == type && other.value == value && kotlin.run {
            span < 0 || System.currentTimeMillis() - other.index < span
        }
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + value
        return result
    }

}