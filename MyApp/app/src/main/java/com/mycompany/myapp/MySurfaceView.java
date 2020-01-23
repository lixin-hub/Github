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
	int sleepTime=1;
	SurfaceHolder holder;
	float center_x,center_y,r=300;
    float m_center_x,m_center_y,m_r=100;

	private static final float RATE =20f;
	//构造器
	public MySurfaceView(MainActivity mainActivity)
	{
		super(mainActivity);
		holder=this.getHolder();
		holder.addCallback(this);
		paint=new Paint();
		paint.setAntiAlias(true);
	
		this.mainActivity = mainActivity;
		if(mainActivity.screenWidth/2!=0){
		center_x=mainActivity.screenWidth/2;
		center_y=mainActivity.screenHeight/2;}
		drawThread=new DrawThread(this);
		}

	
	public void onDraw(){
		canvas=holder.lockCanvas();
		if(canvas!=null){
			canvas.drawColor(Color.WHITE);
			paint.setColor(Color.BLACK);
			paint.setTextSize(40);
			canvas.drawPoint(center_x,center_y,paint);
			paint.setStyle(Paint.Style.STROKE);
			paint.setColor(Color.BLUE);
			canvas.drawCircle(center_x,center_y,r,paint);
		    paint.setStyle(Paint.Style.FILL);
			paint.setColor(Color.GREEN);
			m_center_x=mainActivity.event[0];
			m_center_y=mainActivity.event[1];
			canvas.drawText("x="+m_center_x+"   y="+m_center_y,100,100,paint);
			canvas.drawCircle(center_x+m_center_x*RATE,center_y-m_center_y*RATE,m_r,paint);
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
