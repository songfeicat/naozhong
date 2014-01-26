package com.example.wheeldemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class BackDeal extends Service {
	private MediaPlayer mp = null;
	@Override  
    public void onCreate() {  
		try{
			mp=new MediaPlayer();
			mp=MediaPlayer.create(this, R.raw.girl);
		}catch(IllegalStateException e){
			e.printStackTrace();
		}
		super.onCreate();
	}
	
	@Override
	public void onStart(Intent intent,int startId){
	    mp.start();
	    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub
				//do something when music is end
			}
		});
	}
	
	@Override
	public void onDestroy(){
		mp.stop();
		mp.release();
		super.onDestroy();
	}
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
