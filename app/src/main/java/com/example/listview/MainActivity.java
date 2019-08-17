package com.example.listview;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity

{

    //FloatingActionButton fab;


    EditText ettxt;
    ListView lv;
    Button btnadd;
    TextView tv;

    List<String> mydata;
    ArrayAdapter<String> adapter;

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        a();

        mydata = new ArrayList<>();
        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, mydata);
        lv.setAdapter(adapter);




        //fab = (FloatingActionButton) findViewById(R.id.fab);






                btnadd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String d = ettxt.getText().toString();
                        mydata.add(d);
                        adapter.notifyDataSetChanged();
                        ettxt.setText("");

                    }
                });


                builder = new AlertDialog.Builder(this);


                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @SuppressLint("RestrictedApi")
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        String d = mydata.get(i);
                        tv.setText(d);

                        builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);

                        builder.setMessage("Are u sure want to delete?");

                        builder.setCancelable(false);

                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        deleteData();

                                        Toast.makeText(getApplicationContext(), "Your data is Deleted",
                                                Toast.LENGTH_SHORT).show();


                                    }
                                });


                        builder.setNegativeButton("No", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(), "Your Data is not Deleted",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });

                        AlertDialog alert = builder.create();
                        alert.setTitle("Alert!!!");
                        alert.show();

                        //fab.setVisibility(View.VISIBLE);


                    }
                });
            }


            @SuppressLint("RestrictedApi")
            void deleteData() {
                String d = tv.getText().toString();
                mydata.remove(d);
                adapter.notifyDataSetChanged();
                tv.setText("");
                //fab.setVisibility(View.INVISIBLE);

            }

    private void a()
    {
        ettxt = findViewById(R.id.ettxt);
        lv = findViewById(R.id.lv);
        btnadd = findViewById(R.id.btnadd);
        tv = findViewById(R.id.tv);
       // fab = findViewById(R.id.fab);
    }
}
