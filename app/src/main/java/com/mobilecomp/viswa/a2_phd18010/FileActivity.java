package com.mobilecomp.viswa.a2_phd18010;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FileActivity extends AppCompatActivity {
    /*from folder*/
    private ArrayList<Music> musicList;
    private  MusicAdapter mAdapter;
    private ListView songList;

    /***************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);



        songList = (ListView) findViewById(R.id.songList);
        musicList = new ArrayList<>();
        musicList.add(new com.mobilecomp.viswa.a2_phd18010.Music("Ajab Si","Unknown",R.raw.ajab));
        musicList.add(new com.mobilecomp.viswa.a2_phd18010.Music("Pray for","Unknown",R.raw.pray));
        musicList.add(new com.mobilecomp.viswa.a2_phd18010.Music("Yadein","Unknown",R.raw.yadein));

        mAdapter = new MusicAdapter(this,R.layout.items,musicList);
        songList.setAdapter(mAdapter);
    }
}
