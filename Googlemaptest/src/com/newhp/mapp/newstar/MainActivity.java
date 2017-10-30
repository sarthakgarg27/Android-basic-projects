package com.newhp.mapp.newstar;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.location.Location;
import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
GoogleMap map;int counter;
int maptype[]={GoogleMap.MAP_TYPE_HYBRID,GoogleMap.MAP_TYPE_NORMAL,GoogleMap.MAP_TYPE_SATELLITE,GoogleMap.MAP_TYPE_NONE,GoogleMap.MAP_TYPE_TERRAIN};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		FragmentManager fm=getFragmentManager();
		Fragment f= fm.findFragmentById(R.id.map);
		MapFragment mf=(MapFragment) f;
		map=mf.getMap();
		map.setMyLocationEnabled(true);//enabling my location buttonn
		MarkerOptions option=new MarkerOptions();//adding marker to googlemap
		option.title("gip noida");
		option.position(new LatLng(54.54,84.54));
		map.addMarker(option);
		//Location myloc=map.getMyLocation();
		//double lat=myloc.getLatitude();
		//double lon=myloc.getLongitude();
		//Toast.makeText(this, "longi"+lon+"lati"+lat,Toast.LENGTH_LONG).show();
		
		
		
		
	}

	
public void changetype(View v)
{map.setMapType(maptype[counter]);
counter ++;
if(counter>4)
counter=0;
	}
}
