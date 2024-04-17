package info.tkt989.kanmokusupport.extensions

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import java.io.File
import java.io.FileOutputStream

fun Bitmap.toUri(context: Context): Uri {
    val fileName: String = System.currentTimeMillis().toString() + ".jpg"
    val file = File(context.cacheDir, fileName)
    val fileOutputStream = FileOutputStream(file)
    this.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream)
    fileOutputStream.close()
    return Uri.fromFile(file)
}