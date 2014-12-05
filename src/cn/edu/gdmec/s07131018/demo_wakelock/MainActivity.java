package cn.edu.gdmec.s07131018.demo_wakelock;

import java.net.ContentHandler;

import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;

public class MainActivity extends Activity {
	private WakeLock lock;
	private PowerManager powerManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
		lock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK, "lock");
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if(lock!=null){
			lock.acquire();
		}
	}

	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		if(lock!=null&&lock.isHeld()){
			lock.release();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
