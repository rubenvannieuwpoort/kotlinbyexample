$ kotlinc main.kt -include-runtime -d main.jar
$ java -jar Main.jar
z is a string with length 12
Yes, z is a string with length 12
z is not a string
y has length 12
x has length 12
Exception in thread "main" java.lang.ClassCastException:
class java.lang.Double cannot be cast to class java.lang.
String (java.lang.Double and java.lang.String are in modu
le java.base of loader 'bootstrap')
        at MainKt.withCast(main.kt:6)
        at MainKt.main(main.kt:49)
        at MainKt.main(main.kt)
