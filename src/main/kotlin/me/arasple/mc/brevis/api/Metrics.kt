package me.arasple.mc.brevis.api

import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.platform.BukkitPlugin
import taboolib.module.metrics.Metrics
import taboolib.module.metrics.charts.SingleLineChart

/**
 * @author Arasple
 * @date 2021/2/25 13:39
 */
object Metrics {

    private val metrics: Metrics by lazy {
        Metrics(
            10469,
            BukkitPlugin.getInstance().description.version,
            Platform.BUKKIT
        )
    }

    @Awake(LifeCycle.ACTIVE)
    fun initialization() {
        metrics.run {
            addCustomChart(SingleLineChart("shortcuts") {
                Settings.INSTANCE.shortcuts.size
            })
        }
    }

}