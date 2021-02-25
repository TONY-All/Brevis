package me.arasple.mc.brevis.api

import io.izzel.taboolib.module.inject.TFunction
import me.arasple.mc.brevis.Brevis
import org.bstats.bukkit.Metrics

/**
 * @author Arasple
 * @date 2021/2/25 13:39
 */
object Metrics {

    private val metrics: Metrics by lazy { Metrics(Brevis.plugin, 10469) }

    @TFunction.Init
    fun initialization() {
        metrics.run {
            addCustomChart(Metrics.SingleLineChart("shortcuts") {
                Settings.INSTANCE.shortcuts.size
            })
        }
    }

}