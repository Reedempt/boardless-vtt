package org.boardlessvtt.app.util

import android.app.Activity
import java.lang.ref.WeakReference

object AndroidAppCloserHolder {
    var activityRef: WeakReference<Activity>? = null
}

actual fun closeApplication() {
    AndroidAppCloserHolder.activityRef?.get()?.finishAffinity()
}