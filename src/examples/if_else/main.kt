fun main() {
    val a = 12
    val b = 17

    // In Kotlin, `if` can be used in the traditional way.
    // The parentheses are mandatory. 
    val largest: Int
    if (a > b) largest = a else largest = b

    // However, `if` can also be used as an expression.
    val smallest = if (a < b) a else b

    // Each branch in an if expression can be a block, where
    // the value of the last expression becomes the result.
    val equal: Boolean = if (a > b) {
        println("a is larger")
        false
    } else if (b > a) {
        println("b is larger")
        false
    } else {
        println("a and b are equal")
        true
    }

    println(smallest)
    println(largest)
    println(equal)
}
