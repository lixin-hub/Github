package com.mycompany.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.hardware.*;
import android.content.*;
import android.view.*;
import android.content.pm.*;

public class MainActivity extends Activity 
{
	TextView text;
	SensorManager manager;
	Sensor sensor;
	float[] event;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
	getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		setContentView(new MySurfaceView(this));
		text=findViewById(R.id.mainTextView);
		manager= (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		sensor=manager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
		
		}
	SensorEventListener events=new SensorEventListener(){

		@Override
		public void onSensorChanged(SensorEvent p1)
		{
		 event=p1.values;
//			text.setText("x"+event[0]+"\n"+
//						 "y"+event[1]+"\n"+
//			             "z"+event[2]+"\n");
				 }

		@Override
		public void onAccuracyChanged(Sensor p1, int p2)
		{
			// TODO: Implement this method
		}
	};

	@Override
	protected void onResume()
	{
		// TODO: Implement this method
		super.onResume();
		manager.registerListener(events,sensor,SensorManager.SENSOR_DELAY_NORMAL);
		
		
	}
		
		
}
