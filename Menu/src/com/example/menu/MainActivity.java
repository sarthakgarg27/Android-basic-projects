package com.example.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity {
	RelativeLayout rl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		rl = (RelativeLayout) findViewById(R.id.R);
		rl.setOnCreateContextMenuListener(this);
	}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	// TODO Auto-generated method stub
    	
    	MenuItem item1 = menu.add(0, 0,0,"Home");
    	item1.setIcon(R.drawable.favicon);
    	
    	//Adding item to menu..

    	MenuItem item2 = menu.add(0, 1, 1, "edit");
    	item2.setIcon(R.drawable.icon);
    	//adding oitem
    	MenuItem item3 = menu.add(0, 2, 2, "delete");
    	item2.setIcon(R.drawable.page_white_tux);
    	//adding item
    	MenuItem item4 = menu.add(0, 3, 3, "Print");
    	item4.setIcon(R.drawable.titan_006);
    	
    	return super.onCreateOptionsMenu(menu);
    }
    
@Override
public boolean onContextItemSelected(MenuItem item) {
	// TODO Auto-generated method stub
	
	
	int id = item.getItemId();
	switch(id)
	{
	case 0 :
		Toast.makeText(this,"you selected"+ item.getTitle(),Toast.LENGTH_LONG).show();
		break;
	case 1 :
		Toast.makeText(this,"you selected"+ item.getTitle(),Toast.LENGTH_LONG).show();
		break;
	case 2 :
		Toast.makeText(this,"you selected"+ item.getTitle(),Toast.LENGTH_LONG).show();
		break;
	case 3 :
		Toast.makeText(this,"you selected"+ item.getTitle(),Toast.LENGTH_LONG).show();
		break;
	}
	return super.onContextItemSelected(item);
}



		@Override
		public void onCreateContextMenu(ContextMenu menu, View v,
				ContextMenuInfo menuInfo) {
			// TODO Auto-generated method stub
			//Adding item to menu..

	    	MenuItem item2 = menu.add(0, 1, 1, "edit");
	    	item2.setIcon(R.drawable.favicon);
	    	//adding oitem
	    	MenuItem item3 = menu.add(0, 2, 2, "delete");
	    	item2.setIcon(R.drawable.icon);
	    	//adding item
	    	MenuItem item4 = menu.add(0, 1, 1, "Print");
	    	item2.setIcon(R.drawable.page_white_tux);
			
			
			super.onCreateContextMenu(menu, v, menuInfo);
		}

}
