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

// Yet another solution is to return a list.
fun ridiculouslyLongName(): List<String> {
    return listOf("Adolph", "Blaine", "Charles", "David")
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

    // It is also possible to do a *destructuring declaration*, which
    // "destructures" the values into separate variables.
    val (firstName, secondName, thirdName) = allMyNames()
    println(firstName)
    println(secondName)
    println(thirdName)

    // Destructuring declarations also work for functions that return lists.
    val (name1, name2) = ridiculouslyLongName()
    println(name1)
    println(name2)

    // Destructuring declarations are just syntactic sugar. This is the
    // desugared version of the last paragraph of code.
    val temp = ridiculouslyLongName()
    val desugaredName1 = temp.component1()
    val desugaredName2 = temp.component2()
    println(name1)
    println(name2)

    // There can be up to 5 variables in a destructuring declaration. The
    // number of variables can not be bigger than the number of values that the
    // function returns.
    
    // For types with a fixed number of values the number of values is checked
    // at compile time. For collection types, an `IndexOutOfBoundException`
    // can occur if the number of values in the declaration is too large.
    val (n1, n2, n3, n4, n5) = ridiculouslyLongName()
}
