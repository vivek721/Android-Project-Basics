package com.vivek.editcontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class EditName extends AppCompatActivity {
    EditText personName;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_name);
        personName = (EditText) findViewById(R.id.editTextPersonName);

        personName.setOnClickListener(v -> {
            Intent intent = new Intent(EditName.this, MainActivity.class);
            name = personName.getText().toString();
            intent.putExtra("UserName", personName.getText().toString());
            String result = "RESULT OK";
            if (!validateName(name)) {
                setResult(RESULT_CANCELED, intent);
                result = "RESULT CANCELED";
            } else {
                setResult(RESULT_OK, intent);
            }

            System.out.println(result);
            finish();
        });
    }

    public static boolean validateName(String name) {
        String[] names = name.trim().split(" ");
        boolean check = true;
        System.out.println();
        if (names.length < 2) {
            check=false;
        } else {
            for (int i = 0; i < names.length; i++) {
                check = names[i].matches("([a-zA-z]{1}[a-zA-z_'-,.]{0,23}[a-zA-Z]{0,1})");
            }
        }
        System.out.println(check);
        return check;
    }
}