package com.mobilecomp.viswa.a2_phd18010;
public class Music {
    private String title;
    private String singer;
    private int song;

    public Music(String title, String singer, int song) {
        this.title = title;
        this.singer = singer;
        this.song = song;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getSong() {
        return song;
    }

    public void setSong(int song) {
        this.song = song;
    }
}
