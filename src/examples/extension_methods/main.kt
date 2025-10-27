// In Kotlin, it is possible to define methods for classes outside the
// definition of those classes with a concept called *extension methods*.


// For example, we can define a new method on the `String` class.
// Here, `String` is called the *receiver type* and `this` is called the
// *receiver object*.
fun String.lastChar() = this.get(this.length - 1)

fun main() {
    // Now, we can simply use the method as if it were a "native" method
    // defined in the `String` class.
    println("Howdy".lastChar())
}

// Note that extension methods can not access private or protected members
// of the receiver object.
