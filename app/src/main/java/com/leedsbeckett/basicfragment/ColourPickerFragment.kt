package com.leedsbeckett.basicfragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class ColourPickerFragment : Fragment() {

    var listener:OnColourChoiceHandler? = null

    companion object {
        fun newInstance() = ColourPickerFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
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
        val view = inflater.inflate(R.layout.fragment_colour_picker, container, false)

        val almondButton: Button = view.findViewById(R.id.almond_button)
        almondButton.setOnClickListener {
            listener?.onColourPicked(ColourDisplayFragment.ALMOND)
        }

        val coralButton: Button = view.findViewById(R.id.coral_button)
        coralButton.setOnClickListener {
            listener?.onColourPicked(ColourDisplayFragment.CORAL)
        }
        val pearButton: Button = view.findViewById(R.id.pear_button)
        pearButton.setOnClickListener {
            listener?.onColourPicked(ColourDisplayFragment.PEAR)
        }

        val orchidButton: Button = view.findViewById(R.id.orchid_button)
        orchidButton.setOnClickListener {
            listener?.onColourPicked(ColourDisplayFragment.ORCHID)
        }

        return view
    }

}
