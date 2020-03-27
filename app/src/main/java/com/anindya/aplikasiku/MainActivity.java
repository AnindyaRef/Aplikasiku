package com.anindya.aplikasiku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String PREFERENCES_KEY = "preferences";
    public static final String USERNAME_KEY = "username";
    public static final String PASSWORD_KEY = "password";
    public static final String LOGIN_KEY = "login";

    private EditText usernameInput;
    private EditText passwordInput;
    private Button button_login;
    private TextView text_signup;
    private String user;
    private String pass;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = getSharedPreferences(PREFERENCES_KEY, Context.MODE_PRIVATE);
        if (preferences.contains(LOGIN_KEY)){
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }else {
            usernameInput = findViewById(R.id.user_input);
            passwordInput = findViewById(R.id.pass_input);
            button_login = findViewById(R.id.button_login);
            text_signup = findViewById(R.id.text_signup);
            button_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (validation()){
                        if (preferences.contains(USERNAME_KEY) && preferences.contains(PASSWORD_KEY)){
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString(LOGIN_KEY, "skip");
                            editor.apply();
                            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                            startActivity(intent);
                            finish();
                        }else  {
                            Toast.makeText(getApplicationContext(), "Please SignUp first!", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(getApplicationContext(), "Please make account first", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            text_signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, SignUp2Activity.class);
                    startActivity(intent);
                }
            });
        }
    }
    private boolean validation(){
        user = usernameInput.getText().toString().trim();
        pass = passwordInput.getText().toString().trim();
        return  !(user.isEmpty() || pass.isEmpty());
    }
}
