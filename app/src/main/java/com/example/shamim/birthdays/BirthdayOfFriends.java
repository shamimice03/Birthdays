package com.example.shamim.birthdays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class BirthdayOfFriends extends AppCompatActivity {


    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday_of_friends);

        lv = (ListView) findViewById(R.id.mylistview);
        MyDBFunctions mf = new MyDBFunctions(getApplicationContext());
        String data[] = mf.my_data();

        lv.setAdapter(new ArrayAdapter(getApplicationContext(),R.layout.birthday_list_view,R.id.mytext,data));


        //Edit Text

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(getApplicationContext(),SingleBDay.class);
                i.putExtra("MyKEY",position);
                startActivity(i);
            }
        });

        ///------////




    }
}
