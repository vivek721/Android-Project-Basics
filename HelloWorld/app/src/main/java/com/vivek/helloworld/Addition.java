package com.vivek.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Addition extends AppCompatActivity {
    EditText etp1,etp2;
    Button button;
    TextView ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);
        etp1 = (EditText)findViewById(R.id.etp1);
        etp2 = (EditText)findViewById(R.id.etp2);
        button = (Button)findViewById(R.id.button);
        ans = (TextView)findViewById(R.id.textView3);



    }
    public void add(View v){ 
        System.out.println("button was clicked");
        System.out.println(etp1.getText() + " " + etp2.getText());
        int sum;
        sum = Integer.parseInt(String.valueOf(etp1.getText())) + Integer.parseInt(String.valueOf(etp2.getText()));
        System.out.println(sum);
        ans.append(String.valueOf(sum));
    }
}
