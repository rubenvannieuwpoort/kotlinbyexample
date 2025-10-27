// In Kotlin, variables are explicitly declared and used by the compiler to check type-correctness.

fun main() {
    // A variable can be declared with the `var` keyword.
    var a: Int = 10

    // The type can be omitted from the declaration; it will be inferred by the compiler.
    var b = a
    b++

    // A *read-only reference* (as opposed to a *reassignable reference*) can
    // be declared with the `val` keyword. A read-only reference can not be
    // reassigned; doing `c++` after the initialization would result in a
    // compiler error, since it is a shorthand for `c = c + 1`.
    val c = b + 1

    // Note that read-only references can still be mutable, it's only
    // reassignment that is forbidden.
    val myList = mutableListOf(10, 11)
    myList.add(12)
    println(myList)

    // Initialization can be done separately from the declaration, as long
    // as the type is specified and the compiler can detected that the variable
    // will always be initialized.
    val d: String
    if (a + b + c < 100) {
        d = "the sum of a, b, and c is less than 100"
    } else {
        d = "the sum of a, b, and c is 100 or more"
    }
    println(d)
}
