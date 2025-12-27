import * as functions from "firebase-functions";
import * as admin from "firebase-admin";

// Initialize Firebase Admin
admin.initializeApp();

// Example HTTP function
export const helloWorld = functions.https.onRequest((request, response) => {
  response.json({ message: "Hello from Firebase!" });
});

// Example Firestore trigger
export const onUserCreate = functions.firestore
  .document("users/{userId}")
  .onCreate(async (snap, context) => {
    const userId = context.params.userId;
    const userData = snap.data();

    console.log(`New user created: ${userId}`, userData);

    // Add your logic here
    return null;
  });

// Example scheduled function (runs every day at midnight)
export const dailyTask = functions.pubsub
  .schedule("0 0 * * *")
  .timeZone("UTC")
  .onRun(async context => {
    console.log("Running daily task");

    // Add your scheduled task logic here

    return null;
  });

// Example callable function
export const getUserData = functions.https.onCall(async (data, context) => {
  // Check authentication
  if (!context.auth) {
    throw new functions.https.HttpsError(
      "unauthenticated",
      "User must be authenticated"
    );
  }

  const userId = context.auth.uid;

  try {
    const userDoc = await admin
      .firestore()
      .collection("users")
      .doc(userId)
      .get();

    if (!userDoc.exists) {
      throw new functions.https.HttpsError("not-found", "User not found");
    }

    return userDoc.data();
  } catch (error) {
    console.error("Error fetching user data:", error);
    throw new functions.https.HttpsError(
      "internal",
      "Failed to fetch user data"
    );
  }
});
