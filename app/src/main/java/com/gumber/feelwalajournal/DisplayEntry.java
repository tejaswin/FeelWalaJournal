package com.gumber.feelwalajournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DisplayEntry extends AppCompatActivity {
    private TextView fulltitle, fullcontent;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.full_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.share){
            Intent i= new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_TEXT, "Hey, I'm sharing this from my Feel Wala Journal: " + fullcontent.getText() + "\n Download Feel Wala Journal on the Google Play Store!" );
            startActivity(i.createChooser(i,"Share via"));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_entry);
        fullcontent = (TextView) findViewById(R.id.full_content);
        fulltitle = (TextView) findViewById(R.id.full_title);
        fulltitle.setText(getIntent().getExtras().getString(Constants.TITLE));
        fullcontent.setText(getIntent().getExtras().getString(Constants.DESCRIPTION));
    }
}
