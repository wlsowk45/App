package com.example.hyeokjin.knumeal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class finalActivity extends AppCompatActivity {

    ArrayList<Restaurant> final_restaurant = new ArrayList<Restaurant>();
    ArrayList<Restaurant> result_restaurant = new ArrayList<Restaurant>();

    TextView textView;
    int random_num;
    String random_result;
    Button map_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_result);
        textView = (TextView) findViewById(R.id.textView_result);
        map_button = (Button)findViewById(R.id.map_button);

        Intent intent = getIntent();
        final_restaurant = intent.getParcelableArrayListExtra("To final");

        random_num = getRandomIntNum(0,final_restaurant.size()-1);
        random_result = final_restaurant.get(random_num).getName();

        result_restaurant.clear();
        result_restaurant.add(final_restaurant.get(random_num));
        String str = "final : ";
        for(int i=0;i<final_restaurant.size();i++)
            str = str + final_restaurant.get(i).getName() + "\n";
        Toast.makeText(getApplicationContext(),str, Toast.LENGTH_SHORT).show();
        textView.setText(random_result);

        random_num=0;
        random_result="";


        map_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent_ToMap=new Intent (finalActivity.this,MapsActivity.class);
                intent_ToMap.putParcelableArrayListExtra("ToMap", result_restaurant);
                startActivity(intent_ToMap);
            }

        });


        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scale);
        textView.startAnimation(animation);




    }

    private static int getRandomIntNum(int min,int max){
        Double randomNum = (Math.random()*(max-min+1)+min);
        return randomNum.intValue();

    }

    /*
    @Override
    public void onResume(){
        super.onResume();
        // put your code here...
        Intent intent = getIntent();
        final_restaurant = intent.getParcelableArrayListExtra("To final");

        for(int i=0;i<final_restaurant.size();i++){
            if(final_restaurant.get(i).isChecked()) {
                Toast.makeText(getApplicationContext(), "체크된 식당" + final_restaurant.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(), "체크XXXX 식당" + final_restaurant.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        }

    }
    */
}
