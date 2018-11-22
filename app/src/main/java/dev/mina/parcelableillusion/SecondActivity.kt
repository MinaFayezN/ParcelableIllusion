package dev.mina.parcelableillusion

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.second_layout.*

class SecondActivity : AppCompatActivity() {


    lateinit var firstChild: ChildOne
    lateinit var secondChild: ChildTwo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        retrieve_child_one.setOnClickListener {
            firstChild = intent.getParcelableExtra<ChildOne>(FIRST_CHILD_EXTRA)
        }
        retrieve_child_two.setOnClickListener {
            secondChild = intent.getParcelableExtra<ChildTwo>(SECOND_CHILD_EXTRA)
        }
    }
}
