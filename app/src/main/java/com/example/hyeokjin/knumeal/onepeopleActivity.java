package com.example.hyeokjin.knumeal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;

import java.util.ArrayList;

public class onepeopleActivity extends AppCompatActivity {


    ArrayList<Restaurant> found_restaurant = new ArrayList<Restaurant>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onepeople);



        //ArrayList<Restaurant> final_restaurant = new ArrayList<Restaurant>();
        Intent i = getIntent();
        found_restaurant = i.getParcelableArrayListExtra("ToOne");
        ListView listView=(ListView)findViewById(R.id.listview);
        PeopleAdapter adapter=new PeopleAdapter();
        for(int j=0;j<found_restaurant.size();j++){
            adapter.addItem(new Peopleitems(found_restaurant.get(j).getName()));
        }

        listView.setAdapter(adapter);


        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(onepeopleActivity.this,finalActivity.class);
                i.putExtra("from one",true);
                startActivity(i);

                Intent intent=new Intent(onepeopleActivity.this,finalActivity.class);
                intent.putParcelableArrayListExtra("To final", found_restaurant);
                startActivity(intent);
            }
        });


    }
    class PeopleAdapter extends BaseAdapter {

        ArrayList<Peopleitems> items = new ArrayList<Peopleitems>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(Peopleitems item) {
            items.add(item);
        }

        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        public boolean getChecked(int i)
        {
            return items.get(i).isChecked();
        }

        @Override
        public View getView(int i, View convertview, ViewGroup viewGroup) {
            peopleitemviewcod view = new peopleitemviewcod(getApplicationContext());
            final Peopleitems item = items.get(i);
            view.setName(item.getName());
            CheckBox checkBox=(CheckBox)view.findViewById(R.id.checkBox);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(b){
                        item.setChecked(true);
                    }
                    else{
                        item.setChecked(false);
                    }
                }
            });

                return view;

        }
    }

}
