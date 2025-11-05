// Kotlin supports two types of casts.

fun withCast(x: Any) {
    // This is a normal cast using the `as` operator, which will
    // throw an exception when `x` is not of the `String` type.
    val xString = x as String
    println("x has length ${x.length}")
}

fun withSmartCast(x: Any) {
    // Kotlin also has a feature called *smart casts*,
    // which use the `is` operator.
    if (x is String) {
        // Inside this `if` block, the compiler has
        // determined that `x` has type `String`.
        println("x is a string with length ${x.length}")
    }

    // Smart casts also work when the `is` operator is negated.
    if (x !is String) return
    println("Yes, x is a string with length ${x.length}")
}

fun main() {
    val x1 = "hello, world"
    val x2 = 1.0

    withSmartCast(x1)
    withSmartCast(x2)

    withCast(x1)
    withCast(x2)
}
