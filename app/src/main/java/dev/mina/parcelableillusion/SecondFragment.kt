package dev.mina.parcelableillusion

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.second_layout.*


class SecondFragment : Fragment() {

    lateinit var firstChild: ChildOne
    lateinit var secondChild: ChildTwo
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        retrieve_child_one.setOnClickListener {
            firstChild = arguments!!.getParcelable(FIRST_CHILD_EXTRA)!!
        }
        retrieve_child_two.setOnClickListener {
            secondChild = arguments!!.getParcelable(SECOND_CHILD_EXTRA)!!
        }
    }


}
