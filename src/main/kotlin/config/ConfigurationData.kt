package config

import org.bukkit.Bukkit

/**
 * Created by karayuu on 2018/07/28
 */
class ConfigurationData<E>(val data: E)

@Suppress("UNCHECKED_CAST")
fun ConfigurationData<*>.getInt(): Int? {
    return try {
        (this as ConfigurationData<Int>).data
    } catch (e: ClassCastException) {
        Bukkit.getLogger().warning("${this.javaClass.simpleName} はInt型にキャストできません")
        e.printStackTrace()
        null
    }
}

@Suppress("UNCHECKED_CAST")
fun ConfigurationData<*>.getString(): String? {
    return try {
        (this as ConfigurationData<String>).data
    } catch (e: ClassCastException) {
        Bukkit.getLogger().warning("${this.javaClass.simpleName} はString型にキャストできません")
        e.printStackTrace()
        null
    }
}

@Suppress("UNCHECKED_CAST")
fun ConfigurationData<*>.getDouble(): Double? {
    return try {
        (this as ConfigurationData<Double>).data
    } catch (e: ClassCastException) {
        Bukkit.getLogger().warning("${this.javaClass.simpleName} はDouble型にキャストできません")
        e.printStackTrace()
        null
    }
}
