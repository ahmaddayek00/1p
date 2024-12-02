package com.example.motivationapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView quoteTextView;
    private Button saveButton, viewFavoritesButton;
    private String currentQuote;

    // List of motivational quotes
    private ArrayList<String> quotes = new ArrayList<>(Arrays.asList(
            "Believe in yourself and all that you are.",
            "The only way to do great work is to love what you do.",
            "Success is not the key to happiness. Happiness is the key to success.",
            "Your limitation—it’s only your imagination.",
            "Push yourself, because no one else is going to do it for you.",
            "Great things never come from comfort zones.",
            "Dream it. Wish it. Do it.",
            "Stay positive, work hard, make it happen."
    ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quoteTextView = findViewById(R.id.quoteTextView);
        saveButton = findViewById(R.id.saveButton);
        viewFavoritesButton = findViewById(R.id.viewFavoritesButton);

        // Display a random quote
        displayRandomQuote();

        // Save the current quote to favorites
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveQuoteToFavorites(currentQuote);
            }
        });

        viewFavoritesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FavoritesActivity.class);
                startActivity(intent);
            }
        });
    }

    private void displayRandomQuote() {
        Random random = new Random();
        currentQuote = quotes.get(random.nextInt(quotes.size()));
        quoteTextView.setText(currentQuote);
    }

    private void saveQuoteToFavorites(String quote) {
        SharedPreferences sharedPreferences = getSharedPreferences("Favorites", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();


        String favorites = sharedPreferences.getString("quotes", "");
        if (!favorites.contains(quote)) {
            favorites += quote + ";";
            editor.putString("quotes", favorites);
            editor.apply();
            Toast.makeText(this, "Quote saved to favorites!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Quote is already in favorites!", Toast.LENGTH_SHORT).show();
        }
    }
}