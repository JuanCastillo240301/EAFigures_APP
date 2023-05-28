package com.example.eafigures;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.eafigures.fragment.HomeFragment;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {
    Fragment homeFragment;
    private Toolbar mToolbar;
    private  FirebaseAuth mAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        homeFragment=new HomeFragment();
        loadFragment(homeFragment);
        mAuth=FirebaseAuth.getInstance();
//        mToolbar=findViewById(R.id.home_toolbar);
//        setSupportActionBar(mToolbar);



    }



    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.home_container,homeFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main_menu,menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if(item.getItemId()==R.id.logout_btn){
//            mAuth.signOut();
//            Intent intent=new Intent(HomeActivity.this,MainActivity.class);
//            startActivity(intent);
//            finish();
//        }
//        return true;
//    }
}


