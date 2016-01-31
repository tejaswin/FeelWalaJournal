package com.gumber.feelwalajournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gumber.feelwalajournal.data.MyDB;

public class AddEntry extends AppCompatActivity {
    private EditText titleEdit, contentEdit;
    private Button submitButton;
    private MyDB myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);
        titleEdit = (EditText) findViewById(R.id.title_edit);
        contentEdit = (EditText) findViewById(R.id.description_edit);
        submitButton = (Button) findViewById(R.id.submit_button);
        myDB = new MyDB(this);
        myDB.open();
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToDB();
            }
        });
    }

    private void saveToDB() {
        String title = titleEdit.getText().toString();
        String description = contentEdit.getText().toString();
        long date = System.currentTimeMillis();
        myDB.insertEntry(title, description, date);
        myDB.close();
        titleEdit.setText("");
        contentEdit.setText("");
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

    }
}
