package com.example.icalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    lateinit var one : TextView
    lateinit var two: TextView
    lateinit var three: TextView
    lateinit var four: TextView
    lateinit var five: TextView
    lateinit var six: TextView
    lateinit var seven: TextView
    lateinit var eight: TextView
    lateinit var nine: TextView
    lateinit var zero: TextView
    lateinit var dot: TextView

    lateinit var addition: TextView
    lateinit var subtraction: TextView
    lateinit var multiplication: TextView
    lateinit var division: TextView

    lateinit var equal: TextView
    lateinit var clear: TextView
    lateinit var result: TextView
    lateinit var expression: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        zero = findViewById(R.id.zero)
        dot = findViewById(R.id.dot)

        addition=findViewById(R.id.add)
        subtraction=findViewById(R.id.sub)
        multiplication=findViewById(R.id.mul)
        division=findViewById(R.id.div)

        expression=findViewById(R.id.expression)
        result=findViewById(R.id.result)
        clear=findViewById(R.id.clear)
        equal=findViewById(R.id.isequal)

        zero.setOnClickListener{
            pressbutton("0",true)
        }

        one.setOnClickListener{
            pressbutton("1",true)
        }


        two.setOnClickListener{
            pressbutton("2",true)
        }


        three.setOnClickListener{
            pressbutton("3",true)
        }

        four.setOnClickListener{
            pressbutton("4",true)
        }

        five.setOnClickListener{
            pressbutton("5",true)
        }


        six.setOnClickListener{
            pressbutton("6",true)
        }


        seven.setOnClickListener{
            pressbutton("7",true)
        }

        eight.setOnClickListener{
            pressbutton("8",true)
        }

        nine.setOnClickListener{
            pressbutton("9",true)
        }


        addition.setOnClickListener{
            pressbutton("+",true)
        }


        subtraction.setOnClickListener{
            pressbutton("-",true)
        }

        multiplication.setOnClickListener{
            pressbutton("*",true)
        }

        division.setOnClickListener{
            pressbutton("/",true)
        }

        dot.setOnClickListener{
            pressbutton(".",true)
        }

        clear.setOnClickListener{
            expression.text=""
            result.text=""
        }

        equal.setOnClickListener{
            val text=expression.text.toString()
            val express=ExpressionBuilder(text).build()

            val res=express.evaluate()
            val x=res.toLong()

            if(res == x.toDouble())
                result.text=x.toString()
            else
                result.text=res.toString()

        }

    }

    private fun pressbutton(s:String,b:Boolean){
        if(b)
        {
            result.text=""
            expression.append(s)
        }
    }

}