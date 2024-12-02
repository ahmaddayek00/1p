package com.example.motivationapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class FavoritesActivity extends AppCompatActivity {

    private ListView favoritesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        favoritesListView = findViewById(R.id.favoritesListView);


        loadFavoriteQuotes();
    }

    private void loadFavoriteQuotes() {
        SharedPreferences sharedPreferences = getSharedPreferences("Favorites", MODE_PRIVATE);
        String favorites = sharedPreferences.getString("quotes", "");

        if (!favorites.isEmpty()) {
            String[] quotesArray = favorites.split(";");
            ArrayList<String> quotesList = new ArrayList<>(Arrays.asList(quotesArray));

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, quotesList);
            favoritesListView.setAdapter(adapter);
        }
    }
}