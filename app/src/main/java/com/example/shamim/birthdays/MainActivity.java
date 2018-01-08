package com.example.shamim.birthdays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    EditText e1,e2;
    Button b,b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = (EditText) findViewById(R.id.name);
        e2 = (EditText) findViewById(R.id.bday);

        b = (Button) findViewById(R.id.save);
        b1 = (Button) findViewById(R.id.savebday);

        ///git

        final MyDBFunctions mf = new MyDBFunctions(getApplicationContext());

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String _name = e1.getText().toString();
                String _bday = e2.getText().toString();

                DateTemp dt = new DateTemp(_name,_bday);

                mf.addingDataToTable(dt);

                Toast.makeText(getApplicationContext(),"Data Added Successfully !", Toast.LENGTH_SHORT).show();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,BirthdayOfFriends.class);
                startActivity(i);
            }
        });

    }

}
