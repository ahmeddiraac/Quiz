package com.example.quiz

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(),View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList:ArrayList<Question> ? = null
    private var mSelectedOptionPosition: Int = 0

    private var progressBar:ProgressBar? = null
    private var tvprogress:TextView? = null
    private var tvquestion: TextView? = null
    private var ivImage:ImageView? = null


    private var optionOne: TextView? = null
    private var optionTwo: TextView? = null
    private var optionThree: TextView? = null
    private var optionFour: TextView? = null
    private var btnSubmit :Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)


        progressBar = findViewById(R.id.progressbar)
        tvprogress = findViewById(R.id.tv_progress)
        tvquestion = findViewById(R.id.question)
        ivImage = findViewById(R.id.iv_image)

        optionOne = findViewById(R.id.tv_option_one)
        optionTwo = findViewById(R.id.tv_option_two)
        optionThree = findViewById(R.id.tv_option_three)
        optionFour = findViewById(R.id.tv_option_four)

        btnSubmit = findViewById(R.id.btn_submit)

        optionOne?.setOnClickListener(this)
        optionTwo?.setOnClickListener(this)
        optionThree?.setOnClickListener(this)
        optionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)



        mQuestionsList = Constants.getQuestions()

        setQuestion()
    }

    private fun setQuestion() {

        defaultOptionsView()
        var mCurrentPosition = 1
        val question: Question = mQuestionsList!![mCurrentPosition - 1]
        ivImage?.setImageResource(question.Image)
        progressBar?.progress = mCurrentPosition
        tvprogress?.text = "$mCurrentPosition/${progressBar?.max}"

        tvquestion?.text = question.question
        optionOne?.text = question.OptionOne
        optionTwo?.text = question.OptionTwo
        optionThree?.text = question.OptionThree
        optionFour?.text = question.OptionFour

        if (mCurrentPosition == mQuestionsList!!.size){

            btnSubmit?.text = "FINISH"
        }else{
            btnSubmit?.text = "SUBMIT"
        }
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
            optionOne?.let {
                options.add(0,it)
            }

            optionTwo?.let {
                options.add(1,it)
            }

            optionThree?.let {
                options.add(2,it)
            }

            optionFour?.let {
                options.add(3,it)
            }
        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.defualt_option_border_bg
            )
        }
    }

    private fun selectedOptionVeiw(tv:TextView,selectedOptionNum:Int){
        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.select_option_border_bg
        )


    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tv_option_one-> {
                optionOne?.let {
                    selectedOptionVeiw(it,1)
                }
            }

            R.id.tv_option_two-> {
                optionTwo?.let {
                    selectedOptionVeiw(it,2)
                }
            }

            R.id.tv_option_three-> {
                optionThree?.let {
                    selectedOptionVeiw(it,3)
                }
            }

            R.id.tv_option_four-> {
                optionFour?.let {
                    selectedOptionVeiw(it,4)
                }
            }
            R.id.btn_submit->{
                if (mSelectedOptionPosition == 0){
                    mCurrentPosition++
                    when{
                        mCurrentPosition <= mQuestionsList!!.size ->{
                            setQuestion()
                        }
                    }
                }else{
                    val question = mQuestionsList?.get(mCurrentPosition - 1)

                    // This is to check if the answer is wrong
                    if (question!!.CorrectAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }

                    answerView(question.CorrectAnswer,R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionsList!!.size) {
                        btnSubmit?.text = "FINISH"
                    } else {
                        btnSubmit?.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }
    private fun answerView(answer: Int, drawableView: Int) {

        when (answer) {

            1 -> {
                optionOne?.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
            2 -> {
                optionTwo?.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
            3 -> {
                optionThree?.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
            4 -> {
                optionFour?.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
        }
    }

}