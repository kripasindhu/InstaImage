# InstaImage is An Android app consuming Pixabay API to search and display list of images,
It is built with MVVM pattern.

Min Api Level: 24
Build System : Gradle
The app loads the images from the pixabay api based on search query and displays them in a list.
It also has Room DB for local cache.
When the Image is clicked, a dialog is shown and upon positive user input the app navigates to the Details fragment which shows a bigger picture.

The app is built using the Modular MVVM architectural pattern and makes heavy use of a couple of Android Jetpack components.
With MVVM testing is made easier in that Ui can be tested separately from the business logic.
Mocking the ViewModel to test the fragment for user interaction using espresso, mocking the repository to test the ViewModel with Junit as well as mocking the API service/dao to test the repository using the Junit. 
The App has tests on Fragments as well as Paging test under the Android Test packages in respective modules.
