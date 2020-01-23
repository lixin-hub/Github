package com.mycompany.myapp;
import android.view.*;
import android.view.ActionMode.*;
import android.graphics.*;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback
{
	MainActivity mainActivity;
    DrawThread drawThread;
	Paint paint;
	Canvas canvas;
	boolean flag=false;
	int sleepTime=100;
	SurfaceHolder holder;
	float center_x=1000,center_y=500,r=300;
	float m_center_x,m_center_y,m_r=100;
	//构造器
	public MySurfaceView(MainActivity mainActivity)
	{
		super(mainActivity);
		holder=this.getHolder();
		holder.addCallback(this);
		paint=new Paint();

		drawThread=new DrawThread(this);
		this.mainActivity = mainActivity;
	}

	
	public void onDraw(){
		canvas=holder.lockCanvas();
		if(canvas!=null){
			canvas.drawColor(Color.WHITE);
			paint.setStyle(Paint.Style.STROKE);
			paint.setColor(Color.BLUE);
			canvas.drawCircle(center_x,center_y,r,paint);
		    paint.setStyle(Paint.Style.FILL);
			paint.setColor(Color.GREEN);
			m_center_x=mainActivity.event[0];
			canvas.drawCircle(m_center_x,m_center_y,m_r,paint);
		holder.unlockCanvasAndPost(canvas);
	}
	
	}
	
	@Override
	public void surfaceCreated(SurfaceHolder p1)
	{
    flag=true;
	drawThread.start();
	}

	@Override
	public void surfaceChanged(SurfaceHolder p1, int p2, int p3, int p4)
	{
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder p1)
	{
		flag=false;
	}
	
}
