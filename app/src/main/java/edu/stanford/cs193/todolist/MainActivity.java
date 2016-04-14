package edu.stanford.cs193.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> thingstodo;
    private ArrayAdapter<String> adapter;
    private ListView listview;
    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thingstodo = new ArrayList<String>();
        text = (EditText)findViewById(R.id.entertodo);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, thingstodo);
        listview = (ListView) findViewById(R.id.ListView01);
        if(listview != null)listview.setAdapter(adapter);
        removething();
    }
    public void removething(){
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                thingstodo.remove(position);
                update();
                removething();
            }
        });
    }

    public void update(){
        adapter.notifyDataSetChanged();
    }

    public void addthing(View view) {
        String temp = text.getText().toString();
        thingstodo.add(0,temp);
        text.setText("");
        update();
    }
}
