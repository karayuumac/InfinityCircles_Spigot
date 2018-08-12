package extension


/**
 * @author karayuu
 */
operator fun Triple<Int, Int, Int>.plus(other: Triple<Int, Int, Int>): Triple<Int, Int, Int> {
    val first = this.first + other.first
    val second = this.second + other.second
    val third = this.third + other.third
    return Triple(first, second, third)
}

operator fun Triple<Int, Int, Int>.minus(other: Triple<Int, Int, Int>): Triple<Int, Int, Int> {
    val first = this.first - other.first
    val second = this.second - other.second
    val third = this.third - other.third
    return Triple(first, second, third)
}