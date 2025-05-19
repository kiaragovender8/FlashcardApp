package vcmsa.kiara.flashcardapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.graphics.Color



class ScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val score = intent.getIntExtra("SCORE", 0)
        val totalQuestions = intent.getIntExtra("TOTAL_QUESTIONS", 5)
        val questions = intent.getStringArrayListExtra("QUESTIONS") ?: ArrayList()
        val correctAnswers = intent.getStringArrayListExtra("CORRECT_ANSWERS")
        val userAnswers = intent.getStringArrayListExtra("USER_ANSWERS") ?: ArrayList()

        val textScore = findViewById<TextView>(R.id.textScore)
        val textFeedback = findViewById<TextView>(R.id.textFeedback)
        val txtReview = findViewById<TextView>(R.id.txtReview)
        val btnReview = findViewById<Button>(R.id.btnReview)
        val btnExit = findViewById<Button>(R.id.btnExit)
        val btnRestart = findViewById<Button>(R.id.btnRestart)

        textScore.text = "You got $score out of $totalQuestions correct!"

        textFeedback.text = when {
            score >= 3 -> "Great job!"
            else -> "Keep practising!"
        }

        btnReview.setOnClickListener {
            txtReview.visibility = View.VISIBLE
            val reviewBuilder = SpannableStringBuilder()

            for (i in questions.indices) {
                val question = "Question: ${questions[i]}\n"
                val userAnswer = userAnswers.getOrElse(i) { "Not answered" }
                val correctAnswer = correctAnswers?.getOrElse(i) { "N/A" }

                val isCorrect = userAnswer == correctAnswer
                val resultText = if (isCorrect) "Correct" else "Incorrect"
                val resultColor = if (isCorrect) Color.GREEN else Color.RED

                // Append question normally
                reviewBuilder.append(question)

                // Apply color only to the result word (Correct/Incorrect)
                reviewBuilder.append("Your Answer: $userAnswer (")
                val resultStart = reviewBuilder.length
                reviewBuilder.append(resultText)
                val resultEnd = reviewBuilder.length
                reviewBuilder.setSpan(
                    ForegroundColorSpan(resultColor),
                    resultStart,
                    resultEnd,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                reviewBuilder.append(")\n\n")
            }

            txtReview.text = reviewBuilder
        }

        btnRestart.setOnClickListener {
            val intent = Intent(this, QuestionActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnExit.setOnClickListener {
            finishAffinity() // Close the app
        }
    }
}