package com.example.quiz

object Constants {

    const val USER_NAME:String = "user_name"
    const val TOTAL_QUESTIONS:String =  "total_questions"
    const val CORRECT_ANSWER:String = "correct_answer"





    fun getQuestions():ArrayList<Question>{
        val questionsList = ArrayList<Question>()
        val que1 =Question(
            1, "what Country is this flag blong to ?",
            R.drawable.somalia,
            "Ethopia","kenya","Somalia","South Africa",
            3
        )
        questionsList.add(que1)

        val que2 =Question(
            2, "what Country is this flag blong to ?",
            R.drawable.zimbabwe,
            "Ethopia","kenya","Zimbabwe","South Africa",
            3
        )
        questionsList.add(que2)

        val que3 =Question(
            3, "what Country is this flag blong to ?",
            R.drawable.france,
            "Ethopia","kenya","France","South Africa",
            3
        )
        questionsList.add(que3)

        val que4 =Question(
            4, "what Country is this flag blong to ?",
            R.drawable.yaman,
            "Ethopia","kenya","Yaman","South Africa",
            3
        )
        questionsList.add(que4)

        val que5 =Question(
            5, "what Country is this flag blong to ?",
            R.drawable.egypt,
            "Ethopia","kenya","Egypt","South Africa",
            3
        )
        questionsList.add(que5)

        val que6 =Question(
            6, "what Country is this flag blong to ?",
            R.drawable.burkinafaso,
            "Ethopia","kenya","Burkina Faso","South Africa",
            3
        )
        questionsList.add(que6)

        return questionsList
    }
}