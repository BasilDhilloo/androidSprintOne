package com.example.covidwatch.AdminView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covidwatch.AdminView.CreateUser.AddRecordActivity;
import com.example.covidwatch.MainActivity;
import com.example.covidwatch.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;


public class AdminDashboard extends AppCompatActivity {
    private MaterialCardView tv;
    TextView edttitle;

    FirebaseFirestore db ;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        fAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();


        tv = (MaterialCardView) this.findViewById(R.id.newRecord);
        // Method for admin dashboard
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDashboardAct();
            }
        });

        // Greeting Message
        TextView greetings =findViewById(R.id.title);
        db.collection("users").document(fAuth.getCurrentUser().getUid()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                String fName = documentSnapshot.getString("First Name");
                String lname = documentSnapshot.getString("Last Name");

                // Greeting Message
                Calendar calendar = Calendar.getInstance();
                long hour = Long.parseLong(String.valueOf(calendar.get(Calendar.HOUR)));

                Toast.makeText(AdminDashboard.this,String.valueOf(hour),Toast.LENGTH_SHORT).show();
                String greetingMsg ;
                if( hour >= 5 && hour < 12) {
                    greetingMsg   = "Good Morning";
                }else if (hour >=12 && hour < 17) {
                    greetingMsg = "Good Afternoon";
                }else{
                    greetingMsg = "Good Evening";
                }


                greetings.setText( greetingMsg + " "  +fName + " " + lname + "!");

            }
        });







    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.layouts, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.personalInfo:
                Intent intent1 = new Intent(this, PersonalInfoActivity.class);
                startActivity(intent1);

                return true;
            case R.id.logOut:

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void openDashboardAct(){
        Intent intent = new Intent(this, AddRecordActivity.class);
        startActivity(intent);
    }

    public void btn_viewRecord(View v){
        Intent intent = new Intent(this, ViewRecordActivity.class);
        startActivity(intent);
    }
    public void btn_resolvedCase(View v){
        Intent intent = new Intent(this, ResourceRequestCaseActivity.class);
        startActivity(intent);
    }
    public void btn_escalatedCase(View v){
        Intent intent = new Intent(this, EscalatedCaseActivity.class);
        startActivity(intent);
    }


}