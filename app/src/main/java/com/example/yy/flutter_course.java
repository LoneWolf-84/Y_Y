package com.example.yy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.snackbar.SnackbarContentLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class flutter_course extends AppCompatActivity {
    ListView list;
    String basic[];
    int images[] = {R.drawable.flutter_dart, R.drawable.flutter_dart, R.drawable.full_stack, R.drawable.cybersecurity};
    FloatingActionButton btnback;
    TextView name_flutter;
    TextView points;
    DatabaseReference reference;
    int value = 0;
    RatingBar rate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flutter_course);

        list = findViewById(R.id.list_flutter);
        basic = getResources().getStringArray(R.array.basic_flutter);
        rate = findViewById(R.id.ratingBar);
        list.setAdapter(new customlist(flutter_course.this, basic, images));
        name_flutter = findViewById(R.id.txtname_flutter);
        btnback = findViewById(R.id.btn_back_flutter);
        points = findViewById(R.id.txtpoint_flutter);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        FirebaseAuth auth = FirebaseAuth.getInstance();


        database.getReference().child(auth.getUid()).child("name").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                name_flutter.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(flutter_course.this, DashBoard.class);
                startActivity(i);

            }

        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    int press = 0;
                    if ( Integer.parseInt(points.getText().toString())>=10 &&  press==0){
                        Intent ii= new Intent(flutter_course.this, webviewF1.class);
                        startActivity(ii);
                    }
                    else {
                        reference = database.getReference().child(auth.getUid()).child("Courses").child("Flutter").child("Course 1");
                        reference.setValue("Completed");
                        reference = database.getReference().child(auth.getUid()).child("points").child("point Flutter");
                        value = 10;
                        reference.setValue(value);
                        finish();
                        startActivity(getIntent());
                        Intent i = new Intent(flutter_course.this, webviewF1.class);
                        startActivity(i);
                    }
                }



                if (position == 1) {
                    int press = 0;
                    if (Integer.parseInt(points.getText().toString()) >= 10 ) {
                        reference = database.getReference().child(auth.getUid()).child("Courses").child("Flutter").child("Course 2");
                        reference.setValue("Completed");
                        value = 20;
                        reference = database.getReference().child(auth.getUid()).child("points").child("point Flutter");
                        reference.setValue(value);
                        finish();
                        startActivity(getIntent());
                        Intent i = new Intent(flutter_course.this, webviewF1.class);
                        startActivity(i);


                    }
                     if(Integer.parseInt(points.getText().toString())>=20 && press==0){
                         reference = database.getReference().child(auth.getUid()).child("points").child("point Flutter");
                         reference.setValue(Integer.parseInt(points.getText().toString()));
                        Intent i = new Intent(flutter_course.this, webviewF1.class);
                        startActivity(i);


                    }
                    else {
                        Snackbar mySnackbar = Snackbar.make(findViewById(R.id.cc),
                                "Please Finish The Previous Course First", Snackbar.LENGTH_SHORT);
                        mySnackbar.show();

                    }
                }

                if (position == 2) {
                    int press = 0;
                    if (Integer.parseInt(points.getText().toString()) >= 20 ) {
                        reference = database.getReference().child(auth.getUid()).child("Courses").child("Flutter").child("Course 3");
                        reference.setValue("Completed");
                        value = 30;
                        reference = database.getReference().child(auth.getUid()).child("points").child("point Flutter");
                        reference.setValue(value);
                        finish();
                        startActivity(getIntent());
                        Intent i = new Intent(flutter_course.this, webviewF1.class);
                        startActivity(i);
                    }
                    if(Integer.parseInt(points.getText().toString())>=30 && press==0){
                        Intent i = new Intent(flutter_course.this, webviewF1.class);
                        reference = database.getReference().child(auth.getUid()).child("points").child("point Flutter");
                        reference.setValue(Integer.parseInt(points.getText().toString()));
                        startActivity(i);


                    }
                    else {
                        Snackbar mySnackbar = Snackbar.make(findViewById(R.id.cc),
                                "Please Finish The Previous Course First", Snackbar.LENGTH_SHORT);
                        mySnackbar.show();

                    }
                }
                if (position == 3) {
                    int press = 0;
                    if (Integer.parseInt(points.getText().toString()) >= 30 ) {
                        reference = database.getReference().child(auth.getUid()).child("Courses").child("Flutter").child("Course 4");
                        reference.setValue("Completed");
                        value = 40;
                        reference = database.getReference().child(auth.getUid()).child("points").child("point Flutter");
                        reference.setValue(value);
                        finish();
                        startActivity(getIntent());
                        Intent i = new Intent(flutter_course.this, webviewF1.class);
                        startActivity(i);
                    }
                    if(Integer.parseInt(points.getText().toString())>=40 && press==0){
                        reference = database.getReference().child(auth.getUid()).child("points").child("point Flutter");
                        reference.setValue(Integer.parseInt(points.getText().toString()));
                        Intent i = new Intent(flutter_course.this, webviewF1.class);
                        startActivity(i);


                    }
                    else {
                        Snackbar mySnackbar = Snackbar.make(findViewById(R.id.cc),
                                "Please Finish The Previous Course First", Snackbar.LENGTH_SHORT);
                        mySnackbar.show();

                    }
                }
            }
        });
        database.getReference().child(auth.getUid()).child("points").child("point Flutter").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                points.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

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
            v = inflater.inflate(R.layout.layout_list_flutter, null);

            TextView basic_flutter = v.findViewById(R.id.basic_flutter);
            ImageView img_flutter = v.findViewById(R.id.img_course_flutter);

            basic_flutter.setText(b[position]);
            img_flutter.setImageResource(img[position]);

            return v;
        }
    }
}