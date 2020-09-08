package com.example.secondapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    TextView descriptionTextView;
    Button leftButton;
    Button rightButton;
    ImageView profilePic;
    TextView profileName;
    LeftOrRightChoice leftOrRightChoice = new LeftOrRightChoice();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        setUpListeners();

    }
    private void bindViews()
    {
        profileName= findViewById(R.id.textViewName1);
        profilePic = findViewById(R.id.image1);
        leftButton = findViewById(R.id.Left);
        rightButton = findViewById(R.id.Right);

    }

    private void setUpListeners()
    {
        leftButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
               int index = leftOrRightChoice.getOne();
               Intent intent = new Intent(MainActivity.this, MainActivity2.class);
               intent.putExtra("one",index);
               startActivity(intent);
            }
        });

        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                profilePic.setImageResource(leftOrRightChoice.nextImage());
                profileName.setText(leftOrRightChoice.nextName());


            }
        });
    }
}



