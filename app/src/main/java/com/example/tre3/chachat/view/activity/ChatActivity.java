package com.example.tre3.chachat.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.tre3.chachat.R;

public class ChatActivity extends AppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, ChatActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
    }
}
