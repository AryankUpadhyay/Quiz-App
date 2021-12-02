package com.example.myapplication

object setData {

    const val name:String="name"
    const val score:String="score"

    fun getQuestion():ArrayList<QuestionData>{
        var que:ArrayList<QuestionData> = arrayListOf()

        var q1=QuestionData(
             1,
            "What is capital of India",
            "Varanasi",
            "New Delhi",
            "Lucknow",
            "Jaipur",
        2
        )
        var q2=QuestionData(
            2,
            "What is capital of Uttar Pradesh",
            "Varanasi",
            "Allahabad",
            "Lucknow",
            "Kanpur",
            3
        )
        var q3=QuestionData(
            3,
            "What is capital of Bihar",
            "Dhanbad",
            "Patna",
            "Dispur",
            "Ranchi",
            2
        )
        var q4=QuestionData(
            4,
            "What is capital of Assam",
            "Dhanbad",
            "Orissa",
            "Nagaland",
            "Dispur",
            4
        )
        var q5=QuestionData(
            5,
            "What is capital of Kerela",
            "Banglore",
            "Thiruvananthapuram",
            "Dispur",
            "Kochi",
            2
        )
        que.add(q1)
        que.add(q2)
        que.add(q3)
        que.add(q4)
        que.add(q5)
        return que
    }
}