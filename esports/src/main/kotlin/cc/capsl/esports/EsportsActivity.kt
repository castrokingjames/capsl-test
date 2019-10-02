package cc.capsl.esports

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cc.capsl.esports.ui.navigation.Activities

class EsportsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Activities.intentForGames(this))
        finish()
    }
}