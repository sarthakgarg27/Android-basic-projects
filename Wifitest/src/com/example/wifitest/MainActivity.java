package com.example.wifitest;

import java.util.List;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements android.widget.CompoundButton.OnCheckedChangeListener {
ToggleButton btnenable;
WifiManager wm;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnenable=(ToggleButton) findViewById(R.id.btn_enable);
		btnenable.setOnCheckedChangeListener(this);wm=(WifiManager) getSystemService(Context.WIFI_SERVICE);
	}
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		if(isChecked)
		{
			if(!wm.isWifiEnabled())
			{//enable wifi
				Toast.makeText(this,"enabling wifi ",Toast.LENGTH_LONG).show();
				wm.setWifiEnabled(true);
				Toast.makeText(this,"enabled ",Toast.LENGTH_LONG).show();}
			else {
				Toast.makeText(this,"wifi already enabled ",Toast.LENGTH_LONG).show();
			}}
		else{Toast.makeText(this,"disabling wifi ",Toast.LENGTH_LONG).show();
			wm.setWifiEnabled(false);
			Toast.makeText(this,"disabled ",Toast.LENGTH_LONG).show();
			}
		
	}
	public void getinfo(View v)
	{
		WifiInfo info=wm.getConnectionInfo();
	String bssid=info.getBSSID();
	Toast.makeText(this, "bssid:"+bssid,Toast.LENGTH_LONG).show();
	Toast.makeText(this, "ssid:"+info.getSSID(),Toast.LENGTH_LONG).show();
	Toast.makeText(this, "ip address:"+info.getIpAddress(),Toast.LENGTH_LONG).show();
	Toast.makeText(this, "mac:"+info.getMacAddress(),Toast.LENGTH_LONG).show();
	Toast.makeText(this, "network id:"+info.getNetworkId(),Toast.LENGTH_LONG).show();
	}
	public void searchdevices()
	{
		List<ScanResult> result=wm.getScanResults();
		for(ScanResult sr: result)
		{
			Toast.makeText(this,"bssid:"+sr.BSSID,Toast.LENGTH_LONG).show();
			Toast.makeText(this,"network name:"+sr.SSID,Toast.LENGTH_LONG).show();
			Toast.makeText(this,"level:"+sr.level,Toast.LENGTH_LONG).show();
			Toast.makeText(this,"frequency:"+sr.frequency,Toast.LENGTH_LONG).show();
		
		}
	}
	public void getconfig(View v){
		List<WifiConfiguration> configs=wm.getConfiguredNetworks();
		for(WifiConfiguration sr: configs)
		{
			Toast.makeText(this,"bssid:"+sr.BSSID,Toast.LENGTH_LONG).show();
			Toast.makeText(this,"network name:"+sr.SSID,Toast.LENGTH_LONG).show();
			Toast.makeText(this,"network id:"+sr.networkId,Toast.LENGTH_LONG).show();
			Toast.makeText(this,"status:"+sr.status,Toast.LENGTH_LONG).show();
			Toast.makeText(this,"key:"+sr.preSharedKey,Toast.LENGTH_LONG).show();
		
		}
	}
	
		
	}
	
	
		





