package cz.sg.demo

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}! Hello Java Grupacek!"
    }
}