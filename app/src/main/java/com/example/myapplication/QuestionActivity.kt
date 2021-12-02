package com.example.myapplication

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {

    private var name:String?=null
    private var score:Int=0

    private var current_position:Int=1
    private var selected_option:Int=0
    private var questionList:ArrayList<QuestionData>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        setData.getQuestion()

        name=intent.getStringExtra(setData.name)

        questionList=setData.getQuestion();
        setfunction()

        opt_1.setOnClickListener {
            selected_OptionStyle(opt_1, 1)
        }
        opt_2.setOnClickListener {
            selected_OptionStyle(opt_2, 2)
        }
        opt_3.setOnClickListener {
            selected_OptionStyle(opt_3, 3)
        }
        opt_4.setOnClickListener {
            selected_OptionStyle(opt_4, 4)
        }


        submit.setOnClickListener {
            if(selected_option!=0) {
                val question = questionList!![current_position - 1]
                if (selected_option != question.correctans) {
                    setcolor(selected_option, R.drawable.wrong_option)
                    //drawables are of Int type
                }
                else{
                    score++
                }
                setcolor(question.correctans, R.drawable.correct_option)
                if(current_position==questionList!!.size)
                submit.text="Finish"
                else
                    submit.text="Go to Next Question"
            }
            else{
                current_position++
                when{
                    current_position<=questionList!!.size->{
                        setfunction()
                    }
                    else->
                    {
                    var intent=Intent(this, Result::class.java)
                        intent.putExtra(setData.name,name.toString())
                        intent.putExtra(setData.score,score.toString())
                        intent.putExtra("total size",questionList!!.size.toString())
                        startActivity(intent)
                        finish()
                    }
                }
            }
            selected_option=0;
        }
    }

    fun setcolor(opt:Int, color:Int){
        when(opt){
            1->{
               opt_1.background=ContextCompat.getDrawable(this, color)
            }
            2->{
                opt_2.background=ContextCompat.getDrawable(this, color)
            }
            3->{
            opt_3.background=ContextCompat.getDrawable(this, color)
            }
            4->{
            opt_4.background=ContextCompat.getDrawable(this, color)
            }
        }
    }


    fun setfunction(){
        var que=questionList!![current_position-1]

        setOptionSyle()

        question_text.text=que.question
        opt_1.text=que.op1
        opt_2.text=que.op2
        opt_3.text=que.op3
        opt_4.text=que.op4
        progress_bar.progress=current_position;
        progress_bar.max=questionList!!.size
        progress_text.text="${current_position}"+"/"+"${questionList!!.size}"
    }

    fun setOptionSyle(){
        var optionList:ArrayList<TextView> = arrayListOf()
        optionList.add(0,opt_1)
        optionList.add(1,opt_2)
        optionList.add(2,opt_3)
        optionList.add(3,opt_4)

        for(op in optionList){
            op.setTextColor(Color.parseColor("#484747"))
            op.background=ContextCompat.getDrawable(this, R.drawable.questionset)
            op.typeface= Typeface.DEFAULT
        }

    }
    fun selected_OptionStyle(view:TextView, opt:Int){
        setOptionSyle()
        selected_option=opt
        view.background=ContextCompat.getDrawable(this, R.drawable.question_option)
        view.typeface= Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))
    }
}