package com.leedsbeckett.basicfragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class ColourDisplayFragment : Fragment() {

    private lateinit var bg:ConstraintLayout
    private lateinit var tv:TextView

    var listener:OnColourChoiceHandler? = null

    companion object {
        private const val ARG_RESOURCE_COLOR_ID = "color_id"
        private const val ARG_TITLE_ID = "title_id"

        const val ALMOND = 0
        const val PEAR= 1
        const val ORCHID = 2
        const val CORAL = 3

        fun newInstance(resourceColor:Int, title:String? ):ColourDisplayFragment {
            val args = Bundle()
            args.putInt(ARG_RESOURCE_COLOR_ID, resourceColor)
            args.putString(ARG_TITLE_ID, title)
            val fragment = ColourDisplayFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.v(MainActivity.TAG, "ColourDisplayFragment - onAttach")
        if (context is OnColourChoiceHandler) {
            listener = context
        } else {
            throw ClassCastException(requireContext().toString() + " must implement OnColourChoiceListener.")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.v(MainActivity.TAG, "ColourDisplayFragment - onCreateView")
        val view = inflater.inflate(R.layout.fragment_colour_display, container, false)

        bg = view.findViewById(R.id.main)
        tv = view.findViewById(R.id.message)

        if(arguments !=null) {
            bg.setBackgroundColor(requireArguments().getInt(ARG_RESOURCE_COLOR_ID))
            tv.text = requireArguments().getString(ARG_TITLE_ID)
        }

        val pickerBtn: Button = view.findViewById(R.id.colour_picker_button)
        pickerBtn.setOnClickListener {
            listener?.switchToColourPicker()
        }


        return view
    }

    fun updateUI(choice: Int) {
        if(choice==ALMOND){
            bg.setBackgroundColor(resources.getColor(R.color.almond, null))
            tv.text = "Almond"
        }
        if(choice==PEAR){
            bg.setBackgroundColor(resources.getColor(R.color.pear, null))
            tv.text = "Pear"
        }
        if(choice==CORAL){
            bg.setBackgroundColor(resources.getColor(R.color.coral, null))
            tv.text = "Coral"
        }
        if(choice==ORCHID){
            bg.setBackgroundColor(resources.getColor(R.color.orchid, null))
            tv.text = "Orchid"
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v(MainActivity.TAG, "ColourDisplayFragment - onCreate")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.v(MainActivity.TAG, "ColourDisplayFragment - onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.v(MainActivity.TAG, "ColourDisplayFragment - onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.v(MainActivity.TAG, "ColourDisplayFragment - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.v(MainActivity.TAG, "ColourDisplayFragment - onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.v(MainActivity.TAG, "ColourDisplayFragment - onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.v(MainActivity.TAG, "ColourDisplayFragment - onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(MainActivity.TAG, "ColourDisplayFragment - onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.v(MainActivity.TAG, "ColourDisplayFragment - onDetach")
    }
}