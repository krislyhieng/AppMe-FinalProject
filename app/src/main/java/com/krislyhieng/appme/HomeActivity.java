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
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView profileImage;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        profileImage = findViewById(R.id.profile_image);
        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ProfileDetailActivity.class);
                startActivity(intent);
            }
        });

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set click listeners for CardViews
        setCardViewClickListener(R.id.card_view1, "John Doe", "Software Engineer", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        setCardViewClickListener(R.id.card_view2, "Jane Smith", "UX Designer", "Integer tincidunt tortor eget urna porttitor, quis suscipit mi maximus. Nulla facilisi.");
        setCardViewClickListener(R.id.card_view3, "Michael Brown", "Product Manager", "Sed at urna eu lorem venenatis pulvinar. In vestibulum tincidunt libero, id vestibulum enim posuere non.");
        setCardViewClickListener(R.id.card_view4, "Emily Johnson", "Marketing Specialist", "Aenean vehicula magna in est laoreet, ut condimentum libero hendrerit.");
        setCardViewClickListener(R.id.card_view5, "William Taylor", "Graphic Designer", "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.");
        setCardViewClickListener(R.id.card_view6, "Sophia Anderson", "Content Writer", "Fusce ullamcorper lorem sed mauris feugiat, at posuere velit mollis.");
    }

    private void setCardViewClickListener(int cardViewId, final String name, final String title, final String message) {
        CardView cardView = findViewById(cardViewId);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, DetailActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("title", title);
                intent.putExtra("message", message);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_more) {
            Toast.makeText(this, "Clicked on More", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
