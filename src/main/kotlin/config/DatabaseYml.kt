package config

/**
 * @author karayuu
 */
object DatabaseYml : AbstractConfigurationYml("database") {
    const val driver = "com.mysql.jdbc.Driver"
    val serverName: String by lazy { fc.getString("serverName") }
    val port: Int by lazy { fc.getInt("port") }
    val databaseName: String by lazy { fc.getString("databaseName") }
    val username: String by lazy { fc.getString("username") }
    val password: String by lazy { fc.getString("password") }
}