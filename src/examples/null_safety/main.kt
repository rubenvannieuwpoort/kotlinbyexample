// Kotlin has several features to avoid null pointer exceptions.
// These features are collectively referred to as *null safety* features.

// In Kotlin, "normal" types are non-nullable.
fun nonNull(a: String) {
    // We can safely call methods on non-nullable variables.
    println("a has length ${a.length}")
}

// To make a type nullable, it can be suffixed by the `?` operator.
fun maybeNullUnsafe(c: String?) {
    // For nullable variables, we cannot call methods directly.
    // `print("${c.length}")` does not compile. Instead, we have to use
    // the `!!` operator to do a *non-null assertion*. If a non-null assertion
    // is done on `null`, a `NullPointerException` will be thrown.
    println("c has length ${c!!.length}")
}

fun maybeNullSafe(b: String?) {
    // A safer (in the sense that it will not throw a `NullPointerException1)
    // alternative to a non-null assertion is to use a *safe call*.
    println("b has length ${b?.length}")

    // Sometimes you have to combine a safe call with the *Elvis* operator to
    // get a sensible result. `x ?: y` will return `x` if x is non-null, and
    // and `y` when `x` is `null`.
    println("b has length ${b?.length ?: 0}")
}

// Other options to safely handle a nullable variable `a` is to check if
// `a` is null explicitly with an `if` or `when` expression, to use
// `a?.let { ... }` (where the lambda is only executed when `a` is non-null),
// to use safe casts. For a collection `c` with nullable elements, you can use
// `c.filterNotNull()` to get a collection with only the non-null elements.

fun main() {
    nonNull("Hello")

    maybeNullSafe("Ciao")
    maybeNullUnsafe("Goodbye")

    maybeNullSafe(null)
    maybeNullUnsafe(null)

}
