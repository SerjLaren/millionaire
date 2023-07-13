package com.bm.Droid

class MultipleClicksCutter {
    private val now: Long
        get() = System.currentTimeMillis()

    private var lastClickTimeMs: Long = 0

    fun processClick(click: () -> Unit) {
        if (now - lastClickTimeMs >= 500L) {
            lastClickTimeMs = now
            click.invoke()
        }
    }
}