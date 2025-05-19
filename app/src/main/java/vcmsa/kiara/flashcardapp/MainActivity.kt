package vcmsa.kiara.flashcardapp

import android.content.Intent
import vcmsa.kiara.flashcardapp.R
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnStart = findViewById<Button>(R.id.btnStart)

        btnStart.setOnClickListener {
            // When the user clicks start the Flashcard Question Screen will appear(Next Screen).
            val intent = Intent(this, QuestionActivity::class.java)
            startActivity(intent)
        }
    }
}