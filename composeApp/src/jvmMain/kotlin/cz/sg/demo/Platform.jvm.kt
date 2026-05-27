package cz.sg.demo

class JVMPlatform : Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
    override val host: String = "localhost"
}

actual fun getPlatform(): Platform = JVMPlatform()