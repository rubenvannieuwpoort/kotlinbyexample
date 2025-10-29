// Kotlin has `when`, which is similar to `switch` in other programming language.

fun main() {
    // When can be used in a way similar to a
    // `switch` statement in other languages.
    val x = 2
    when (x) {
        1 -> println("x == 1")
        2 -> println("x == 2")
        else -> println("x is neither 1 nor 2")
    }

    // However, like `if`, it can also be used as an expression.
    val result = when (x) {
        1 -> "one"
        2 -> "two"
        else -> "unknown"
    }
    println("result = $result")

    // Multiple matches can be used for a single branch.
    when (x) {
        0, 1 -> println("x is 0 or 1")
        else -> println("x is not 0 or 1")
    }

    // It is also possible to omit the argument to `when`. In this case
    // the `when` block becomes similar in use to an `if` block.
    when {
        x % 2 == 0 -> println("x is even")
        x % 2 != 0 -> println("x is odd")
    }

    // A `when` block has several "special" syntax for matches.
    // For example, it has support for ranges.
    val y = 5
    when (y) {
        in 1..10 -> println("y is in the range 1..10")
        !in 10..20 -> println("y is outside 10..20")
        else -> println("y is something else")
    }

    // Type checking with `is` is also supported.
    fun describe(obj: Any): String =
        when (obj) {
            is String -> "String of length ${obj.length}"
            is Int -> "Integer"
            else -> "Unknown type"
        }

    println(describe("hello"))
    println(describe(42))
}
