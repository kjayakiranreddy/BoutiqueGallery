package com.java.srisaimanchamworks;

import android.content.Context;
import android.widget.Toast;

public class Message {
    public static void toastMessage(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
