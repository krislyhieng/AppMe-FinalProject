package com.krislyhieng.appme;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

public class ProfileDetailActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView profileImage;
    private CardView logoutCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_detail);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        profileImage = findViewById(R.id.profile_image_detail);
        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileDetailActivity.this, ProfileDetailActivity.class);
                startActivity(intent);
            }
        });

        logoutCard = findViewById(R.id.card_logout);
        logoutCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle logout action here
                Toast.makeText(ProfileDetailActivity.this, "Logging out...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ProfileDetailActivity.this, LoginActivity.class);
                startActivity(intent);
                finish(); // Optional: Close current activity
            }
        });
    }

    // Inflate the menu; this adds items to the action bar if it is present.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    // Handle action bar item clicks here.
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_more) {
            // Handle click on the "More" menu item
            Toast.makeText(this, "Clicked on More", Toast.LENGTH_SHORT).show();
            // Add your logic here to show additional options or perform an action
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
