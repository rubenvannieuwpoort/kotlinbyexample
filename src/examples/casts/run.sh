$ kotlinc main.kt -include-runtime -d main.jar
$ java -jar Main.jar
x is a string with length 12
Yes, x is a string with length 12
x has length 12
Exception in thread "main" java.lang.ClassCastException:
class java.lang.Double cannot be cast to class java.lang
.String (java.lang.Double and java.lang.String are in mo
dule java.base of loader 'bootstrap')
        at MainKt.withCast(main.kt:6)
        at MainKt.main(main.kt:32)
        at MainKt.main(main.kt)
