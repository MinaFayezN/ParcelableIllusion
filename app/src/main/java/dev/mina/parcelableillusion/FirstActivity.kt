package dev.mina.parcelableillusion

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.first_layout.*

const val FIRST_CHILD_EXTRA = "FirstChild"

const val SECOND_CHILD_EXTRA = "SecondChild"

class FirstActivity : AppCompatActivity() {

    lateinit var firstChild: ChildOne
    lateinit var secondChild: ChildTwo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, FirstFragment()).commit()
        create_child_one.setOnClickListener {
            firstChild = ChildOne()
            firstChild.childString = "One"
            firstChild.childEnum = SecondEnum.CHILD_ITEM_TWO

            firstChild.firstNo = 123
            firstChild.secondNo = 123
            firstChild.firstText = "Parent One"
            firstChild.enumItem = FirstEnum.ITEM_TWO
        }
        create_child_two.setOnClickListener {
            secondChild = ChildTwo()
            secondChild.childNo = 11
            secondChild.childText = "Two"

            secondChild.firstNo = 456
            secondChild.secondNo = 456
            secondChild.firstText = "Parent Two"
            secondChild.enumItem = FirstEnum.ITEM_TWO
        }
        send_items.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            val bundle = Bundle()
            if (firstChild != null)
                bundle.putParcelable(FIRST_CHILD_EXTRA, firstChild)
            if (secondChild != null)
                bundle.putParcelable(SECOND_CHILD_EXTRA, secondChild)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}
