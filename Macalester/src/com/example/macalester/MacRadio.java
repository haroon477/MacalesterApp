package com.example.macalester;

import java.io.IOException;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;


public class MacRadio extends Activity {
	
	private ProgressBar seekBar;
	private ImageButton playButton;
	private ImageButton stopButton;
	private MediaPlayer macRadioPlayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mac_radio);
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		initializeMacRadioPlayer();
		initializeUIElements();
	}
	
	
	private void initializeUIElements() {

        seekBar = (ProgressBar) findViewById(R.id.progressBar1);
        seekBar.setMax(100);
        seekBar.setVisibility(View.INVISIBLE);

        playButton = (ImageButton) findViewById(R.id.play_button);
        playButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startPlaying();
			}
		});

        stopButton = (ImageButton) findViewById(R.id.pause_button);
        stopButton.setEnabled(false);
        stopButton.setVisibility(View.INVISIBLE);
        stopButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				stopPlaying();
			}
		});

    }
	
	private void startPlaying() {
		stopButton.setVisibility(View.VISIBLE);
        stopButton.setEnabled(true);
        playButton.setEnabled(false);
        playButton.setVisibility(View.INVISIBLE);
        
        if (seekBar.getVisibility() == View.VISIBLE) {
        	macRadioPlayer.start();
        	seekBar.setVisibility(View.INVISIBLE);
        }
        
        else {

        seekBar.setVisibility(View.VISIBLE);

        macRadioPlayer.prepareAsync();

        macRadioPlayer.setOnPreparedListener(new OnPreparedListener() {

            public void onPrepared(MediaPlayer mp) {
                macRadioPlayer.start();
                seekBar.setVisibility(View.INVISIBLE);
            }
        });
        }

    }
	
	private void stopPlaying() {
        if (seekBar.getVisibility() == View.VISIBLE) {
        	macRadioPlayer.release();
        	initializeMacRadioPlayer();
        	seekBar.setVisibility(View.INVISIBLE);
        }
        else {
            macRadioPlayer.pause();
            seekBar.setVisibility(View.VISIBLE);
        }
        playButton.setEnabled(true);
        stopButton.setEnabled(false);
        stopButton.setVisibility(View.INVISIBLE);
        playButton.setVisibility(View.VISIBLE);
    }

	private void initializeMacRadioPlayer() {
        macRadioPlayer = new MediaPlayer();
        try {
            macRadioPlayer.setDataSource("http://216.250.175.13:8000/");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	@Override
    protected void onPause() {
        super.onPause();
        if (macRadioPlayer.isPlaying()) {
            macRadioPlayer.stop();
        }
    }

}
