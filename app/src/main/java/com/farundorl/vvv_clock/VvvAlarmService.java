package com.farundorl.vvv_clock;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class VvvAlarmService extends Service{

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public void onCreate(){
		Thread thread = new Thread(null, vvvTask, "VvvAlarmServiceThread");
		thread.start();
	}
	
	Runnable vvvTask = new Runnable() {
		@Override
		public void run() {
			Intent alarmBroadcast = new Intent();
			alarmBroadcast.setAction("VvvAlarmAction");
			sendBroadcast(alarmBroadcast);
			VvvAlarmService.this.stopSelf();
		}
	};
}