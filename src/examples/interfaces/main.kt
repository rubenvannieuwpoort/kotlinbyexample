// A simple interface looks like this.
interface VehicleInterface {
    // An interface can define methods and properties
    // that implementations need to define.
    val acceleration: Int
    fun alarm(): String

    // It is possible to provide default
    // implementations for properties and methods.
    val looksLike: String get() = "car"

    fun engine(): String {
        return "VROOM"
    }

}

// A class can define zero or multiple interfaces. If a class implements
// multiple interfaces which both have a default implementation for some method
// or property, the implementation must provide an implementation. The default
// implementation of `foo` from interface `A` can be called as `super<A>.foo()`.
class PetrolCar : VehicleInterface {
    override val acceleration = 50

    override fun alarm(): String {
        return "WIIIUUUIIIUUU"
    }
}

class ElectricCar : VehicleInterface {
    override val acceleration = 1000

    override fun alarm(): String {
        return "WIIIUUUIIIUUU"
    }

    override fun engine(): String {
        return "zzzzzz"
    }
}

fun main() {
    val car = PetrolCar()
    println("A car looks like a ${car.looksLike},")
    println("its engine sounds like ${car.engine()},")
    println("its alarm sounds like ${car.alarm()},")
    println("and accelerates at ${car.acceleration}.")

    println()

    val ev = ElectricCar()
    println("An EV looks like a ${ev.looksLike},")
    println("its engine sounds like ${ev.engine()},")
    println("its alarm sounds like ${ev.alarm()},")
    println("and accelerates at ${ev.acceleration}.")
}