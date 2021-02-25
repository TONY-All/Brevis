package me.arasple.mc.brevis

import io.izzel.taboolib.kotlin.Tasks
import io.izzel.taboolib.module.command.base.BaseCommand
import io.izzel.taboolib.module.command.base.BaseMainCommand
import io.izzel.taboolib.module.command.base.CommandType
import io.izzel.taboolib.module.command.base.SubCommand
import me.arasple.mc.brevis.api.Settings
import me.arasple.mc.brevis.module.shortcut.Session
import me.arasple.mc.brevis.util.Performance
import org.bukkit.Bukkit
import org.bukkit.command.CommandSender

/**
 * @author Arasple
 * @date 2021/2/25 13:11
 */
@BaseCommand(name = "brevis", permission = "brevis.access")
class BrevisCommand : BaseMainCommand() {

    @SubCommand(description = "View performance monitor")
    fun mirror(sender: CommandSender) {
        Tasks.task(true) {
            Performance.collect {
                childFormat = "§8  {0}§7{1} §2[{3} ms] §7{4}%"
                parentFormat = "§8  §8{0}§7{1} §8[{3} ms] §7{4}%"
            }.run {
                sender.sendMessage("\n§a§lBrevis §3§l§nPerformance Mirror\n§r")
                print(sender, getTotal(), 0)
            }
        }
    }

    @SubCommand(description = "Reload manually", type = CommandType.CONSOLE)
    fun reload(sender: CommandSender) {
        Settings.onReload()
    }

    @SubCommand(description = "Print debug info", arguments = ["player"])
    fun debug(sender: CommandSender, args: Array<String>) {
        val player = Bukkit.getPlayer(args[0])
        if (player == null || !player.isOnline) {
            return
        }

        sender.sendMessage(Session.get(player).toString())
    }

}