# Newsfeed
A list view in android studio to implement the list stored in Firebase Database in Real-time

Objectives:
To retrieve the stored data in the child listener of the Firebase Database in a form of list.
However, you can also push the data using the app.

Main features:
Retrieve the multiple items stored under a key in the Firebase Database in Real-time.

Steps:
1. Create an Android Project with Basic Activity Layout.
2. Go to Tools>Firebase>Add Firebase Realtime Database and let the geadle sync. Sit back for some time and relax.
3. Create an activity "input_dialog.xml" in the layout folder (for taking input from user, hidden button can be 
activated by removing comment in the files ).
4. Thereafter, "model.xml" i.e., the card layout that replicates itself.
5. Create a new java file,"Spacecraft.java", which describes the variables which store values in the list field.
6. Next a CRUD class:"FirebaseHelper.java", to push the values into the database.
7. Thereafter, "CustomAdapter.java" which inflates the layout, handles the clicks and binds the data.
8. Lastly, the "MainActivity.java" to bind all the classes and layouts together.
