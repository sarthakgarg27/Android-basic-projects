package com.example.cameratest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
private static final int camera_request_code=1;
ImageView iv;
Bitmap image;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv=(ImageView) findViewById(R.id.image1);
	}

	public void opencamera(View v)
	{
		Intent cameraintent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(cameraintent,camera_request_code);
	}
	@Override
		protected void onActivityResult(int requestCode, int resultCode, Intent data) {
			// TODO Auto-generated method stub
			super.onActivityResult(requestCode, resultCode, data);
			if(requestCode==camera_request_code)
			{
				if(resultCode==RESULT_OK)
				{
					Bundle b=data.getExtras();
					Object o=b.get("data");
					image=(Bitmap) o;
					iv.setImageBitmap(image);
				}
			}
		}

	public void saveimage(View v) throws Exception 
	{
		File sdcard=Environment.getExternalStorageDirectory();
		File folder=new File(sdcard+"/myimage/");
		folder.mkdirs();
		Random r=new Random();
		int n=r.nextInt(20);
		File img=new File(folder,"image"+n+".jpg");
		FileOutputStream fout=new FileOutputStream(img);
		image.compress(CompressFormat.JPEG,100,fout);
		Toast.makeText(this,"image captured",Toast.LENGTH_LONG).show();
	}
	public void setwall(View v) throws IOException {
		WallpaperManager wp=(WallpaperManager) getSystemService(WALLPAPER_SERVICE);
		wp.setBitmap(image);
		Toast.makeText(this,"wallpaper changed",Toast.LENGTH_LONG).show();
		
	}
}
