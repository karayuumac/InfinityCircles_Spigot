package config

import InfinityCircles.Companion.plugin
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

/**
 * Created by karayuu on 2018/07/28
 */
object ConfigurationController {
    val map = mutableMapOf<String, >()

    fun load() {
        val dir = plugin.dataFolder
        for (file in dir.listFiles()) {

        }
    }

    private fun loadFile(file: File) {
        val fc = YamlConfiguration.loadConfiguration(file)
        for (column in fc.getValues(true)) {
            
        }
    }
}
