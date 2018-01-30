package com.example.kotlinandroidhelloworld

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import org.jetbrains.anko.linearLayout
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.textView

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        linearLayout{
            textView(intent.extras["Key"]?.toString()?:"Hello") {
                gravity = Gravity.CENTER
            }.lparams(matchParent, matchParent) {
                gravity = Gravity.CENTER
            }
        }
    }
}
