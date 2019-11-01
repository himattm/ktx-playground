package io.github.matthewcmckenna.ktxplayground

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat

class FileSizeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        val integer = 0
        integer.readableFileSize()
    }
}


fun Int.readableFileSize() = this.toLong().readableFileSize()

fun Long.readableFileSize(): String {
    if (this <= 0) return "0"
    val units = arrayOf("B", "kB", "MB", "GB", "TB")
    val digitGroups = (Math.log10(this.toDouble()) / Math.log10(1024.0)).toInt()

    return "${DecimalFormat("#,##0.#")
            .format(this / Math.pow(1024.0, digitGroups.toDouble()))} ${units[digitGroups]}"
}

























