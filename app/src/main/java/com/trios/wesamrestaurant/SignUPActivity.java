package com.trios.wesamrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUPActivity extends AppCompatActivity {
    EditText signupName, signupEmail, signupUsername,signupPassword;
    TextView loginRedirectText;
    Button signupButton;
    FirebaseDatabase database;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.activity_sign_upactivity);
        signupName =findViewById(R.id.signup_name);
        signupEmail =findViewById(R.id.signup_email);
        signupUsername =findViewById(R.id.signup_username);
        signupPassword =findViewById(R.id.signup_password);
        signupButton = findViewById(R.id.signup_button);
        loginRedirectText=findViewById(R.id.loginRedirectText);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");

                String name = signupName.getText().toString();
                String email = signupEmail.getText().toString();
                String username = signupUsername.getText().toString();
                String password = signupPassword.getText().toString();

                HelperClass helperClass = new HelperClass(name, email, username,password);
                reference.child(name).setValue(helperClass);

                Toast.makeText(SignUPActivity.this,"You have signup successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignUPActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUPActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    };

}