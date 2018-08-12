package com.example.hyeokjin.knumeal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HowmanyActivity extends AppCompatActivity {
    String str;
    public int num;
    TextView textview;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howmany);
        EditText editText=(EditText)findViewById(R.id.editText);
        Button button=(Button)findViewById(R.id.button4);
        textview=(TextView)findViewById(R.id.textView);
        num=Integer.parseInt(editText.getText().toString());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textview.setText(num);
            }
        });






    }
}
