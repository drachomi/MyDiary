package com.richard.imoh.mediary;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewMessage extends AppCompatActivity {
    private FirebaseDatabase mFireBaseDatabase;
    private DatabaseReference mMessageDatabaseReference;
    EditText title,mainMsg;
    Button btn;
    ChildEventListener childEventListener;
    List<Message> messageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message);
        Bundle bundle = getIntent().getExtras();
        String username = bundle.getString("username");

        long millis = new Date().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        final String millisInString  = dateFormat.format(new Date());
        title = findViewById(R.id.title_edit_txt);
        mainMsg = findViewById(R.id.msg_edit_text);
        btn = findViewById(R.id.subbtn);
        mFireBaseDatabase = FirebaseDatabase.getInstance();
        mMessageDatabaseReference = mFireBaseDatabase.getReference().child("messages").child(username);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Message message = new Message("1",mainMsg.getText().toString(),millisInString,title.getText().toString());
                mMessageDatabaseReference.push().setValue(message);
                finish();
            }
        });


    }
}
