// In Kotlin, functions are declared using the `fun` keyword. The function
// declaration should define the type of the parameters.
fun add(a: Int, b: Int): Int {
    return a + b
}

// Short functions can be defined more concisely using an *expression body*.
fun mul(a: Int, b: Int): Int = a * b

// Functions which don't return a value have the `Unit` return type.
fun greet(name: String): Unit {
    println("Hello, " + name)
}

// If the return type is omitted from the declaration, it will be inferred.
// To avoid accidental changes to the API, it is not recommended to do this
// for libraries.
fun main() {
    // Functions can be called using familiar syntax.
    greet("Alice")
    println(add(mul(3, 5), 1))

    // Calls to member functions also use familiar syntax.
    println("kotlin".uppercase())
}
