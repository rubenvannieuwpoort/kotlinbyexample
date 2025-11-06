// Kotlin supports different types of casts.

fun withCast(x: Any) {
    // This is a normal cast using the `as` operator, which will
    // throw an exception when `x` is not of the `String` type.
    val xstr = x as String
    println("x has length ${xstr.length}")
}

fun withSafeCast(y: Any) {
    // This is a *safe cast*, using the `as?` operator. This will
    // return `null` when `y` is not of the `String` type.
    val ystr = y as? String

    if (ystr != null) {
        println("y has length ${ystr.length}")
    }
}

fun withSmartCast(z: Any) {
    // Kotlin also has a feature called *smart casts*,
    // which use the `is` operator.
    if (z is String) {
        // Inside this `if` block, the compiler has
        // determined that `z` has type `String`.
        println("z is a string with length ${z.length}")
    }

    // Smart casts also work when the `is` operator is negated.
    if (z !is String) {
        println("z is not a string")
        return
    }

    println("Yes, z is a string with length ${z.length}")
}

fun main() {
    val x1 = "hello, world"
    val x2 = 1.0

    withSmartCast(x1)
    withSmartCast(x2)

    withSafeCast(x1)
    withSafeCast(x2)

    withCast(x1)
    withCast(x2)
}
