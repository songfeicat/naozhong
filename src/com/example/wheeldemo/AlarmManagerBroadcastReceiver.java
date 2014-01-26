package com.example.wheeldemo;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.SystemClock;
import android.widget.TextView;
import android.widget.Toast;

public class AlarmManagerBroadcastReceiver extends BroadcastReceiver {
	final public static String ONE_TIME = "onetime";
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
      PowerManager pm=(PowerManager)context.getSystemService(Context.POWER_SERVICE);
      PowerManager.WakeLock wl=pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "YOUR TAG");
      wl.acquire();
      
      Bundle extras=intent.getExtras();
      StringBuilder msgStr=new StringBuilder();
      if(extras!=null&&extras.getBoolean(ONE_TIME,Boolean.FALSE)){
    	  msgStr.append("One time Timer:");
      }
      Format formatter=new SimpleDateFormat("hh:mm:ss a");
      msgStr.append(formatter.format(new Date()));
      Toast.makeText(context, msgStr, Toast.LENGTH_LONG).show();
      
      Intent i = new Intent(context, BackDeal.class); 
      context.startService(i);
      wl.release();
}

public void SetAlarm(Context context,int str){
	System.out.println("str="+str);
	AlarmManager am=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
	Intent intent=new Intent(context,AlarmManagerBroadcastReceiver.class);
    intent.putExtra(ONE_TIME, Boolean.FALSE);
    PendingIntent pi=PendingIntent.getBroadcast(context, 0, intent, 0);
    am.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime()+str*1000, pi);
 }
  public void CancelAlarm(Context context){
	  Intent intent=new Intent(context,AlarmManagerBroadcastReceiver.class);
	  PendingIntent sender=PendingIntent.getBroadcast(context, 0, intent, 0);
	  AlarmManager alarmManager=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
	  alarmManager.cancel(sender);
  }
  public void setOnetimeTimer(Context context){
	  AlarmManager am=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
	  Intent intent=new Intent(context,AlarmManagerBroadcastReceiver.class);
	  intent.putExtra(ONE_TIME, Boolean.TRUE);
	  PendingIntent pi=PendingIntent.getBroadcast(context, 0, intent, 0);
	  am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), pi);
  }
}

