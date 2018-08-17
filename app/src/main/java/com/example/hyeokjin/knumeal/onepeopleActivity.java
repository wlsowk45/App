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
import android.widget.Toast;

import java.util.ArrayList;

public class onepeopleActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onepeople);



        final ArrayList<Restaurant> found_restaurant;
        Intent i = getIntent();
        found_restaurant = i.getParcelableArrayListExtra("ToOne");
        ListView listView=(ListView)findViewById(R.id.listview);
        final PeopleAdapter adapter=new PeopleAdapter();
        for(int j=0;j<found_restaurant.size();j++){
            adapter.addItem(new Peopleitems(found_restaurant.get(j).getName()));
        }

        listView.setAdapter(adapter);


        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for(int index=0;index<found_restaurant.size();index++){
                    found_restaurant.get(index).setChecked(adapter.getChecked(index));
                }

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
