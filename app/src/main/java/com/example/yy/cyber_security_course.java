package com.example.yy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class cyber_security_course extends AppCompatActivity {
    ListView list;
    String basic[];
    int images[] = {R.drawable.flutter_dart,
            R.drawable.flutter_dart,
            R.drawable.full_stack,
            R.drawable.cybersecurity};

    FloatingActionButton btnback;
    TextView name_security;
    TextView points;
    DatabaseReference reference;
    int value = 0;
    RatingBar rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cyber_security_course);
        btnback = findViewById(R.id.btn_back_security);
        list = findViewById(R.id.list_security);
        basic = getResources().getStringArray(R.array.basic_security);
        list.setAdapter(new cyber_security_course.customlist(cyber_security_course.this, basic, images));
        name_security = findViewById(R.id.txtname_security);
        points = findViewById(R.id.txtpoint_security);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        FirebaseAuth auth = FirebaseAuth.getInstance();


        database.getReference().child(auth.getUid()).child("name").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                name_security.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    int press = 0;
                    if ( Integer.parseInt(points.getText().toString())>=10 &&  press==0){
                        Intent ii= new Intent(cyber_security_course.this, webviewF1.class);
                        startActivity(ii);
                    }
                    else {
                        reference = database.getReference().child(auth.getUid()).child("Courses").child("Cyber Security").child("Course 1");
                        reference.setValue("Completed");
                        reference = database.getReference().child(auth.getUid()).child("points").child("point Security");
                        value = 10;
                        reference.setValue(value);
                        finish();
                        startActivity(getIntent());
                        Intent i = new Intent(cyber_security_course.this, webviewF1.class);
                        startActivity(i);
                    }
                }



                if (position == 1) {
                    int press = 0;
                    if (Integer.parseInt(points.getText().toString()) >= 10 ) {
                        reference = database.getReference().child(auth.getUid()).child("Courses").child("Cyber Security").child("Course 2");
                        reference.setValue("Completed");
                        value = 20;
                        reference = database.getReference().child(auth.getUid()).child("points").child("point Security");
                        reference.setValue(value);
                        finish();
                        startActivity(getIntent());
                        Intent i = new Intent(cyber_security_course.this, webviewF1.class);
                        startActivity(i);


                    }
                    if(Integer.parseInt(points.getText().toString())>=20 && press==0){
                        reference = database.getReference().child(auth.getUid()).child("points").child("point Security");
                        reference.setValue(Integer.parseInt(points.getText().toString()));
                        Intent i = new Intent(cyber_security_course.this, webviewF1.class);
                        startActivity(i);


                    }
                    else {
                        Snackbar mySnackbar = Snackbar.make(findViewById(R.id.cc3),
                                "Please Finish The Previous Course First", Snackbar.LENGTH_SHORT);
                        mySnackbar.show();

                    }
                }

                if (position == 2) {
                    int press = 0;
                    if (Integer.parseInt(points.getText().toString()) >= 20 ) {
                        reference = database.getReference().child(auth.getUid()).child("Courses").child("Cyber Security").child("Course 3");
                        reference.setValue("Completed");
                        value = 30;
                        reference = database.getReference().child(auth.getUid()).child("points").child("point Security");
                        reference.setValue(value);
                        finish();
                        startActivity(getIntent());
                        Intent i = new Intent(cyber_security_course.this, webviewF1.class);
                        startActivity(i);
                    }
                    if(Integer.parseInt(points.getText().toString())>=30 && press==0){
                        Intent i = new Intent(cyber_security_course.this, webviewF1.class);
                        reference = database.getReference().child(auth.getUid()).child("points").child("point Security");
                        reference.setValue(Integer.parseInt(points.getText().toString()));
                        startActivity(i);


                    }
                    else {
                        Snackbar mySnackbar = Snackbar.make(findViewById(R.id.cc3),
                                "Please Finish The Previous Course First", Snackbar.LENGTH_SHORT);
                        mySnackbar.show();

                    }
                }
                if (position == 3) {
                    int press = 0;
                    if (Integer.parseInt(points.getText().toString()) >= 30 ) {
                        reference = database.getReference().child(auth.getUid()).child("Courses").child("Cyber Security").child("Course 4");
                        reference.setValue("Completed");
                        value = 40;
                        reference = database.getReference().child(auth.getUid()).child("points").child("point Security");
                        reference.setValue(value);
                        finish();
                        startActivity(getIntent());
                        Intent i = new Intent(cyber_security_course.this, webviewF1.class);
                        startActivity(i);
                    }
                    if(Integer.parseInt(points.getText().toString())>=40 && press==0){
                        reference = database.getReference().child(auth.getUid()).child("points").child("point Security");
                        reference.setValue(Integer.parseInt(points.getText().toString()));
                        Intent i = new Intent(cyber_security_course.this, webviewF1.class);
                        startActivity(i);


                    }
                    else {
                        Snackbar mySnackbar = Snackbar.make(findViewById(R.id.cc3),
                                "Please Finish The Previous Course First", Snackbar.LENGTH_SHORT);
                        mySnackbar.show();

                    }
                }
            }
        });

        database.getReference().child(auth.getUid()).child("points").child("point Security").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                points.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(cyber_security_course.this, DashBoard.class);
                startActivity(i);
            }
        });


    }

    public class customlist extends BaseAdapter {

        Context con;
        String b[];
        int img[];


        public customlist(Context con, String[] b, int[] img) {
            this.con = con;
            this.b = b;
            this.img = img;
        }

        @Override
        public int getCount() {
            return img.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 1;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View v;
            LayoutInflater inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.layout_list_security, null);

            TextView basic_web = v.findViewById(R.id.basic_security);
            ImageView img_web = v.findViewById(R.id.img_course_security);

            basic_web.setText(b[position]);
            img_web.setImageResource(img[position]);

            return v;
        }
    }
}