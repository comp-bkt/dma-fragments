package com.leedsbeckett.basicfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu

class MainActivity : AppCompatActivity(), OnColourChoiceHandler {

    
    companion object {
        const val TAG = "Lifecycles"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v(TAG, "Activity - onCreate")
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

        //Log.v(TAG, "Activity - onColourPicked Pre CommitNow ")

        fm.beginTransaction()
            .replace(R.id.container,fragment, "fragment_colour_display")
            .commitNow()

        //Log.v(TAG, "Activity - onColourPicked Post CommitNow ")

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

    override fun onStart() {
        super.onStart()
        Log.v(TAG, "Activity - onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.v(TAG, "Activity - onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.v(TAG, "Activity - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.v(TAG, "Activity - onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.v(TAG, "Activity - onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(TAG, "Activity - onDestroy")
    }

}