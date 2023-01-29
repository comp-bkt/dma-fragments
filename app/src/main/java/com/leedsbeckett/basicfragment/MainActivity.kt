package com.leedsbeckett.basicfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), OnColourChoiceHandler {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fm = supportFragmentManager
        if (fm.findFragmentByTag("fragment_colour_display")==null) {
            fm.beginTransaction()
                .replace(R.id.container,
                    ColourDisplayFragment.newInstance(resources.getColor(R.color.almond, null),
                                            "Almond"),
                    "fragment_colour_display")
                .commitNow()
        }
    }

    override fun onColourPicked(choice: Int) {
        val fm = supportFragmentManager
        var fragment = fm.findFragmentByTag("fragment_colour_display")
        if(fragment==null) fragment=ColourDisplayFragment.newInstance(resources.getColor(R.color.almond, null),
            "Almond")

        fm.beginTransaction()
            .replace(R.id.container,fragment, "fragment_colour_display")
            .commitNow()

        if(fragment is ColourDisplayFragment) {
            fragment.updateUI(choice)
        }
    }

    override fun switchToColourPicker() {
        val fm = supportFragmentManager
        var fragment = fm.findFragmentByTag("colour_picker")
        if(fragment==null) fragment=ColourPickerFragment.newInstance()

        fm.beginTransaction()
            .replace(R.id.container,fragment, "colour_picker")
            .commitNow()
    }
}