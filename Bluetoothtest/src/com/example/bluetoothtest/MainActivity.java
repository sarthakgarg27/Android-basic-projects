package com.example.bluetoothtest;

import java.util.Set;

import android.os.Bundle;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements OnCheckedChangeListener{
ToggleButton btnenable;BluetoothAdapter btadapter;
private static final int bt_enable_req_code=1,bluetooth_discover_code=2;
TextView show;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnenable=(ToggleButton) findViewById(R.id.btn_enable);
		btadapter=BluetoothAdapter.getDefaultAdapter();
		btnenable.setOnCheckedChangeListener(this);
		show=(TextView) findViewById(R.id.tv);
		IntentFilter filter=new IntentFilter(BluetoothDevice.ACTION_FOUND);
		registerReceiver(reciever, filter);
	}
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto0-generated method stub
		if(isChecked)
		{//enable bluetooth
			if(btadapter!=null)
			{
				if(!btadapter.isEnabled())
				{Toast.makeText(this,"enabling bluetooth....",Toast.LENGTH_LONG).show();
					Intent bluetoothintent=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
					startActivityForResult(bluetoothintent, bt_enable_req_code);
					Toast.makeText(this,"bluetooth enabled",Toast.LENGTH_LONG).show();
					
				}
				else
				{
					Toast.makeText(this,"bluetooth already enabled",Toast.LENGTH_LONG).show();
				}
			}
			else
			{
				Toast.makeText(this,"your device does not have bluetooth",Toast.LENGTH_LONG).show();
			}
			
			}
		else
		{//disable bluetooth
			Toast.makeText(this,"disabling.....",Toast.LENGTH_LONG).show();
			btadapter.disable();
			Toast.makeText(this,"disabled",Toast.LENGTH_LONG).show();
			
			
		}
		}
	
	
public void showinfo(View v)
{
	Toast.makeText(this,"name:"+btadapter.getName()+"address+"+btadapter.getAddress(),Toast.LENGTH_LONG).show();}
public void showpaireddevices() {
	if(btadapter.isEnabled())
	{
		Set<BluetoothDevice> list=btadapter.getBondedDevices();
		for(BluetoothDevice d :list){
			String name=d.getName();
			String address=d.getAddress();
			show.append("name:"+name+"Address:"+address+"\n");
		}
	}
	else
	{
		Toast.makeText(this,"enable bluetooth first",Toast.LENGTH_LONG).show();
	}
	
}
public void makediscoverable(View v) {
	if(btadapter.isEnabled())
	{
		Intent discover=new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
	startActivityForResult(discover,bluetooth_discover_code);
	}else
	{
		Toast.makeText(this," enable bluetooth first",Toast.LENGTH_LONG).show();
	}
	
}
public void startscan(View v) {
	if(btadapter.isEnabled())
	{
	btadapter.startDiscovery();
	}else
	{
		Toast.makeText(this," enable bluetooth first",Toast.LENGTH_LONG).show();
	}
	
}
BroadcastReceiver reciever=new BroadcastReceiver() {
	
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String action=intent.getAction();
		if(BluetoothDevice.ACTION_FOUND.equals(action))
		{
			BluetoothDevice device=intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
			String name=device.getName();
			String address=device.getAddress();
			Toast.makeText(MainActivity.this,"name:"+name+"address:"+address,Toast.LENGTH_LONG).show();
		
		}else
		{
			Toast.makeText(MainActivity.this,"no device found",Toast.LENGTH_LONG).show();
		}
		
	}
};


}
