import config.ConfigurationHandler
import housing.BuildSign
import listener.PlayerInteractListener
import listener.component.ConditionalHandler
import menu.ReinforcingWorkbench
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.plugin.java.JavaPlugin

/**
 * @author karayuu
 */
class InfinityCircles : JavaPlugin() {
    override fun onEnable() {
        plugin = this

        logger.info("Starting plugin.")

        /* Register events */
        Bukkit.getPluginManager().registerEvents(PlayerInteractListener, this)

        val sendMessageOnLeftClick = ConditionalHandler<PlayerInteractEvent>(
            { event -> event.action == Action.LEFT_CLICK_AIR },
            { event -> event.player.sendMessage("Hi") })
        PlayerInteractListener.behaviorList += sendMessageOnLeftClick

        val openMenuOnLeftClickWithStick = ConditionalHandler<PlayerInteractEvent>(
                { event -> event.material == Material.STICK },
                { event -> event.player.openInventory(ReinforcingWorkbench.getMenu()) }
        )
        PlayerInteractListener.behaviorList += openMenuOnLeftClickWithStick

        BuildSign.eventRegister()

        /* Register Config */
        ConfigurationHandler.register()

        logger.info("Stated plugin.")
    }

    override fun onDisable() {
        logger.info("Stopping plugin.")

        logger.info("Stopped plugin.")
    }

    companion object {
        lateinit var plugin: InfinityCircles
    }
}
