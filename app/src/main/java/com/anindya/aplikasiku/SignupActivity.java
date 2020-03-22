package com.anindya.aplikasiku;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class SignupActivity extends AppCompatActivity {

    private static final String TAG = SignupActivity.class.getCanonicalName();


    public static final String PHOTO_KEY = "photo";
    public static final String NAME_KEY = "name";
    public static final String EMAIL_KEY = "email";
    public static final String PASSWORD_KEY = "password";
    public static final String CONFIRMPASS_KEY ="confirmpass";
    public static final String GEBDER_KEY = "gender";

    private ImageView photoImage;
    private EditText fullnameInput;
    private EditText emailInput;
    private EditText passwordInput;
    private EditText confirmPassInput;
    private EditText genderInput;

    private Uri imageUri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        photoImage = findViewById(R.id.avatar);
        fullnameInput = findViewById(R.id.fullname);
        emailInput = findViewById(R.id.email);
        passwordInput = findViewById(R.id.password);
        confirmPassInput = findViewById(R.id.cnfirmpass);
        genderInput = findViewById(R.id.gender);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_CANCELED){
            return;
        }

        if (requestCode == 1){
            if (data != null){
                try {
                    imageUri = data.getData();
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                    photoImage.setImageBitmap(bitmap);
                }catch (IOException e){
                    Toast.makeText(this, "Input Photo fiest!", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, e.getMessage());
                }
            }
        }
    }

    public void  changePhoto(View view){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 1);
    }

    public void handleDone(View view) {
        String name = fullnameInput.getText().toString();
        String email = emailInput.getText().toString();
        String pass = passwordInput.getText().toString();
        String cpass = confirmPassInput.getText().toString();
        String gender = genderInput.getText().toString();
        Intent intent = new Intent(this, ProfileActivity.class);

        if (name.isEmpty()){
            fullnameInput.setError("Please input your name!");
        }else if (email.isEmpty()){
            emailInput.setError("Please input your va;id email!");
        } else if (pass.isEmpty()){
            passwordInput.setError("Please input password!");
        }else  if (cpass.isEmpty()){
            confirmPassInput.setError("Please confirm your password!");
        }else  if(gender.isEmpty()){
            genderInput.setError("Please input your gender");
        }else if (imageUri == null){
            Toast.makeText(this, "Input your image plaese! ", Toast.LENGTH_SHORT).show();
            changePhoto(view);
        }else {
            intent.putExtra(NAME_KEY, name);
            intent.putExtra(EMAIL_KEY, email);
            intent.putExtra(PASSWORD_KEY, pass);
            intent.putExtra(CONFIRMPASS_KEY, cpass);
            intent.putExtra(GEBDER_KEY, gender);
            intent.putExtra(PHOTO_KEY,imageUri.toString());
            startActivity(intent);
        }
    }
}
