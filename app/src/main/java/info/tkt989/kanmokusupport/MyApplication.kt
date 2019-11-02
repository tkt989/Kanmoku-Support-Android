package info.tkt989.kanmokusupport

import android.app.Application
import android.content.Context

class MyApplication: Application() {
    var launchCount: Int = 0

    override fun onCreate() {
        super.onCreate()

        val prefs = getSharedPreferences("app", Context.MODE_PRIVATE)
        this.launchCount = prefs.getInt("LAUNCH_COUNT", 0)
        this.launchCount++
        prefs.edit().apply {
            putInt("LAUNCH_COUNT", this@MyApplication.launchCount)
            commit()
        }
    }
}