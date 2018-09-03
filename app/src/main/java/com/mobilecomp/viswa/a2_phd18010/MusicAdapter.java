package com.mobilecomp.viswa.a2_phd18010;

import android.content.Context;
import android.media.AudioManager;
import android.media.Image;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.mobilecomp.viswa.a2_phd18010.Music;
import com.mobilecomp.viswa.a2_phd18010.R;

import java.util.ArrayList;

public class MusicAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Music> musicList;
    private MediaPlayer mediaPlayer;
    private Boolean flag = true;

    public MusicAdapter(Context context, int layout, ArrayList<Music> musicList) {
        this.context = context;
        this.layout = layout;
        this.musicList = musicList;
    }

    @Override
    public int getCount() {
        return musicList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public class  ViewHolder{
        TextView txtName,txtSinger;
        ImageView ivPlay,ivStop;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        if(view==null){
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(layout,null);
            viewHolder.txtName = (TextView) view.findViewById(R.id.txtName);
            viewHolder.txtSinger = (TextView) view.findViewById(R.id.txtSinger);
            viewHolder.ivPlay = (ImageView) view.findViewById(R.id.ivPlay);
            viewHolder.ivStop = (ImageView) view.findViewById(R.id.ivStop);

            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();
        }
        final Music music = musicList.get(i);

        viewHolder.txtName.setText(music.getTitle());
        viewHolder.txtSinger.setText(music.getSinger());

        viewHolder.ivPlay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(flag) {
                    mediaPlayer = MediaPlayer.create(context, music.getSong());
                    flag = false;
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    viewHolder.ivPlay.setImageResource(R.drawable.play);
                }else{
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            if (mp == mediaPlayer) {
                                mediaPlayer.start();
                                viewHolder.ivPlay.setImageResource(R.drawable.pause);
                            }
                        }
                    });
                }

                //mediaPlayer.start();


                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });



            }
        });

        viewHolder.ivStop.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View view) {
                                                     if(!flag){
                                                         mediaPlayer.stop();
                                                         mediaPlayer.release();
                                                         flag = true;
                                                     }
                                                     viewHolder.ivPlay.setImageResource(R.drawable.play);
                                                 }
                                             }


        );
        return view;
    }
}
