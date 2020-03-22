package com.anindya.aplikasiku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import static com.anindya.aplikasiku.SignupActivity.EMAIL_KEY;
import static com.anindya.aplikasiku.SignupActivity.GEBDER_KEY;
import static com.anindya.aplikasiku.SignupActivity.NAME_KEY;
import static com.anindya.aplikasiku.SignupActivity.PHOTO_KEY;

public class ProfileActivity extends AppCompatActivity {

    private ImageView avatarImage;
    private TextView fullnameText;
    private TextView emailText;
    private TextView genderText;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        avatarImage = findViewById(R.id.photo);
        fullnameText = findViewById(R.id.fullname);
        emailText = findViewById(R.id.email);
        genderText = findViewById(R.id.gender);

        Bundle extrass = getIntent().getExtras();
        if (extrass != null){
            fullnameText.setText(extrass.getString(NAME_KEY));
            emailText.setText(extrass.getString(EMAIL_KEY));
            genderText.setText(extrass.getString(GEBDER_KEY));

            uri = Uri.parse(extrass.getString(PHOTO_KEY));
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
            } catch (IOException e){
                e.printStackTrace();
            }
            avatarImage.setImageBitmap(bitmap);
        }
    }

    public void handleHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
