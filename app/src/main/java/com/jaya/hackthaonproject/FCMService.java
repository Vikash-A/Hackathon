package com.jaya.hackthaonproject;

import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by vikash.agarwal on 26/03/17.
 */
public class FCMService extends FirebaseMessagingService {

  private static final String TAG = "FCMService";

  @Override
  public void onMessageReceived(RemoteMessage remoteMessage) {
    // TODO(developer): Handle FCM messages here.
    // If the application is in the foreground handle both data and notification messages here.
    // Also if you intend on generating your own notifications as a result of a received FCM
    // message, here is where that should be initiated. See sendNotification method below.
    Log.d(TAG, "DATA: " + remoteMessage.getData());
   // Log.d(TAG, "Notification Message Body: " + remoteMessage.getNotification().getBody());
  }
}
