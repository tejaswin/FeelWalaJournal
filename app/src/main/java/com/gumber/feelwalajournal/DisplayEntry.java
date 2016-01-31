package com.gumber.feelwalajournal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayEntry extends AppCompatActivity {
    private TextView fulltitle, fullcontent;

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
