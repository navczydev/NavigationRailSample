package com.example.navigationrailsample

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.navigationrailsample.databinding.ActivityMainBinding
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * @author Nav Singh
 * @see [com.google.android.material.bottomnavigation.BottomNavigationView]
 * @see [com.google.android.material.navigationrail.NavigationRailView]
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        // update the text based on the orientation
        activityMainBinding.textview.text = when (resources.configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> {
                getString(R.string.bottom_nav_label)
            }
            else -> {
                getString(R.string.nav_rail_label)
            }
        }

        // add badge to alarm
        val badgeDrawable = activityMainBinding.navigationRail?.getOrCreateBadge(R.id.alarms)
        badgeDrawable?.run {
            Toast.makeText(applicationContext, "Create badge", Toast.LENGTH_SHORT).show()
            number = 999
            badgeTextColor =
                ContextCompat.getColor(applicationContext, android.R.color.white)
            maxCharacterCount = 2
            badgeGravity = BadgeDrawable.BOTTOM_END
            isVisible = true
        }

        // remove badge
        // activityMainBinding.navigationRail?.removeBadge(R.id.alarms)

        activityMainBinding.bottomBar?.setOnItemSelectedListener { item ->
            when (item.itemId) {

                R.id.alarms -> {
                    Toast.makeText(this, "Alarms Clicked", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> {
                    Toast.makeText(this, "Other item clicked", Toast.LENGTH_SHORT).show()
                    true
                }
            }
        }

        activityMainBinding.navigationRail?.headerView?.findViewById<FloatingActionButton>(R.id.fab_add)
            ?.setOnClickListener {
                Toast.makeText(this, "Fab Clicked", Toast.LENGTH_SHORT).show()
            }

        activityMainBinding.navigationRail?.setOnItemSelectedListener { item ->
            when (item.itemId) {

                R.id.alarms -> {
                    Toast.makeText(this, "Alarms Clicked", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> {
                    Toast.makeText(this, "Other item clicked", Toast.LENGTH_SHORT).show()
                    true
                }
            }
        }
    }
}
