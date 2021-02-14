package com.example.yy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class create_account extends AppCompatActivity {

    TextView txtlogin;
    EditText name, up, passup, passupc, phone;
    FirebaseAuth auth;
    DatabaseReference reference;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        txtlogin = findViewById(R.id.txtlogin);
        b = findViewById(R.id.btnregister);
        name = findViewById(R.id.name);
        up = findViewById(R.id.up);
        passup = findViewById(R.id.passup);
        passupc = findViewById(R.id.passupc);
        phone = findViewById(R.id.phone);
        auth = FirebaseAuth.getInstance();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        txtlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(create_account.this , MainActivity.class);
                startActivity(i);
            }

        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String names = name.getText().toString();
                String mail = up.getText().toString().trim();
                String password = passup.getText().toString().trim();
                String password2 = passupc.getText().toString().trim();
                String ph = phone.getText().toString().trim();
                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

                if (TextUtils.isEmpty(mail)) {
                    up.setError("Enter The E-mail");
                    up.setHintTextColor(getResources().getColor(R.color.red));
                    v.vibrate(400);
                    return;
                }  else if (TextUtils.isEmpty(password)) {
                    passup.setError("Please Enter Your Password");
                    passup.setHintTextColor(getResources().getColor(R.color.red));
                    v.vibrate(400);
                    return;
                } else if (passup.length() < 6) {
                    passup.setError("must be >6");
                    v.vibrate(400);
                    return;
                }
                else if (TextUtils.isEmpty(password)) {
                    passupc.setError("Please Enter Your Password");
                    passupc.setHintTextColor(getResources().getColor(R.color.red));
                    v.vibrate(400);
                    return;
                } else if (passupc.length() < 6) {
                    passupc.setError("must be >6");
                    v.vibrate(400);
                    return;
                }

                if (TextUtils.isEmpty(names))
                {
                    name.setError("Please Enter Your Name");
                    v.vibrate(400);
                    return;
                }
                if(TextUtils.isEmpty(ph))
                {
                    phone.setError("Please Enter Your Phone");
                }

                if (passup.getText().toString().equals(passupc.getText().toString())){
                    auth.createUserWithEmailAndPassword(mail, password2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful())
                            {
                                Toast.makeText(create_account.this, "Succefully Signed Up", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(create_account.this,DashBoard.class);
                                reference = database.getReference().child(auth.getUid()).child("name");
                                reference.setValue(name.getText().toString());
                                reference = database.getReference().child(auth.getUid()).child("points").child("point web");
                                reference.setValue(0);
                                reference = database.getReference().child(auth.getUid()).child("points").child("point Flutter");
                                reference.setValue(0);
                                reference = database.getReference().child(auth.getUid()).child("points").child("point Security");
                                reference.setValue(0);
                                reference = database.getReference().child(auth.getUid()).child("points").child("point desktop");
                                reference.setValue(0);
                                startActivity(i);
                            }
                            else {
                                Toast.makeText(create_account.this, "Error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else {
                    passupc.setError("The password is different");
                    passupc.setHintTextColor(getResources().getColor(R.color.red));
                    v.vibrate(400);

                }


            }
        });

    }
}