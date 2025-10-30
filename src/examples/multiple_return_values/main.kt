// Kotlin does not have built-in support for returning multiple values.
// However, it is relatively easy to define dataclasses which let you return
// multiple values. There are two such dataclasses in the standard library.

// For pairs, there is the `Pair<A, B>` dataclass.
fun firstAndLastName(): Pair<String, String> {
    return Pair("Ruben", "van Nieuwpoort");
}

// Likewise, for triples there is the `Triple<A, B, C>` dataclass.
fun allMyNames(): Triple<String, String, String> {
    return Triple("Ruben", "van", "Nieuwpoort");
}

// There is no `Quadruple` dataclass, but if we want one we can easily define it.
// However, it is more idiomatic to make a custom dataclass with appropriately
// named member properties.
data class Quadruple<out A, out B, out C, out D>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D
)

fun evenMoreNames(): Quadruple<String, String,
                               String, String> {
    return Quadruple("Fernando", "de", "los", "Santos");
}

fun main() {
    val names = firstAndLastName()
    println(names.first + " " + names.second)

    val moreNames = allMyNames()
    println(moreNames.first + " " +
            moreNames.second + " " +
            moreNames.third)

    val manyNames = evenMoreNames()
    println(manyNames.first + " " +
            manyNames.second + " " +
            manyNames.third + " " +
            manyNames.fourth)
}
