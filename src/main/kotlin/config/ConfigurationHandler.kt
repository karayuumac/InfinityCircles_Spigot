package config

/**
 * @author karayuu
 */
object ConfigurationHandler {
    private val configuraionList = listOf<AbstractConfigurationYml>(
            DatabaseYml
    )

    fun register() {
        configuraionList.forEach {
            config -> config.register()
        }
    }
}