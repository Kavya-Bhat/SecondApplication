package com.example.secondapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity
{
    TextView descriptionView ;
    LeftOrRightChoice tinderExpert  = new LeftOrRightChoice();
    Button submitButton;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bindViews();
        createNextActivity();
        setUpListener();
    }
    private void bindViews()
    {
        descriptionView = findViewById(R.id.textView_descriptionResult);
        submitButton = findViewById(R.id.buttonSubmit);
    }

    private void createNextActivity()
    {
        Intent intent = getIntent();
        index = intent.getIntExtra("one",0);
        descriptionView.setText(tinderExpert.nextDescription(index));
    }

    private void setUpListener()
    {
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String to=tinderExpert.nextName(index);
                String subject="Message for you!";
                String message="Hey there!We have been matched,lets meet up soon.";


                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });
    }
}
