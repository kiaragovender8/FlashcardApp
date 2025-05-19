package vcmsa.kiara.flashcardapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class QuestionActivity : AppCompatActivity() {
    val questions = arrayOf(
        "1.Nelson Mandela was released from prison in the 1990s.",
        "2.South Africa hosted the FIFA World Cup in 2006.",
        "3.Johannesburg is the largest city in South Africa.",
        "4.South Africa has the largest population in the world.",
        "5.South Africa is the largest producer of coffee in the world."
    )
    private val answers = booleanArrayOf(true, false, true, false, false)

    private var currentQuestionIndex = 0
    private var score = 0
    private val userAnswers = ArrayList<String>()

    private lateinit var txtQuestion: TextView
    private lateinit var btnTrue: Button
    private lateinit var btnFalse: Button
    private lateinit var btnNext: Button
    private lateinit var txtFeedback: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtQuestion = findViewById<TextView>(R.id.txtQuestion)
        btnTrue = findViewById<Button>(R.id.btnTrue)
        btnFalse = findViewById<Button>(R.id.btnFalse)
        btnNext = findViewById<Button>(R.id.btnNext)
        txtFeedback = findViewById<TextView>(R.id.txtFeedback)

        loadQuestion()

        btnTrue.setOnClickListener { checkAnswer(true) }
        btnFalse.setOnClickListener { checkAnswer(false) }

        btnNext.setOnClickListener {
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                loadQuestion()
                txtFeedback.text = "" // Clear feedback
                btnNext.isEnabled = false // Disable next button until an answer is chosen
            } else {
                // After the final question, load the Score Screen and the total score displayed.
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("SCORE", score)
                intent.putExtra("TOTAL_QUESTIONS", questions.size)
                intent.putStringArrayListExtra("QUESTIONS", ArrayList(questions.toList()))
                intent.putStringArrayListExtra("USER_ANSWERS", userAnswers)
                intent.putStringArrayListExtra("CORRECT_ANSWERS", ArrayList(answers.map { it.toString() }))

                startActivity(intent)
                finish()
            }
        } // Moved this closing brace

        // Initially disable the next button
        btnNext.isEnabled = false
    }

    private fun loadQuestion() {
        txtQuestion.text = questions[currentQuestionIndex]
        btnTrue.isEnabled = true
        btnFalse.isEnabled = true
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = answers[currentQuestionIndex]

        userAnswers.add(userAnswer.toString()) // Save the user's answer for review

        if (userAnswer == correctAnswer) {
            txtFeedback.text = "Correct!"
            score++
        } else {
            txtFeedback.text = "Incorrect."
        }

        btnNext.isEnabled = true
        btnTrue.isEnabled = false
        btnFalse.isEnabled = false
    }
}


