package data.savetype.sql

import config.DatabaseYml
import org.jetbrains.exposed.sql.Database

/**
 * Created by karayuu on 2018/07/28
 */
object SQLConnector {
    fun connectToSQL() {
        val url = "jdbc:mysql://${DatabaseYml.serverName}:${DatabaseYml.port}/${DatabaseYml.databaseName}"
        val username = DatabaseYml.username
        val password = DatabaseYml.password

        Database.connect(url, DatabaseYml.driver, username, password)
    }
}
