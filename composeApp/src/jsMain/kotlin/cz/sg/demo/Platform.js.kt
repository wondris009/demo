package cz.sg.demo

class JsPlatform : Platform {
    override val name: String = "Web with Kotlin/JS"
    override val host: String = "localhost"
}

actual fun getPlatform(): Platform = JsPlatform()