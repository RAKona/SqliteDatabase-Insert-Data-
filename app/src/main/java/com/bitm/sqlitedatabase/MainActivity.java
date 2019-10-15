package com.bitm.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private EditText nameET,ageET;
    private Button insertBTN;
    private String name,age;

    private RecyclerView recyclerView;
    private List<User>userList;
    private UserAdapter adapter;

    private SqliteDatabaseHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();
        setData();

    }

    private void getData() {

        Cursor cursor =  helper.showData();
        while (cursor.moveToNext()){

            int Id=cursor.getInt(cursor.getColumnIndex(helper.COL_ID));
            String Name=cursor.getString(cursor.getColumnIndex(helper.COL_NAME));
            String Age=cursor.getString(cursor.getColumnIndex(helper.COL_AGE));
            userList.add(new User(Id,Name,Age));
            adapter.notifyDataSetChanged();
    }





        }


    private void setData() {

        insertBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name=nameET.getText().toString();
                age=ageET.getText().toString();


                long id=helper.insertvalues(name,age);
                Toast.makeText(MainActivity.this,"Your id "+id,Toast.LENGTH_LONG).show();
                getData();








            }
        });


    }

    private void init() {

        nameET=findViewById(R.id.nameET);
        ageET=findViewById(R.id.ageET);
        insertBTN=findViewById(R.id.insertBTN);
        helper=new SqliteDatabaseHelper(this);
        userList=new ArrayList<>();
        recyclerView=findViewById(R.id.userrecycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new UserAdapter(userList,this);
        recyclerView.setAdapter(adapter);

    }
}
