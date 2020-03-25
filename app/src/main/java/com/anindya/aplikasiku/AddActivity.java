package com.anindya.aplikasiku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.anindya.aplikasiku.Model.Stuff;

public class AddActivity extends AppCompatActivity {

    private EditText nameStuffInput;
    private Stuff item;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        nameStuffInput = findViewById(R.id.input_stuff);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            item = extras.getParcelable(StuffActivity.NAMESTUFF_KEY);
            index = extras.getInt(StuffActivity.INDEX_KEY,0);
            nameStuffInput.setText(item.getNameStuff());
        }
    }

    public void handleAdd(View view) {
        String nameStuff = nameStuffInput.getText().toString();

        item.setNameStuff(nameStuff);

        Intent intent = new Intent();
        if (nameStuff.isEmpty()){
            nameStuffInput.setError("Please input name stuff!");
        }else {
            intent.putExtra(StuffActivity.NAMESTUFF_KEY, item);
            intent.putExtra(StuffActivity.INDEX_KEY, index);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
