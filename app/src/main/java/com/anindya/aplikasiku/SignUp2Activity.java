package com.anindya.aplikasiku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp2Activity extends AppCompatActivity {

    public static final String PREFERENCES_KEY = "preferences";
    public static final String USERNAME_KEY = "username";
    public static final String PASSWORD_KEY = "password";

    private EditText usernameInput;
    private EditText passwordInput;
    public String user;
    public String pass;
    private Button button_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);
        usernameInput = findViewById(R.id.input_username);
        passwordInput = findViewById(R.id.input_password);
        button_signup = findViewById(R.id.button_signup);
        button_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validation()){
                    SharedPreferences preferences = getSharedPreferences(PREFERENCES_KEY, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString(USERNAME_KEY, user);
                    editor.putString(PASSWORD_KEY, pass);
                    editor.apply();
                    finish();
                }
            }
        });
    }
    private boolean validation(){
        user = usernameInput.getText().toString().trim();
        pass = passwordInput.getText().toString().trim();
        return !(user.isEmpty() || pass.isEmpty());
    }
}
