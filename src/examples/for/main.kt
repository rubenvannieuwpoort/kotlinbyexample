fun main() {
    // In Kotlin, there is only one syntactical form of the `for` loop.
    // It can be used on anything that implements the `Iterable<T>` interface.

    // For example, on lists or arrays.
    val someNumbers = listOf(11, 13, 19)
    for (x in someNumbers) {
        println(x)
    }

    // Ranges.
    for (x in 1..3) {
        println(x)
    }

    // Maps.
    val myMap = mapOf(
        "Fist name" to "Ruben",
        "Last name" to "van Nieuwpoort",
    )
    for ((key, value) in myMap) {
        println(key + ": " + value)
    }
}