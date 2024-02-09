const functions = require("firebase-functions");
const admin = require("firebase-admin");

admin.initializeApp();

exports.sendMedicationReminder = functions.https.onRequest((req, res) => {
  const registrationToken = req.body.token;

  const message = {
    data: {
      title: "Training Reminder",
      body: `It's time to burn some calories!`,
    },
    token: registrationToken,
  };

  admin.messaging().send(message)
      .then((response) => {
        console.log("Successfully sent message:", response);
        res.status(200).send("Notification sent successfully");
      })
      .catch((error) => {
        console.error("Error sending message:", error);
        res.status(500).send("Error sending notification");
      });
});
