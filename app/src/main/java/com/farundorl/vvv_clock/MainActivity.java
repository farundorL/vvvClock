package com.farundorl.vvv_clock;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	VvvAlarmManager manager;
	boolean isAlarm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		manager = new VvvAlarmManager(this);
		
		refreshButton();
        setOnClickMenuLabel();
		}
	
	private void refreshButton(){
		isAlarm = manager.isSet();
		
		Button button = (Button)findViewById(R.id.vvvButton);
		CharSequence text;
		android.view.View.OnClickListener listener;
		if(isAlarm){
			text = getString(R.string.start_status);
			listener = stopAlarm; 
		}else{
			text = getString(R.string.stop_status);
			listener = startAlarm;
		}
		
		button.setText(text);
		button.setOnClickListener(listener);
		button.setVisibility(Button.VISIBLE);
	}
	
	private android.view.View.OnClickListener startAlarm = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			manager.add();
			refreshButton();
		}
	};
	private android.view.View.OnClickListener stopAlarm = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			manager.stop();
			refreshButton();
		}
	};
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_MENU){
			startSettingActivity();
		}
		return super.onKeyDown(keyCode, event);
	};


    private void setOnClickMenuLabel(){
        TextView text = (TextView)findViewById(R.id.menu_label);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSettingActivity();
            }
        });
    }

    private void startSettingActivity() {
        Intent intent = new Intent(MainActivity.this, SettingActivity.class);
        intent.setAction(Intent.ACTION_VIEW);
        startActivity(intent);
    }
	
}
