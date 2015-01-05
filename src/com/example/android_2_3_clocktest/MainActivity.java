package com.example.android_2_3_clocktest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Chronometer.OnChronometerTickListener;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//获取计时器组件
		final Chronometer ch =(Chronometer)findViewById(R.id.test);
	    //获取开始按钮
		Button start= (Button)findViewById(R.id.start);
		
		start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//设置开始计时时间
				ch.setBase(SystemClock.elapsedRealtime());
				//启动计时器
				ch.start();
			}
			
		});
		
		ch.setOnChronometerTickListener(new OnChronometerTickListener() {
			
			@Override
			public void onChronometerTick(Chronometer chronometer) {
                //如果从开始计时到现在超过了20s
				if(SystemClock.elapsedRealtime() - ch.getBase() > 20 * 1000)
				{
					ch.stop();
				}
			}
			
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
