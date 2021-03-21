package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {

    public static final String TAG = "SignUpActivity";

    private EditText etUsernameSignUp;
    private EditText etPasswordSignUp;
    private EditText etEmail;
    private EditText etPhoneNumber;
    private Button btnSignUpMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etUsernameSignUp = findViewById(R.id.etUsernameSignUp);
        etPasswordSignUp = findViewById(R.id.etPasswordSignUp);
        etEmail = findViewById(R.id.etEmail);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        btnSignUpMain = findViewById(R.id.btnSignUpMain);

        btnSignUpMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick SignUp button");
                String username = etUsernameSignUp.getText().toString();
                String password = etPasswordSignUp.getText().toString();
                String email = etEmail.getText().toString();
                String phone = etPhoneNumber.getText().toString();
                signUpUser(username, password, email, phone);
                goLoginActivity();
            }
        });
    }

    private void goLoginActivity() {
        Intent login = new Intent(this, LoginActivity.class);
        startActivity(login);
        finish();
    }

    private void signUpUser(String username, String password, String email, String phone) {
        ParseUser user = new ParseUser();
// Set core properties
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.put("phone", phone);
// Invoke signUpInBackground
        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    Toast.makeText(SignUpActivity.this, "You can login now!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SignUpActivity.this, "Sorry, we couldn't sign you up.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}