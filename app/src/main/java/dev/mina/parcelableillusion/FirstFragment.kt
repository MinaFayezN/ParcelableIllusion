package dev.mina.parcelableillusion

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.first_layout.*


class FirstFragment : Fragment() {

    lateinit var firstChild: ChildOne
    lateinit var secondChild: ChildTwo

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
            val bundle = Bundle()
            if (firstChild != null)
                bundle.putParcelable(FIRST_CHILD_EXTRA, firstChild)
            if (secondChild != null)
                bundle.putParcelable(SECOND_CHILD_EXTRA, secondChild)
            val fragment = SecondFragment()
            fragment.arguments = bundle
            fragmentManager!!.beginTransaction().replace(R.id.fragment_container, fragment).commit()

        }
    }


}
