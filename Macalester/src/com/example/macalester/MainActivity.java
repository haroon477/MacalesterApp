package com.example.macalester;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.darvds.ribbonmenu.RibbonMenuView;
import com.darvds.ribbonmenu.iRibbonMenuCallback;

public class MainActivity extends Activity implements iRibbonMenuCallback {
	
	private RibbonMenuView rbmView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        rbmView = (RibbonMenuView) findViewById(R.id.ribbonMenuView1);
        rbmView.setMenuClickCallback(this);
        rbmView.setMenuItems(R.menu.activity_main);
        
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }
    
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();

		if (id == android.R.id.home) {
			
			rbmView.toggleMenu();
			
			return true;
		
		} else {
			return super.onOptionsItemSelected(item);
		}
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void macRadio(View view) {
    	Intent intent = new Intent(this, MacRadio.class);
    	startActivity(intent);
    }
    
    public void macMenu (View view) {
    	Intent intent = new Intent(this, MacMenu.class);
    	startActivity(intent);
    }
    
    public void macMap (View view) {
    	Intent intent = new Intent(this, MacMap.class);
    	startActivity(intent);
    }

	@Override
	public void RibbonMenuItemClick(int itemId) {
		if(itemId == 1) {
			Intent intent = new Intent(this, MacRadio.class);
	    	startActivity(intent);
		}
		
	}
    
}
