package info.tkt989.kanmokusupport

import android.app.Application
import android.content.Context
import info.tkt989.kanmokusupport.services.PrefsService

class MyApplication: Application() {
    var launchCount: Int = 0
    lateinit var prefsService: PrefsService

    override fun onCreate() {
        super.onCreate()

        prefsService = PrefsService(this)
        val prefs = getSharedPreferences("app", Context.MODE_PRIVATE)
        this.launchCount = prefs.getInt("LAUNCH_COUNT", 0)
        this.launchCount++
        prefs.edit().apply {
            putInt("LAUNCH_COUNT", this@MyApplication.launchCount)
            commit()
        }
    }
}