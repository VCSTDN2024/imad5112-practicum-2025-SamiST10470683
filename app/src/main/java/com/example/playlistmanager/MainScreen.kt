/* ST10470683
* Full Name: Sami EL Naamani
* Logging: https://developer.android.com/studio/debug/logcat
* Array Declaration: https://kotlinlang.org/docs/arrays.html
* startActivity and Intent: https://developer.android.com/reference/android/content/Intent
* For-Loop in Kotlin: https://kotlinlang.org/docs/control-flow.html#for-loops
* Toast messages: https://developer.android.com/guide/topics/ui/notifiers/toasts
* Error Handling: https://kotlinlang.org/docs/exceptions.html
* W3 Schools - https://www.w3schools.com
*/

package com.example.playlistmanager
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainScreen : AppCompatActivity() {

    // Declare UI elements
    private lateinit var SongTitle: EditText
    private lateinit var ArtistName: EditText
    private lateinit var Rating: EditText
    private lateinit var Comments: EditText
    private lateinit var AddPlaylist: Button
    private lateinit var DetailedView: Button
    private lateinit var ExitApp: Button

    // Declare parallel arrays to store song details.
    private val songTitles = mutableListOf<String>()
    private val artistNames = mutableListOf<String>()
    private val ratings = mutableListOf<Int>()
    private val comments = mutableListOf<String>()

    // Constants
    private val MAX_SONGS = 4 // Limit for the number of songs.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen) // Set the layout for the main screen.

        // Initialize UI elements
        SongTitle = findViewById(R.id.SongTitle)
        ArtistName = findViewById(R.id.ArtistName)
        Rating = findViewById(R.id.Rating)
        Comments = findViewById(R.id.Comments)
        AddPlaylist = findViewById(R.id.AddPlaylist)
        DetailedView = findViewById(R.id.DetailedView)
        ExitApp = findViewById(R.id.ExitApp)

        // Set onClick listener for "Add to Playlist" button.
        AddPlaylist.setOnClickListener {
            addSongToPlaylist()
        }

        // Set onClick listener for "View Playlist Details" button.
        DetailedView.setOnClickListener {
            navigateToDetailedView()
        }

        // Set onClick listener for "Exit App" button
        ExitApp.setOnClickListener {
            exitApp()
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

    private fun addSongToPlaylist() {
        val songTitle = SongTitle.text.toString().trim()
        val artistName = ArtistName.text.toString().trim()
        val ratingString = Rating.text.toString().trim()
        val comment = Comments.text.toString().trim()

        // Error handling for empty fields
        if (songTitle.isEmpty() || artistName.isEmpty() || ratingString.isEmpty() || comment.isEmpty()) {
            Toast.makeText(this, "Please fill in all the fields.", Toast.LENGTH_SHORT).show()
            Log.w("MainScreen", "Attempted to add song with empty fields.") // Log warning
            return
        }

        // Check if playlist is full
        if (songTitles.size >= MAX_SONGS) {
            Toast.makeText(this, "The playlist is full (max $MAX_SONGS songs).", Toast.LENGTH_LONG).show()
            Log.i("MainScreen", "Attempted to add song but the playlist is full.") // Log info
            return
        }

        // Error handling for rating
        val rating = ratingString.toIntOrNull()
        if (rating == null || rating !in 1..5) {
            Toast.makeText(this, "Rating must be a number between 1 & 5.", Toast.LENGTH_SHORT).show()
            Log.e("MainScreen", "Invalid rating was entered: $ratingString") // Log error
            return
        }

        // Add details to the Parallel arrays
        songTitles.add(songTitle)
        artistNames.add(artistName)
        ratings.add(rating)
        comments.add(comment)

        Toast.makeText(this, "$songTitle added to the playlist!", Toast.LENGTH_SHORT).show()
        Log.d("MainScreen", "Song Added: $songTitle by $artistName, Rating: $rating") // Log debugging

        // Clear input fields after adding.
        SongTitle.text.clear()
        ArtistName.text.clear()
        Rating.text.clear()
        Comments.text.clear()
    }

    private fun navigateToDetailedView() {
        // Create an Intent to start DetailedViewScreen.
        val intent = Intent(this, DetailedViewScreen::class.java)

        // Pass all arrays to the next activity using intent.
        // Using toTypedArray() converts MutableList to Array for Intent.
        intent.putStringArrayListExtra("songTitles", ArrayList(songTitles))
        intent.putStringArrayListExtra("artistNames", ArrayList(artistNames))
        intent.putIntegerArrayListExtra("ratings", ArrayList(ratings))
        intent.putStringArrayListExtra("comments", ArrayList(comments))

        startActivity(intent) // Start the DetailedViewScreen
        Log.i("MainScreen", "Navigating to DetailedViewScreen.")
    }

    private fun exitApp() {
        finishAffinity() // Closes all activities.
        Log.i("MainScreen", "Exiting application.")
    }
}

