package com.example.covidwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Button button;
    EditText edtUsername, edtPassword;
    boolean isAllFieldsChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        button = (Button)findViewById(R.id.btnLogin);

        // Method for opening security question page

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isAllFieldsChecked = CheckAllFields();

                if (isAllFieldsChecked) {
                    Intent i = new Intent(MainActivity.this, SecurityQuestionActivity.class);
                    startActivity(i);
                }
            }

            });
    }

    private boolean CheckAllFields() {
        if (edtUsername.length() == 0) {
            edtUsername.setError("Username should not be empty");
            return false;
        }

        if (edtPassword.length() == 0) {
            edtPassword.setError("Password should not be empty");
            return false;
        } else if (edtPassword.length() != 6) {
            edtPassword.setError("Password must be of 6 characters");
            return false;
        }

        // after all validation return true.
        return true;
    }
}
