package com.example.uts_pember;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;

public class DashboardActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    private void playMusic() {
        mediaPlayer = MediaPlayer.create(this, R.raw.duvet);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

    private void stopMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop(); //
            mediaPlayer.release();
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            stopMusic();
            Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopMusic();
    }
}