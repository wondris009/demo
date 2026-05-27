package cz.sg.demo

import android.os.Build

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
    override val host: String = "10.0.2.2"
}

actual fun getPlatform(): Platform = AndroidPlatform()