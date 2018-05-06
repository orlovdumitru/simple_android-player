package com.example.dima.mediaplayersoft;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.sip.SipAudioCall;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private static int volumactual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final  MediaPlayer  mediaPlayer = MediaPlayer.create(this, R.raw.song);

       final  AudioManager mgr = (AudioManager) this.getSystemService(this.AUDIO_SERVICE);
        int valuess = 9;//range(0-15)


        Button buttonPlay = (Button) findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       mediaPlayer.start();
                   }
               }
       );

        Button buttonPause = (Button) findViewById(R.id.buttonPause);
        buttonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(MainActivity.this, "Finish", Toast.LENGTH_SHORT).show();
            }
        });

        SeekBar volum = (SeekBar) findViewById(R.id.volum);
        volum.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                volumactual= progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
//                mediaPlayer.setVolume(volumactual,volumactual);
                mgr.setStreamVolume(AudioManager.STREAM_MUSIC, volumactual, 0);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                mediaPlayer.setVolume(volumactual,volumactual);
                mgr.setStreamVolume(AudioManager.STREAM_MUSIC, volumactual, 0);

            }
        });

    }
}
