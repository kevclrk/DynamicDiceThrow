package edu.temple.dicethrow

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


/*
Our DieThrow application has been refactored to move the dieRoll() logic
into the ViewModel instead of the Fragment.
Study the DieViewModel, ButtonFragment, and DieFragment classes to
see the changes.

Follow the requirements below to have this app function
in both portrait and landscape configurations.
The Activity layout files for both Portrait and Landscape are already provided
*/

class MainActivity : AppCompatActivity(), ButtonFragment.ButtonInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Check if this is the first time the activity is being created
        if (savedInstanceState == null) {
            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                // Portrait mode: Load only the ButtonFragment
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container1, ButtonFragment())
                    .commit()
            } else if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                // Landscape mode: Load both ButtonFragment and DieFragment
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container1, ButtonFragment())
                    .replace(R.id.container2, DieFragment())
                    .commit()
            }
        }
    }

    // TODO 2: Switch fragments in portrait mode when button is clicked
    override fun buttonClicked() {
        // This action is only needed in portrait mode
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            // Replace ButtonFragment with DieFragment
            supportFragmentManager.beginTransaction()
                .replace(R.id.container1, DieFragment())
                .addToBackStack(null) // Allow reverse navigation with Back button
                .commit()
        }
    }
}