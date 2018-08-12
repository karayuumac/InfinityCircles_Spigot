package extension

import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.World

/**
 * @author karayuu
 */

fun World.fill(loc1: Triple<Int, Int, Int>, loc2: Triple<Int, Int, Int>, material: Material) {
    val world = this
    Bukkit.getLogger().info("$loc1 /-/ $loc2 /-/ $material")
    for (i in loc1.first..loc2.first) {
        for (j in loc1.second..loc2.second) {
            for (k in loc1.third..loc2.third) {
                world.getBlockAt(i, j, k).type = material
            }
        }
    }
}

fun Location.toTriple(): Triple<Int, Int, Int> = Triple(this.blockX, this.blockY, this.blockZ)
