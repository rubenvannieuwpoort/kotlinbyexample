// As an object-oriented programming language, Kotlin supports classes.
// Unlike most other programming languages, Kotlin does not support member
// variables. It only supports member properties and member functions.

// This is the *primary constructor* of a class. The Kotlin compiler will
// automatically generate properties for the parameters.
class Person(val name: String, var age: Int)

// It is also possible to define properties with custom getters and setters.
class PersonWithStats(val name: String,
                      val length: Double,
                      val weight: Double) {
    val bmi get() = weight / (length * length)
}

class Rectangle(var width: Int, var height: Int) {
    val area = width * height

    // Kotlin also supports *secondary constructors*. Secondary constructors
    // must always call the primary constructor.
    constructor(size: Int) : this(size, size) {
        println("Created a square with side $size")
    }

    // Member functions can be defined in the way you would expect.
    fun describe() {
        println(
            "Rectangle: ${width}x$height (area = $area)")
    }
}

fun main() {
    // Kotlin does not use the `new` keyword that many languages use.
    val person = PersonWithStats("Henk", 1.80, 70.0)
    println(person.bmi)

    val rectangle = Rectangle(10, 20)
    val square = Rectangle(20)

    rectangle.describe()
    square.describe()
}
