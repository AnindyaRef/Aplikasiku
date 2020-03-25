package com.anindya.aplikasiku;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.anindya.aplikasiku.Adapter.StuffAdapter;
import com.anindya.aplikasiku.Model.Account;
import com.anindya.aplikasiku.Model.Stuff;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class StuffActivity extends AppCompatActivity implements StuffAdapter.onItemStuffListener {

    public static final String NAMESTUFF_KEY = "namestuff";
    public static final String INDEX_KEY = "index";
    public static final int INSERT_REQUEST = 1;
    public static final int UPDATE_REQUEST = 2;

    private RecyclerView stuffView;
    private StuffAdapter adapter;
    private Account account;
    private Stuff stuff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stuff);

        stuffView = findViewById(R.id.rv_schedule);

        account = Application.getAccount();

        adapter = new StuffAdapter(account.getStuffs(), this);
        stuffView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        stuffView.setLayoutManager(layoutManager);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Tambahkan event click fab di sini
                Intent intent = new Intent(StuffActivity.this, AddActivity.class);
                intent.putExtra(NAMESTUFF_KEY, new Stuff());
                startActivityForResult(intent, INSERT_REQUEST);
            }
        });
        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int index = viewHolder.getAdapterPosition();
                account.removeStuff(index);
                adapter.notifyDataSetChanged();
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(stuffView);
    }


    @Override
    public void onStuffClicked(int index, Stuff item) {
        Intent intent = new Intent(this, AddActivity.class);
        intent.putExtra(NAMESTUFF_KEY, item);
        intent.putExtra(INDEX_KEY, index);
        startActivityForResult(intent, UPDATE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            Stuff stuff = data.getParcelableExtra(NAMESTUFF_KEY);
            if (requestCode == INSERT_REQUEST){
                account.addStuff(stuff);
            }else  if (requestCode == UPDATE_REQUEST){
                int index = data.getIntExtra(INDEX_KEY, 0);
                account.updateStuff(index, stuff);
            }
            adapter.notifyDataSetChanged();
        }
    }
}
