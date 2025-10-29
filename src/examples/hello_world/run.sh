# First, we have to compile the program with `kotlinc`, the Kotlin compiler.
$ kotlinc main.kt -include-runtime -d main.jar
# The compiler will generate a `.jar` file.
$ ls
main.kt Main.jar
# The resulting `.jar` file can run be run with the Java runtime.
$ java -jar Main.jar
Hello, world!
