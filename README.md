# G-articles
<img src="https://user-images.githubusercontent.com/42929865/100415593-9861cb80-308d-11eb-8d73-8416a3942831.jpeg" width="30%"></img> <img src="https://user-images.githubusercontent.com/42929865/100415599-9bf55280-308d-11eb-9101-afcb9b8fff87.jpeg" width="30%"></img> <img src="https://user-images.githubusercontent.com/42929865/100415595-9992f880-308d-11eb-8f39-3f221def79aa.jpeg" width="30%"></img> 

Android app that searches articles from remote server and caches them locally with realtime syc with the new data when Network change occur (Offline)

Architecture
The App is not organized into multiple modules but follows the same principles of the Presentation, Domain, and Data Layers. The presentation layer handles the UI work with the logic contained in the ViewModel. The UI uses a LiveData object from the ViewModel and observes it using the Observer Pattern. A ListAdapter handles the actual displaying of the news. Data over the network is retrieved using retrofit and coroutines to handle background work asynchronously. Additionally, note that the ViewModel uses the viewModelScope to launch the couroutines while Fragments use the viewLifeCycleOwner to observe data. The data layer uses the recommended Repository Pattern to make the network calls and store the data using Room DB.


Once the app is launched, the user has the option of viewing general movies. Alternatively, using the navigation drawer, the user can alo open the discover shows screen. The drawer also has options for opening the favourites for both movies and shows.

Search Screen

This screen is accessible from all the screens and allows the user to search for movies or shows depending on the present fragment. If in the movies fragment, then the user will search for movies and vice versa

Libraries
This app takes use of the following libraries:

Jetpack🚀
Viewmodel - Manage UI data to survive configuration changes and is lifecycle-aware
Data Binding - Declaratively bind observable data to UI elements
Navigation - Handle everything needed for in-app navigation
WorkManager - Manage your Android background jobs
Room DB - Fluent SQLite database access
Paging - Load and display small chunks of data at a time
LiveData - Notify views when underlying database changes
Retrofit - type safe http client with coroutines support
Gson - A Java serialization/deserialization library to convert Java Objects into JSON and back
Dagger2 - A fast dependency injector for Android and Java.
okhttp-logging-interceptor - logging HTTP request related data.
kotlinx.coroutines - Library Support for coroutines
Material Design - build awesome beautiful UIs.🔥🔥
Firebase - Backend As A Service for faster mobile development.
Crashylitics - Provide Realtime crash reports from users end.
Like Button - Twitter's heart animation for Android
Lottie - Render awesome After Effects animations natively on Android and iOS, Web, and React Native
Glide - Hassle-free image loading
Timber - A logger with a small, extensible API which provides utility on top of Android's normal Log class.
