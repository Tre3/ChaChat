package com.example.tre3.chachat.view.activity;

import android.content.Context;
import android.content.Intent;

public class ChatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, ChatActivity.class);
    }
}
