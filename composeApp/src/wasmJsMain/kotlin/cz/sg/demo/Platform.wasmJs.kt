package cz.sg.demo

class WasmPlatform : Platform {
    override val name: String = "Web with Kotlin/Wasm"
    override val host: String = "localhost"
}

actual fun getPlatform(): Platform = WasmPlatform()