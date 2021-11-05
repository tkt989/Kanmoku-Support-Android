package info.tkt989.kanmokusupport.services

import android.content.Context
import info.tkt989.kanmokusupport.models.Direction

class PrefsService(private val context: Context) {
    private val prefs = context.getSharedPreferences("app", Context.MODE_PRIVATE)

    var showDirection: Direction
    get() = Direction.valueOf(prefs.getString("showDirection", Direction.REVERSE.name)!!)
    set(value) {
        prefs.edit().apply {
            putString("showDirection", value.name)
            apply()
        }
    }
}