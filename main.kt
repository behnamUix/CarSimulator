//Code by BehnamUix
fun main() {
    print("Enter car speed (km/h): ")
    val speed = readln().toInt()

    print("Select road type (ice, snow, rainy, sunny):")
    val type = readln().lowercase()

    carSim(speed, type)
}

fun carSim(speed: Int, type: String) {
    val g = 9.81
    val µRoad = mapOf("ice" to 0.1, "snow" to 0.2, "rainy" to 0.6, "sunny" to 0.9)

    val speedMs = convertToMs(speed)

    val mu = when (type) {
        "ice"   -> µRoad["ice"]
        "snow"  -> µRoad["snow"]
        "rainy" -> µRoad["rainy"]
        "sunny" -> µRoad["sunny"]
        else -> {
            println("Unknown road type! Using default: sunny")
            µRoad["sunny"]
        }
    }!!

    val d = (speedMs * speedMs) / (2 * mu * g)

    println("speed:${speed}km/h\nkhat tormoz shoma %.2f meters!".format(d))
}

fun convertToMs(speed: Int): Double {
    return (speed * 1000.0) / 3600.0
}
