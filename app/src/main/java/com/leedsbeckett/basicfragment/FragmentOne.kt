package com.leedsbeckett.basicfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class FragmentOne : Fragment() {

    companion object {
        private const val ARG_RESOURCE_COLOR_ID = "color_id"
        private const val ARG_TITLE_ID = "title_id"
        fun newInstance(resourceColor:Int, title:String? ):FragmentOne {
            val args = Bundle()
            args.putInt(ARG_RESOURCE_COLOR_ID, resourceColor)
            args.putString(ARG_TITLE_ID, title)
            val fragment = FragmentOne()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_one, container, false)

        val bg:ConstraintLayout = view.findViewById(R.id.main)
        val tv: TextView = view.findViewById(R.id.message)

        if(arguments !=null) {
            bg.setBackgroundColor(requireArguments().getInt(ARG_RESOURCE_COLOR_ID))
            tv.text = requireArguments().getString(ARG_TITLE_ID)
        }

        return view
    }

}