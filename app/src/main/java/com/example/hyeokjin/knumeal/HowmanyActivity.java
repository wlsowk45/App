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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howmany);
        final EditText editText=(EditText)findViewById(R.id.editText);
        Button button=(Button)findViewById(R.id.button4);
        textview=(TextView)findViewById(R.id.textView);
        str=editText.getText().toString();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textview.setText(editText.getText());
                Log.d("알림","1111111111"+16);
            }
        });






    }
}
