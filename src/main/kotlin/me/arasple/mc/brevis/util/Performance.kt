package me.arasple.mc.brevis.util

import io.izzel.taboolib.kotlin.Mirror

/**
 * @author Arasple
 * @date 2021/2/6 19:31
 */
object Performance {

    fun collect(opt: Mirror.Options.() -> Unit = {}): Mirror.MirrorCollect {
        return MIRROR.collect(opt)
    }

    inline fun check(id: String, func: () -> Unit) {
        MIRROR.check(id, func)
    }

    val MIRROR = Mirror()

}