package com.example.madlevel1task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.madlevel1task2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val maxAnswersCorrect = 4
    private var correctAnswersCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) // Sets the activity layout resource file.

        // Click event handler for the submit button
        binding.btnSubmit.setOnClickListener {
            checkAnswers()
        }
    }

    /**
     * Check if all fields are filled and check how many answers are correct.
     */
    private fun checkAnswers() {
        // Reset the amount of correct answers after a submit
        correctAnswersCount = 0;

        // Check for empty edit fields.
        if (TextUtils.isEmpty(binding.etAnswer1.text) ||
            TextUtils.isEmpty(binding.etAnswer2.text) ||
            TextUtils.isEmpty(binding.etAnswer3.text) ||
            TextUtils.isEmpty(binding.etAnswer4.text)) {
            showMessageNotAllFieldsFilled()
        } else {
            // Check if the first answer is correct
            if (binding.etAnswer1.text.toString()
                    .equals(getString(R.string.option_true), ignoreCase = true)) {
                correctAnswersCount++
            }

            // Check if the second answer is correct
            if (binding.etAnswer2.text.toString()
                    .equals(getString(R.string.option_false), ignoreCase = true)) {
                correctAnswersCount++
            }

            // Check if the third answer is correct
            if (binding.etAnswer3.text.toString()
                    .equals(getString(R.string.option_false), ignoreCase = true)) {
                correctAnswersCount++
            }

            // Check if the fourth answer is correct
            if (binding.etAnswer4.text.toString()
                    .equals(getString(R.string.option_false), ignoreCase = true)) {
                correctAnswersCount++
            }

            // Display a Toast message based on the amount of answers correct
            when (correctAnswersCount) {
                0 -> {
                    onAllAnswersIncorrect()
                }
                maxAnswersCorrect -> {
                    onAllAnswersCorrect()
                }
                else -> {
                    onAnswersCorrect()
                }
            }
        }
    }

    /**
     * Display a "not all fields are filled in" Toast message.
     */
    private fun showMessageNotAllFieldsFilled () {
        Toast.makeText(this, getString(R.string.fields_empty), Toast.LENGTH_SHORT).show()
    }

    /**
     * Display a Toast message with the amount of correct answers.
     */
    private fun onAnswersCorrect () {
        Toast.makeText(this,
            getString(R.string.answers_correct, correctAnswersCount, maxAnswersCorrect),
            Toast.LENGTH_LONG
        ).show()
    }

    /**
     * Display a Toast message with the amount of correct answers.
     */
    private fun onAllAnswersCorrect () {
        Toast.makeText(this, getString(R.string.all_answers_correct), Toast.LENGTH_LONG).show()
    }

    /**
     * Display a Toast message with the amount of correct answers.
     */
    private fun onAllAnswersIncorrect () {
        Toast.makeText(this, getString(R.string.all_answers_incorrect), Toast.LENGTH_LONG).show()
    }
}