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
        schedule.add(new ScheduleModel("https://www.allkpop.com/upload/2018/08/af_org/25162731/monsta-x.jpg",
                "MONSTA X: 2020 WORLD TOUR","02 June 2020 7:30 PM at Minneapolis Armory, Minnesota USA "));
        schedule.add(new ScheduleModel("http://res.heraldm.com/phpwas/restmb_jhidxmake.php?idx=5&simg=201904151542363360231_20190415154528_01.jpg",
                "MONSTA X: 2020 WORLD TOUR","07 June 2020 7:30 PM at Fairfax EagleBank Arena, Virginia USA"));
        schedule.add(new ScheduleModel("http://res.heraldm.com/phpwas/restmb_jhidxmake.php?idx=5&simg=201904151542363360231_20190415154528_02.jpg",
                "MONSTA X WORLD TOUR","19 June 2020 7:30 PM at Atlantic City Borgata Event Center, New Jersey USA"));
        schedule.add(new ScheduleModel("https://www.allkpop.com/upload/2018/01/af_org/21202519/monsta-x.jpg",
                "MONSTA X WORLD TOUR","29 June 2020 7:30 PM Denver Pepsi center, Colorado USA"));
        schedule.add(new ScheduleModel("https://officiallykmusic.com/wp-content/uploads/2019/07/Monsta_X_2019_04-1000x600.jpg",
                "MONSTA X WORLD TOUR","01 Juli 2020 6:30 PM at San JOse SAP Center"));
        schedule.add(new ScheduleModel("https://miro.medium.com/max/2000/1*-xxS_bfO8EV68UqFJ_paMQ.jpeg",
                "MONSTA X WORLD TOUR","11 Juli 2020 6:30PM at Los Angeles Forum, California USA"));

        ScheduleAdapter adapter = new ScheduleAdapter(this, schedule);
        scheduleView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        scheduleView.setLayoutManager(layoutManager);
    }
}
