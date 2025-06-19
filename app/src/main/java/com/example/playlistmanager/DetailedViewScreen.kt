/* ST10470683
* Full Name: Sami EL Naamani
* For-Loop in Kotlin: https://kotlinlang.org/docs/control-flow.html#for-loops
* Intents to receive data: https://developer.android.com/guide/components/activities/fundamentals#receiving-results
* Toast messages: https://developer.android.com/guide/topics/ui/notifiers/toasts
* Logging: https://developer.android.com/studio/debug/logcat
*/

package com.example.playlistmanager
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class DetailedViewScreen : AppCompatActivity() {

    // Declare UI elements
    private lateinit var PlaylistDetails: TextView
    private lateinit var ShowPlaylist: Button
    private lateinit var CalculateAverage: Button
    private lateinit var ReturnToMain: Button

    // Declare lists to hold data received from MainScreen
    private var songTitles: ArrayList<String>? = null
    private var artistNames: ArrayList<String>? = null
    private var ratings: ArrayList<Int>? = null
    private var comments: ArrayList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view_screen)

        // Initialize UI elements
        PlaylistDetails = findViewById(R.id.PlaylistDetails)
        ShowPlaylist = findViewById(R.id.ShowPlaylist)
        CalculateAverage = findViewById(R.id.CalculateAverage)
        ReturnToMain = findViewById(R.id.ReturnToMain)

        // Retrieve data passed from MainScreen using Intent extras
        songTitles = intent.getStringArrayListExtra("songTitles")
        artistNames = intent.getStringArrayListExtra("artistNames")
        ratings = intent.getIntegerArrayListExtra("ratings")
        comments = intent.getStringArrayListExtra("comments")

        // Set onClick listener for "Show Playlist" button
        ShowPlaylist.setOnClickListener {
            displayPlaylistDetails()
        }

        // Set onClick listener for "Calculate Average Rating" button
        CalculateAverage.setOnClickListener {
            calculateAndDisplayAverageRating()
        }

        // Set onClick listener for "Return" button.
        ReturnToMain.setOnClickListener {
            finish() // Closes the current activity.
            Log.i("DetailedViewScreen", "Returning to MainScreen.") // Log info
        }

        // Find the layout so it can apply background animation to it.
        val constraintLayout = findViewById<ConstraintLayout>(R.id.constraintLayout)

        // Cast the background of the layout to an AnimationDrawable so it can be animated.
        val animationDrawable = constraintLayout.background as AnimationDrawable

        // Configure the animation settings.
        animationDrawable.apply {
            setEnterFadeDuration(1000) // Duration of the fade-in animation.
            setExitFadeDuration(2000) // Duration of the fade-out animation.
            start()
        }
    }

    private fun displayPlaylistDetails() {
        // Clear previous text
        PlaylistDetails.text = ""

        // Check if any songs are in the playlist
        if (songTitles.isNullOrEmpty()) {
            PlaylistDetails.text = "No songs in the playlist yet."
            Toast.makeText(this, "No songs to display.", Toast.LENGTH_SHORT).show()
            Log.i("DetailedViewScreen", "Attempted to display empty playlist.") // Log info
            return
        }

        val stringBuilder = StringBuilder()
        // Loop through the arrays to build the display string
        for (i in 0 until songTitles!!.size) {
            stringBuilder.append("Song Title: ${songTitles!![i]}\n")
            stringBuilder.append("Artist: ${artistNames!![i]}\n")
            stringBuilder.append("Rating: ${ratings!![i]}/5\n")
            stringBuilder.append("Comments: ${comments!![i]}\n")
            stringBuilder.append("-----------------------------\n")
            Log.d("DetailedViewScreen", "Displaying song $i: ${songTitles!![i]}") // Log debug
        }
        PlaylistDetails.text = stringBuilder.toString()
        Toast.makeText(this, "Playlist displayed.", Toast.LENGTH_SHORT).show()
    }

    private fun calculateAndDisplayAverageRating() {
        if (ratings.isNullOrEmpty()) {
            Toast.makeText(this, "No ratings available to calculate average.", Toast.LENGTH_SHORT).show()
            Log.i("DetailedViewScreen", "Attempted to calculate average with no ratings.") // Log info
            return
        }

        var totalRating = 0.0
        // Calculate the sum of ratings using a loop
        for (rating in ratings!!) {
            totalRating += rating
            Log.v("DetailedViewScreen", "Accumulating rating: $rating, Current total: $totalRating")
        }

        val averageRating = totalRating / ratings!!.size
        val formattedAverage = String.format("%.2f", averageRating) // Format 2 decimal places.

        val message = "Average Rating: $formattedAverage"
        PlaylistDetails.text = message // Display in the TextView
        Toast.makeText(this, message, Toast.LENGTH_LONG).show() // Show as a Toast
        Log.d("DetailedViewScreen", "Calculated average rating: $formattedAverage") // Log debug
    }
}