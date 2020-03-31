package com.example.flexboxbug

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    private val fragment: Fragment = MyFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val f = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (f == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commitNow()
        }

        findViewById<View>(R.id.bug).setOnClickListener {
            // remove fragment
            supportFragmentManager.beginTransaction().remove(fragment).commitNow()

            // add fragment again to trigger on restore saved instance
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commitNow()

        }
    }
}
