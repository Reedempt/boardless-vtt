package org.boardlessvtt.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.boardlessvtt.app.db.DatabaseDriverFactory
import org.boardlessvtt.app.util.AndroidAppCloserHolder

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        AndroidAppCloserHolder.activityRef = java.lang.ref.WeakReference(this)
        val driverFactory = DatabaseDriverFactory(applicationContext)
        setContent {
            App(driverFactory)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    // Preview non può istanziare un vero Context/driver, la lasciamo senza chiamare App() con parametri reali
    // (la sistemeremo se necessario quando la UI sarà più complessa)
}