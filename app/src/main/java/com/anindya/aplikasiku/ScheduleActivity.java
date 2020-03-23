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
        schedule.add(new ScheduleModel("https://armorymn.com/wp-content/uploads/2020/01/ARMORY_MONSTAX_IG_1080x1920.jpg", "MONSTA X WORLD TOUR","Presented by: Live Nation"));
        schedule.add(new ScheduleModel("https://armorymn.com/wp-content/uploads/2020/01/ARMORY_MONSTAX_IG_1080x1920.jpg", "MONSTA X WORLD TOUR","Presented by: Live Nation"));
        schedule.add(new ScheduleModel("https://armorymn.com/wp-content/uploads/2020/01/ARMORY_MONSTAX_IG_1080x1920.jpg", "MONSTA X WORLD TOUR","Presented by: Live Nation"));
        schedule.add(new ScheduleModel("https://armorymn.com/wp-content/uploads/2020/01/ARMORY_MONSTAX_IG_1080x1920.jpg", "MONSTA X WORLD TOUR","Presented by: Live Nation"));
        schedule.add(new ScheduleModel("https://armorymn.com/wp-content/uploads/2020/01/ARMORY_MONSTAX_IG_1080x1920.jpg", "MONSTA X WORLD TOUR","Presented by: Live Nation"));
        schedule.add(new ScheduleModel("https://armorymn.com/wp-content/uploads/2020/01/ARMORY_MONSTAX_IG_1080x1920.jpg", "MONSTA X WORLD TOUR","Presented by: Live Nation"));

        ScheduleAdapter adapter = new ScheduleAdapter(this, schedule);
        scheduleView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        scheduleView.setLayoutManager(layoutManager);
    }
}
