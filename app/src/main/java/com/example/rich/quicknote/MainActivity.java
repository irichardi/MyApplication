package com.example.rich.quicknote;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //database
    dbHelper myDb;
    //edits following variable
    EditText eTitle,eCategory,eDescription,eDate;
    //button
    Button btnAddNotes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new dbHelper(this);
        eTitle = (EditText)findViewById(R.id.editTextTitle);
        eCategory = (EditText)findViewById(R.id.editTextCategory);
        eDescription = (EditText)findViewById(R.id.editTextDescription);
        eDate = (EditText)findViewById(R.id.editTextDate);
        btnAddNotes = (Button)findViewById(R.id.buttonSave);
        AddData();
    }

    public  void AddData() {
        btnAddNotes.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(eTitle.getText().toString(),
                                eCategory.getText().toString(),
                                eDescription.getText().toString(),
                                eDate.getText().toString() );
                        if(isInserted =true)
                            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
