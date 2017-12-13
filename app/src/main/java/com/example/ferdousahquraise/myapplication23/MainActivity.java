package com.example.ferdousahquraise.myapplication23;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     EditText E1,E2,E3,E4;
    Button B1,b2;
    mysqlite my;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        E1=(EditText) findViewById(R.id.editText);
        E2=(EditText) findViewById(R.id.editText2);
        E3=(EditText) findViewById(R.id.editText3);
        E4=(EditText) findViewById(R.id.editText4);
        B1=(Button) findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        t=(TextView)findViewById(R.id.textView);
        my= new mysqlite(this);
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               boolean ch =  my.addtotable(E1.getText().toString(),E2.getText().toString(),E3.getText().toString(),E4.getText().toString());
               if(ch == true)
                   Toast.makeText(MainActivity.this,"Inserted" , Toast.LENGTH_LONG).show();
                else
                   Toast.makeText(MainActivity.this,"NOT",Toast.LENGTH_LONG).show();

            }
        });

    }
    public void viewdata(View view)
    {
       Cursor res= my.display("76");
        res.moveToFirst();
        StringBuffer buffer = new StringBuffer();
       do{

            buffer.append(res.getString(0)+"\n");
            buffer.append(res.getString(1)+"\n");
            buffer.append(res.getString(2)+"\n");


        }while (res.moveToNext());
         Display(buffer.toString());
    }
    public  void Display(String data)
    {
        t.setText(data);
    }
}
