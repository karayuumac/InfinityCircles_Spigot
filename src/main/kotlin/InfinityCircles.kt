import listener.MenuListener
import listener.PlayerInteractListener
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

/**
 * @author karayuu
 */
class InfinityCircles : JavaPlugin() {
    override fun onEnable() {
        logger.info("Starting plugin.")
        plugin = this

        Bukkit.getPluginManager().registerEvents(MenuListener(), this)
        Bukkit.getPluginManager().registerEvents(PlayerInteractListener(), this)

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
