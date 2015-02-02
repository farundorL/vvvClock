package com.farundorl.vvv_clock;

import java.util.Calendar;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class VvvAlarmNotificationReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
		final int hour_num = 24;
		Boolean flags[] = new Boolean[hour_num]; 
		for (int i = 0; i < hour_num; i++) {
			 flags[i] = pref.getBoolean((i+1)+"ji", false);
		}

		int hour = Calendar.getInstance().get(Calendar.HOUR);
		if(flags[hour - 1]){
            int vib_time = (hour%12 == 0) ? 12 : hour%12;
			Vibrator vib = (Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
			long pattern[] = new long[vib_time*2];
			for(int i=0; i<vib_time*2; i++){ pattern[i]=150; }
			vib.vibrate(pattern, -1);
			Toast.makeText(context, hour+"時", Toast.LENGTH_LONG).show();
		}
	}
}
