$ kotlinc main.kt -include-runtime -d main.jar
$ java -jar Main.jar
a has length 5
b has length 4
b has length 4
c has length 7
b has length null
b has length 0
Exception in thread "main" java.lang.NullPointerException
        at MainKt.maybeNullUnsafe(main.kt:16)
        at MainKt.main(main.kt:43)
        at MainKt.main(main.kt)
