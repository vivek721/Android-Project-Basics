package com.vivek.editcontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView welcomeText;
    Button button1;
    Button button2;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        welcomeText = (TextView) findViewById(R.id.welcomeText);

        button1.setOnClickListener(v -> {
            Intent intent = new Intent(this, EditName.class);
            startActivityForResult(intent, 2);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("requestCode : " + requestCode + " resultCode: " + resultCode + " data : " + data);
        String [] str = data.getStringExtra("UserName").split(" ");
        welcomeText.append(" " + str[0]);
        button2.setOnClickListener(v -> {
            if (requestCode == 2) {
                String userName = data.getStringExtra("UserName");
                System.out.println("Name : " + userName);

                System.out.println(requestCode);
                if (resultCode == 0) {
                    System.out.println("2nd button clicked");
                    String[] s = userName.split(" ");
                    if (s.length < 2) {
                        toast = Toast.makeText(this.getApplicationContext(), "Enter Last Name : " + userName, Toast.LENGTH_LONG);
                        toast.show();
                    } else {
                        toast = Toast.makeText(this.getApplicationContext(), "Invalid name : " + userName, Toast.LENGTH_LONG);
                        toast.show();
                    }
                } else {
                    Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                    intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
                    intent.putExtra(ContactsContract.Intents.Insert.NAME, userName);
                    startActivity(intent);
                }
            }

        });
    }
}
