package config

import InfinityCircles.Companion.plugin
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

/**
 * Created by karayuu on 2018/08/11
 */
abstract class abstractConfigurationYml(name: String = "") {
    private val fileName = if (name.isEmpty()) javaClass.simpleName.removePrefix("Yml") + ".yml" else "$name.yml"

    private val file = File(plugin.dataFolder, fileName)
    lateinit var fc: FileConfiguration

    /**
     * Create configFile if it does not exists.
     * Also this can be used setting the default value in the new created-file by using [File.printWriter].
     * If FileConfiguration(fc) is called in this function, it will produce NullPointerException so that it is not prepared.
     */
    open protected fun makeConfig() {
        if (!file.exists()) {
            plugin.saveResource(fileName, true)
        }
    }

    private fun load() {
        fc = YamlConfiguration.loadConfiguration(file)
    }
}
