package com.weblance_project;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screensaver);

        Thread logoTimer = new Thread()
        {
            public void run()
            {
                try
                {
                    int logoTimer = 0;
                    while(logoTimer < 5000)
                    {
                        sleep(100);
                        logoTimer = logoTimer +100;
                    };
               startActivity(new Intent("com.weblance_project.CLEARSCREEN"));
           }
           catch (InterruptedException e)
           {
               // TODO: автоматически сгенерированный блок catch.
               e.printStackTrace();
           }
           finally
           {
               finish();
           }
           }
       };
        logoTimer.start();
   }
}