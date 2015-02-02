package com.farundorl.vvv_clock;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class VvvAlarmManager {
	Context c;
	AlarmManager manager;
	PendingIntent intent;
	
	public VvvAlarmManager(Context c){
		this.c = c;
		manager = (AlarmManager)c.getSystemService(Context.ALARM_SERVICE);
	}
	
	public void add(){
		intent = PendingIntent.getService(c, -1, new Intent(c, VvvAlarmService.class), PendingIntent.FLAG_UPDATE_CURRENT);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.add(Calendar.HOUR, 1);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.SECOND, -10);
		calendar.set(Calendar.MILLISECOND, 0);

		long span = 60 * 60 * 1000; // 1時間=60分=3600秒=ほげほげミリ秒
		manager.setRepeating(AlarmManager.RTC, calendar.getTimeInMillis(), span, intent);
	}
	
	public void stop(){
		intent = PendingIntent.getService(c, -1, new Intent(c, VvvAlarmService.class), PendingIntent.FLAG_UPDATE_CURRENT);
		manager.cancel(intent);
		intent.cancel();
	}
	
	public boolean isSet(){
		intent = PendingIntent.getService(c, -1, new Intent(c, VvvAlarmService.class), PendingIntent.FLAG_NO_CREATE);
		
		if(intent==null){return false;}
		else{return true;}
	}
}
