package com.temp.notification;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.app.Application;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.onesignal.OSNotificationAction;
import com.onesignal.OSNotificationOpenedResult;
import com.onesignal.OneSignal;

import org.json.JSONException;
import org.json.JSONObject;

public class Notify extends Application {
    private static final String ONESIGNAL_APP_ID = "6fec9554-5713-49a3-8453-2b61f802e517";
    public  static String Link="";
    @Override
    public void onCreate() {
        super.onCreate();
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);
        OneSignal.setNotificationOpenedHandler(
                new OneSignal.OSNotificationOpenedHandler() {
                    @Override
                    public void notificationOpened(OSNotificationOpenedResult result) {
                        String actionId = result.getAction().getActionId();
                        OSNotificationAction.ActionType type = result.getAction().getType(); // "ActionTaken" | "Opened"
                        JSONObject data = result.getNotification().getAdditionalData();
                        if (data != null) {

                            if (data.toString() != ""){

                                try {
                                    JSONObject getData = new JSONObject(data.toString());
                                    Link = getData.getString("link");
                                    Intent i=new Intent(getApplicationContext(),MainActivity.class);
                                    i.setFlags(FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(i);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                    }


                    }
                });
    }


}
