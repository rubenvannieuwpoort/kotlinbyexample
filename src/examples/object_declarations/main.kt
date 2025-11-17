// Many programming languages support `static` members. Kotlin does not support
// static members. Instead, you should use top-level functions or *object declarations*.

// For functions that do not need state, a top-level function can be used.
fun greet() {
    println("Hello!")
}

// For functions that do need state, we can use an *object declaration*,
// which essentially creates a singleton object. An object declaration
// can use interfaces or inheritance, just like a normal class.
object Utils {
    private var n = 0

    fun getUniqueNumber(): Int {
        return n++
    }
}

class Counter() {
    private var internalCounter = 0

// Functions in an object declaration can not access private or protected
// members of their arguments. To do this, a *companion object* can be used.
    companion object {
        fun getNumber(c: Counter): Int {
            return c.internalCounter++
        }
    }
}

fun main() {
    greet()

    println(Utils.getUniqueNumber())
    println(Utils.getUniqueNumber())
    println(Utils.getUniqueNumber())

    val c = Counter()
    println(Counter.getNumber(c))
    println(Counter.getNumber(c))
    println(Counter.getNumber(c))
}
