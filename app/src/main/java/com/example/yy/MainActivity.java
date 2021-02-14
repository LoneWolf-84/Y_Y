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

public class MainActivity extends AppCompatActivity {
    TextView txtsign;
    Button btnlogin;
    EditText ed;
    EditText ed2;
    TextView forget;
    String mail;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtsign = findViewById(R.id.txtsign);
        btnlogin = findViewById(R.id.btnlogin);
        ed = findViewById(R.id.in);
        ed2 = findViewById(R.id.pass);
        mAuth = FirebaseAuth.getInstance();
        forget = findViewById(R.id.forgetpassword);
        txtsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,create_account.class);
                startActivity(i);
            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                mail = ed.getText().toString().trim();
                String password = ed2.getText().toString().trim();
                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

                if (TextUtils.isEmpty(mail)) {
                    ed.setError("Enter The E-mail First");
                    ed.setHintTextColor(getResources().getColor(R.color.red));
                    v.vibrate(400);
                    return;
                    }  else if (TextUtils.isEmpty(password)) {
                    ed2.setError("Please Enter Your Password ");
                    ed2.setHintTextColor(getResources().getColor(R.color.red));
                    v.vibrate(400);
                    return;
                } else if (ed2.length() < 6) {
                    ed2.setError("must be >6");
                    v.vibrate(400);
                    return;
                }

                mAuth.signInWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(MainActivity.this, "Signed In", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(MainActivity.this,DashBoard.class);
                            startActivity(i);
                        }
                       else {
                            Toast.makeText(MainActivity.this, "Error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                    }
                });
            }
        });
            forget.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String forg = ed.getText().toString().trim();
                    mAuth.sendPasswordResetEmail(forg).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "Reset Link Successfully Sent", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }

                    });
                }
            });
    }
}