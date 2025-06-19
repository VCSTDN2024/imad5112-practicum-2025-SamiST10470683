## Basic Information 

### Playlist Manager

**Developer**: [Sami EL Naamani] 

**Student Number**: [ST10470683] 

**Group**: [1] 

**Course**: [Higher Certificate in Mobile Application and Web Development] 

**Subject**: [IMAD5112] 

### Links 

**GitHub Repository**: [https://github.com/VCSTDN2024/imad5112-practicum-2025-SamiST10470683.git] 
 

## Project Overview 

The Playlist Manager is a mobile application developed as part of a practicum assessment in the IMAD5112 subject. This application was created using **Kotlin** and **Android Studio**. The primary objective of the application is to allow users to create, manage, and view a custom playlist of their favorite songs directly on their mobile device. 

The app was developed to meet the requirements of the practicum, which includes creating a functional mobile app and utilising GitHub for version control and CI/CD automation using GitHub Actions. 


## App Purpose 

The primary objective of this application is to provide a simple and efficient way for users to compile a list of songs, add personal ratings and comments, and view the entire playlist in a clean, organised format. 


## Key Features 

**Feature 1**:

Input: Users can enter a song's title, the artist's name, a personal rating from 1 to 5, and custom comments.

Output: The entered song is added to a playlist, and the input fields are cleared for the next entry.

Validation: The app ensures that all fields are filled and that the rating is a number between 1 and 5 before adding a song.

User-Friendly Interface: A clean and simple form makes adding songs quick and intuitive.

**Feature 2**:

Full Details Display: Shows a scrollable list of all songs, each with its title, artist, rating, and comments.

Clear Formatting: Each entry is clearly separated, making the playlist easy to read.

Average Rating Calculation: Users can instantly calculate and display the average rating of all songs currently in the playlist.

**Feature 3**:

Simple Navigation: The app uses clear buttons and intents to move between the welcome screen, the song entry screen, and the playlist details screen.

Instant Feedback: Toast messages provide immediate confirmation when a song is added, a playlist is full, or an error occurs.

Engaging Visuals: The app features a beautifully animated gradient background for a more dynamic and visually appealing experience.

These features are designed to provide a user-friendly and engaging platform for exploring and managing a personal music playlist. The Playlist Manager focuses on core functionality to deliver a straightforward and effective user experience. 


## Design Considerations 

The Playlist Manager was meticulously crafted based on these key considerations: 

**User Experience (UX)**: The app’s design prioritised an intuitive and user-friendly interface, aiming for a seamless user experience. 

**Responsiveness**: The app was meticulously crafted to ensure optimal performance across various screen sizes, with a special focus on device compatibility. 

**Simplicity**: The design adopts a minimalist approach, prioritising core features without overwhelming the user with excessive complexity. 

**Performance**: Code optimisation was a top priority to ensure fast response times and minimal battery consumption. 


## GitHub and GitHub Actions 

This project was managed using **GitHub** for version control. Regularly committed and pushed code changes allowed for collaborative coding, ensuring project integrity. 

**GitHub Actions** was used to automate the build and deployment process. This includes running automated tests to verify app functionality, compiling the app into APK and AAB files for distribution, and uploading these build artefacts to GitHub for easy access. 

The workflow automatically builds and tests the project every time changes are pushed, simplifying the process of delivering the final APK/AAB files for submission. 


## App Screenshots 

### The app source code:
<img width="1371" alt="Screenshot 2025-06-19 at 1 32 27 PM" src="https://github.com/user-attachments/assets/fb6ef350-a644-4cea-969e-4ca47ea84a19" />
<img width="1371" alt="Screenshot 2025-06-19 at 1 32 42 PM" src="https://github.com/user-attachments/assets/d379eb0f-dfec-4eca-be6a-44e2f6a56b19" />
<img width="1371" alt="Screenshot 2025-06-19 at 1 32 52 PM" src="https://github.com/user-attachments/assets/7e7a1409-30f2-4c50-a8de-2a35350af0b7" />
<img width="1371" alt="Screenshot 2025-06-19 at 1 33 00 PM" src="https://github.com/user-attachments/assets/ffdfcf1c-1fdc-4706-acee-da6a533dd265" />
<img width="1371" alt="Screenshot 2025-06-19 at 1 33 08 PM" src="https://github.com/user-attachments/assets/88c84f48-f2f9-4c13-ae13-0d7007d54a6b" />
<img width="1371" alt="Screenshot 2025-06-19 at 1 33 13 PM" src="https://github.com/user-attachments/assets/ccce8282-aedf-4fd2-b77a-4f730716a591" />

### The Main Screen:
**Here the user can input the songs they want in their playlist.**
<img width="316" alt="Screenshot 2025-06-19 at 1 35 07 PM" src="https://github.com/user-attachments/assets/3cc6ac24-d741-4154-92b5-9f148a4fac5c" />

### The Detailed View Screen:
**Here the app displays all the songs in the playlist.**
<img width="310" alt="Screenshot 2025-06-19 at 1 39 30 PM" src="https://github.com/user-attachments/assets/8f0053c9-dfe2-4bbe-b93e-dbb94519ff30" />

### App running on the emulator in Android Studio:
<img width="426" alt="Screenshot 2025-06-19 at 1 35 49 PM" src="https://github.com/user-attachments/assets/c98b7cd2-189d-4b65-b38f-2a09a0273a73" />

## Challenges and Learnings 

During the development of this project, I encountered several challenges, including: 

**Challenge 1**: Seriously struggled to push the code to the classroom repository.

- **Solution**: I used the terminal on MacOS and found a way to push the code. 
   
- **Learning**: This taught me the fundamentals of Git version control beyond the GUI, providing a deeper understanding of branches, commits, and remotes.
  

**Challenge 2**: Debugging the initial code due to an error in the Android Manifest 

- **Solution**: Had to declare the activities: (android:name=""). 

**Learning**: This reinforced the importance of the Android Manifest as the central configuration file for the app and the need to ensure all components are properly declared.

From these challenges, I learned important lessons in debugging and pushing the code to the Github repository. 


## Future Enhancements 

While the current version of the app provides core playlist management functionality, there are several features that could be added in the future, such as: 

**Persistent Storage**: Implement local storage using SharedPreferences or a Room database to save the playlist, so the user's data is not lost when the app is closed and reopened.

**Edit and Delete Functionality**: Allow users to remove a song from the playlist or edit its details after it has been added.

**Sorting and Filtering**: Add options to sort the playlist alphabetically by song title or artist, or to filter it based on rating.


## References 

1. W3Schools, n.d. JavaScript Tutorial. [online] Available at: https://www.w3schools.com [Accessed 20 April 2025]. 

2. Logging: https://developer.android.com/studio/debug/logcat 

3. Array Declaration: https://kotlinlang.org/docs/arrays.html

4. startActivity and Intent: https://developer.android.com/reference/android/content/Intent

5. For-Loop in Kotlin: https://kotlinlang.org/docs/control-flow.html#for-loops

6. Toast messages: https://developer.android.com/guide/topics/ui/notifiers/toasts

7. Error Handling: https://kotlinlang.org/docs/exceptions.html

8. [Sonar Systems/Author Unknown], n.d. Map: mapOf Function – Kotlin Programming. [video online] Available at: https://youtu.be/18h8ZleInKA?si=IHj0X6O-0MEADGZg [Accessed 30 April 2025]. 

9. [Tech Projects/Author Unknown], n.d. How to move from one activity to another in android studio on button click | Tech projects. [video online] Available at: https://youtu.be/JOdWT50bWw4?si=WYjRpKSvAl_6iJGN [Accessed 19 April 2025]. 

10. [Polliverse/Author Unknown], n.d. Access UI elements in Android studio. [video online] Available at: https://youtu.be/fUAi_RCCNIg?si=MVpZ6manAeX-KcgI [24 April 2025]. 

11. [Rami Wahid/Author Unknown], n.d. Make simple exit button in android studio. [video online] Available at: https://youtu.be/Yx63M4k-EeE?si=nP31E2SQISxRnZHZ [Accessed 27 April 2025]. 

12. [DJ Malone/Author Unknown], n.d. Android Tutorial: findViewById and setOnClickListener(). [video online] Available at: https://youtu.be/Cw3F7NeaI3I?si=AM1wfIaBfORFwNcm [Accessed 27 April 2025] 

13. [Muzzi Design/Author Unknown], n.d. Make Animated Gradient Background Like Instagram Using Kotlin | Animated Gradient Background Android. [video online] Available at: http://www.youtube.com/watch?v=xkqLuMK8vjE [Accessed 27 April 2025]. 

14. [Mr. Jitendra/Author Unknown], n.d. How to Change Android Studio | Theme | Font Family | Font Size. [video online] Available at: https://youtu.be/hALSwU7g36M [Accessed 27 April 2025]. 

15. [Google Fonts/Author Unknown], n.d. Poppins. [online font] Available at: https://fonts.google.com/specimen/Poppins [Accessed 20 April 2025]. 
