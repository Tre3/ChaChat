package com.example.tre3.chachat.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.tre3.chachat.R;
import com.example.tre3.chachat.adapter.ChatAdapter;
import com.example.tre3.chachat.adapter.FriendListAdapter;
import com.example.tre3.chachat.adapter.factory.ChatAdapterFactory;
import com.example.tre3.chachat.adapter.factory.FriendListAdapterFactory;
import com.example.tre3.chachat.contract.ChatContracts;
import com.example.tre3.chachat.eventhandler.FriendListOnItemClickListener;
import com.example.tre3.chachat.presenter.ChatPresenter;

public class ChatActivity extends AppCompatActivity {
    private ChatContracts mChatContracts;

    public static Intent createIntent(Context context) {
        return new Intent(context, ChatActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        mChatContracts = new ChatPresenter("dummy");

        initFriendList();
        initSendButton();
    }

    private void initFriendList() {
        ChatAdapter chatAdapter = ChatAdapterFactory.createChatAdapter(this);

        ListView listView = (ListView) findViewById(R.id.activity_chat_list);
        listView.setAdapter(chatAdapter);
    }

    private void initSendButton() {
        Button sendButton = (Button) findViewById(R.id.activity_chat_send_button);
        final EditText editText = (EditText) findViewById(R.id.activity_chat_edit_text);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mChatContracts.sendMessage(editText.getText().toString());
            }
        });
    }
}
