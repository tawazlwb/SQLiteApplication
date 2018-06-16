package com.ikheiry.sqliteapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ikheiry.sqliteapplication.fragment.AddContactFragment;
import com.ikheiry.sqliteapplication.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnDbOPListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.fragment_container) != null){
            if(savedInstanceState != null){
                return;
            }

            HomeFragment homeFragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, homeFragment).commit();
        }
    }

    @Override
    public void onDbOpPerfomed(int method) {
        switch (method){
            case 0:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new AddContactFragment())
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }
}
