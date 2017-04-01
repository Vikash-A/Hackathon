package com.jaya.hackthaonproject;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import java.util.Map;

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
    sendNotification(remoteMessage.getData());
    // Log.d(TAG, "Notification Message Body: " + remoteMessage.getNotification().getBody());
  }


  private void sendNotification(Map<String, String> data) {
    final String title = data.get("title");
    final String text = data.get("text");
    PendingIntent pendingIntent = getPendingIntent(data);
    NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);
    Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
    notificationBuilder.setSmallIcon(R.drawable.wangle)
        .setContentTitle(title)
        .setContentText(text)
        .setAutoCancel(true)
        .setSound(defaultSoundUri)
        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.wangle))
        .setContentIntent(pendingIntent);
    NotificationManager notificationManager =
        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
  }

  private PendingIntent getPendingIntent(Map data) {
    Intent resultIntent = new Intent(this, Splash.class);
    resultIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    return PendingIntent.getActivity(this, 0, resultIntent,
        PendingIntent.FLAG_ONE_SHOT);
  }

}
