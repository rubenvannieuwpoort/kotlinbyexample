// A simple enum can be be defined concisely.
enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

// It is also possible to have enum classes with properties and constructors.
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

// It is also possible to add computed properties or methods.
// The list of enums must be separated from the members with a semicolon.
enum class BetterColor(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF);
    val r = rgb shr 16;
    val g = (rgb shr 8) and 0xff;
    val b = rgb and 0xff;
}

// Another more advanced variant is to implement
// the members as instances of anonymous classes.
enum class ProtocolState {
    WAITING {
        override fun signal() = TALKING
    },

    TALKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState
}

fun main() {
    val north = Direction.NORTH
    println(north)

    val red = Color.RED
    println(red)
    println(red.rgb)

    val moreRed = BetterColor.RED
    println(moreRed)
    println(moreRed.r)
    println(moreRed.g)
    println(moreRed.b)

    var ps = ProtocolState.WAITING
    println(ps)
    ps = ps.signal()
    println(ps)
    ps = ps.signal()
    println(ps)
}