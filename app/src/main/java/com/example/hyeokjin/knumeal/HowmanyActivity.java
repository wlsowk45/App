package com.example.hyeokjin.knumeal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HowmanyActivity extends AppCompatActivity {
    String str;
    TextView textview;
    EditText editText;
    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howmany);
        editText=(EditText)findViewById(R.id.editText);
        Button button=(Button)findViewById(R.id.button4);
        textview=(TextView)findViewById(R.id.textView);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str=editText.getText().toString();
                if(str.length()==0){
                    textview.setText("값을 입력하시오");
                }
                else{
                    textview.setText("입력된 값"+editText.getText());
                }


            }
        });






    }
}
