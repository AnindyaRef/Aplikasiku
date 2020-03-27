package com.anindya.aplikasiku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.anindya.aplikasiku.Adapter.ScheduleAdapter;
import com.anindya.aplikasiku.Model.ScheduleModel;

import java.util.ArrayList;
import java.util.List;

public class ScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        RecyclerView scheduleView = findViewById(R.id.rv_schedule);

        List<ScheduleModel> schedule = new ArrayList<>();
        schedule.add(new ScheduleModel("https://armorymn.com/wp-content/uploads/2020/01/ARMORY_MONSTAX_IG_1080x1920.jpg",
                "MONSTA X: 2020 WORLD TOUR","02 June 2020 7:30 PM at Minneapolis Armory, Minnesota USA "));
        schedule.add(new ScheduleModel("https://armorymn.com/wp-content/uploads/2020/01/ARMORY_MONSTAX_IG_1080x1920.jpg",
                "MONSTA X: 2020 WORLD TOUR","07 June 2020 7:30 PM at Fairfax EagleBank Arena, Virginia USA"));
        schedule.add(new ScheduleModel("https://armorymn.com/wp-content/uploads/2020/01/ARMORY_MONSTAX_IG_1080x1920.jpg",
                "MONSTA X WORLD TOUR","19 June 2020 7:30 PM at Atlantic City Borgata Event Center, New Jersey USA"));
        schedule.add(new ScheduleModel("https://armorymn.com/wp-content/uploads/2020/01/ARMORY_MONSTAX_IG_1080x1920.jpg",
                "MONSTA X WORLD TOUR","29 June 2020 7:30 PM Denver Pepsi center, Colorado USA"));
        schedule.add(new ScheduleModel("https://armorymn.com/wp-content/uploads/2020/01/ARMORY_MONSTAX_IG_1080x1920.jpg",
                "MONSTA X WORLD TOUR","01 Juli 2020 6:30 PM at San JOse SAP Center"));
        schedule.add(new ScheduleModel("https://armorymn.com/wp-content/uploads/2020/01/ARMORY_MONSTAX_IG_1080x1920.jpg",
                "MONSTA X WORLD TOUR","11 Juli 2020 6:30PM at Los Angeles Forum, California USA"));

        ScheduleAdapter adapter = new ScheduleAdapter(this, schedule);
        scheduleView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        scheduleView.setLayoutManager(layoutManager);
    }
}
