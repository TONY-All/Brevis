package me.arasple.mc.brevis

import me.arasple.mc.brevis.api.Settings
import me.arasple.mc.brevis.module.shortcut.Session
import org.bukkit.Bukkit
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.command.command

/**
 * @author Arasple
 * @date 2021/2/25 13:11
 */
object BrevisCommand {

    @Awake(LifeCycle.ACTIVE)
    fun registerCommand() = command("brevis", permission = "brevis.access") {
        literal("reload") {
            execute<ConsoleCommandSender> { _, _, _ ->
                Settings.onReload()
            }
        }

        literal("debug") {
            dynamic {
                restrict<CommandSender> { _, _, arg ->
                    Bukkit.getPlayerExact(arg) != null
                }

                execute<CommandSender> { sender, _, argument ->
                    val player = Bukkit.getPlayer(argument)
                    if (player == null || !player.isOnline) {
                        return@execute
                    }

                    sender.sendMessage(Session.get(player).toString())
                }
            }
        }

    }

}