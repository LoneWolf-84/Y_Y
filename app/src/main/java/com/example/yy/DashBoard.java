package com.example.yy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DashBoard extends AppCompatActivity {
    FloatingActionButton btn_back;
    CardView flutter , web, cyber , desktop;

    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        btn_back = findViewById(R.id.btnback);
        flutter = findViewById(R.id.flutter_card);
        web = findViewById(R.id.web_card);
        cyber = findViewById(R.id.security_card);
        desktop = findViewById(R.id.desktop_card);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        FirebaseAuth auth = FirebaseAuth.getInstance();




        /**/
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashBoard.this , MainActivity.class);
                startActivity(i);
                Toast.makeText(DashBoard.this, "Signed Out", Toast.LENGTH_SHORT).show();
            }
        });

        flutter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(DashBoard.this , flutter_course.class);
                startActivity(I);
            }
        });
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashBoard.this,web_course.class);
                startActivity(i);
            }
        });

        cyber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashBoard.this , cyber_security_course.class);
                startActivity(i);
            }
        });

        desktop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashBoard.this , desktop_course.class);
                startActivity(i);
            }
        });

    }
}