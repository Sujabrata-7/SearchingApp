package com.example.android.musicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class MusicActivity extends AppCompatActivity {
    Toolbar mTopToolbar;
    SongAdapter songAdapter;
    TextView mEmptyView;
    EditText editsearch;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

       /* mTopToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mTopToolbar);*/

        /* mEmptyView = (TextView) findViewById(R.id.emptyView);*/

        ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Tum Mile"));
        songs.add(new Song("Tera Hone Laga Hoon"));
        songs.add(new Song("Saree Ke Falsa"));
        songs.add(new Song("Main Tera Boyfriend"));
        songs.add(new Song("Tum Hi Ho"));
        songs.add(new Song("Desi Boyz"));
        songs.add(new Song("Twist"));
        songs.add(new Song("Bum Bum bole"));

        songAdapter = new SongAdapter(this, songs);

        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(songAdapter);
        // Locate the EditText in listview_main.xml
        editsearch = (EditText) findViewById(R.id.search);

        // Capture Text in EditText
        editsearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
                songAdapter.filter(text);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
                // TODO Auto-generated method stub
            }
        });

        /* listView.setEmptyView(mEmptyView);*/
      /*  editsearch = (SearchView) findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);*/
    }
  /*  @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        songAdapter.filter(text);
        return false;
    }*/

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        MenuItem mSearch = menu.findItem(R.id.action_search);
        final SearchView mSearchView = (SearchView) mSearch.getActionView();
        mSearchView.setQueryHint("Search");


        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                String text = newText;
                songAdapter.filter(text);
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }*/
}
