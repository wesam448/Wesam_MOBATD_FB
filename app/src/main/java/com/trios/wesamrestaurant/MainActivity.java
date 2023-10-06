package com.trios.wesamrestaurant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerlayout= findViewById(R.id.drawer_layout);
        //NavigationView navigationView= findViewById(R.id.nav_view);
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        NavigationView navigationView= findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawerlayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerlayout.addDrawerListener(toggle);
        toggle.syncState();
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);

        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Log.d("testing", "start");
        int menuId = item.getItemId();
        if (menuId == R.id.nav_home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();
        } else if (menuId == R.id.nav_about) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new InfoFragment()).commit();
        } else if (menuId == R.id.nav_email) {
            String email = "contact@wesamRestaurant.com";
                    String subject = "Hello";
                    String body = "    ";
                    String chooserTitle = "Contact us  ";
            Uri uri = Uri.parse("mailto:" + email)
                    .buildUpon()
                    .appendQueryParameter("subject", subject)
                    .appendQueryParameter("body", body)
                    .build();

            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, uri);
            startActivity(Intent.createChooser(emailIntent, chooserTitle));
//            Intent i = new Intent(MainActivity.this,EmailActivity.class);
//            startActivity(i);
            //getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new EmailFragment()).commit();
        } else if (menuId == R.id.nav_login) {
            Intent i = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(i);
        } else if (menuId == R.id.nav_phone) {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + "123456789"));
            startActivity(intent);
            //getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new PhoneFragment()).commit();
        } else if (menuId == R.id.nav_logout) {
            Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
        }
        drawerlayout.closeDrawer(GravityCompat.START);
        return true;
    }

   @Override
    public void onBackPressed(){
        if(drawerlayout.isDrawerOpen(GravityCompat.START)){
            drawerlayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
   }
}