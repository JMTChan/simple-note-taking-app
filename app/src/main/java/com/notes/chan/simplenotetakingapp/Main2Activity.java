package com.notes.chan.simplenotetakingapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private DbHelper dbHelper = null;
    private SQLiteDatabase db = null;

    public EditText editText;
    public EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        dbHelper = new DbHelper(this);
        db = dbHelper.getWritableDatabase();

        editText = findViewById(R.id.editText);
        editText1 = findViewById(R.id.editText2);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save_note, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.save){
            long id1 = dbHelper.insertNote(db, editText.getText().toString(),editText1.getText().toString());
            Toast.makeText(this, "Note has been saved!", Toast.LENGTH_SHORT).show();
            this.finish();
        }

        return true;
    }
}
