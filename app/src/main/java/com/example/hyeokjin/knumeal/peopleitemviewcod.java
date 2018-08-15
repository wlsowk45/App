package com.example.hyeokjin.knumeal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class peopleitemviewcod extends LinearLayout {
    TextView textView;
    CheckBox checkBox;
    ImageView imageView;

    public peopleitemviewcod(Context context) {
        super(context);
        init(context);
    }

    public peopleitemviewcod(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    public void init(Context context){
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.peopleitem,this,true);
         textView=(TextView)findViewById(R.id.textView);
        checkBox=(CheckBox)findViewById(R.id.checkBox);
        imageView=(ImageView)findViewById(R.id.imageView);
    }

    public void setName(String name){
        textView.setText(name);
    }
    public void setImage(int resId){
        imageView.setImageResource(resId);
    }
}
