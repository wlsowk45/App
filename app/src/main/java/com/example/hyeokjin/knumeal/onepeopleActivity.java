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


    ArrayList<Restaurant> found_restaurant = new ArrayList<Restaurant>();
    ArrayList<Restaurant> checked_restaurant = new ArrayList<Restaurant>();
    PeopleAdapter adapter;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onepeople);



        Intent i = getIntent();
        found_restaurant = i.getParcelableArrayListExtra("To one");
        final ListView listView=(ListView)findViewById(R.id.listview);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);


        adapter=new PeopleAdapter();
        for(int j=0;j<found_restaurant.size();j++){
            adapter.addItem(new Peopleitems(found_restaurant.get(j).getName()));
        }

        listView.setAdapter(adapter);

        final CheckBox allcheck=(CheckBox)findViewById(R.id.checkBox2);
        count=adapter.getCount();

        allcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int j=0;j<count;j++){
                    listView.setItemChecked(j,false);
                }

                adapter.notifyDataSetChanged();
            }
        });









        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0;i<found_restaurant.size();i++){
                    found_restaurant.get(i).setChecked(adapter.getChecked(i));
                    if(found_restaurant.get(i).isChecked()){
                        //Toast.makeText(getApplicationContext(),"체크 된 식당"+found_restaurant.get(i).getName(),Toast.LENGTH_SHORT).show();
                        checked_restaurant.add(found_restaurant.get(i));
                    }

                }

                Intent intent=new Intent(onepeopleActivity.this,finalActivity.class);
                intent.putParcelableArrayListExtra("To final", checked_restaurant);
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
        public View getView(final int i, View convertview, ViewGroup viewGroup) {
            peopleitemviewcod view = new peopleitemviewcod(getApplicationContext());
            final Peopleitems item = items.get(i);
            view.setName(item.getName());
            final CheckBox checkBox=(CheckBox)view.findViewById(R.id.checkBox);
            if(item.isChecked()){
                checkBox.setChecked(true);

            }
            else{
                checkBox.setChecked(false);

            }





            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(b){
                        item.setChecked(true);

                        Toast.makeText(getApplicationContext(),"체크된 식당"+item.getName()+item.isChecked(),Toast.LENGTH_SHORT).show();

                    }
                    else{
                        item.setChecked(false);
                        Toast.makeText(getApplicationContext(),"체크X"+item.getName()+item.isChecked(),Toast.LENGTH_SHORT).show();


                    }
                }
            });


            return view;

        }
    }

}
