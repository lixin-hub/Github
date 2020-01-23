package com.mycompany.myapp;

public class DrawThread extends Thread
{
	MySurfaceView mySurfaceView;

	public DrawThread(MySurfaceView mySurfaceView)
	{
		this.mySurfaceView = mySurfaceView;
	}
	
	@Override
	public void run()
	{
     while(mySurfaceView.flag)
		 mySurfaceView.onDraw();
		try
		{
			Thread.sleep(mySurfaceView.sleepTime);
		}
		catch (InterruptedException e)
		{}
		super.run();
	}
	
	
}
