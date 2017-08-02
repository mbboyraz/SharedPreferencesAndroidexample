package com.example.mbura.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private Button yaz;
    private EditText editText;
    private TextView textView;
    private Set<String> stringSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        defines();

        yaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                stringSet.add(String.valueOf(stringSet.size()));

                stringSet.add(editText.getText().toString());
                editor.putStringSet("key",stringSet);
                editor.commit();
                textView.setText(sp.getStringSet("key",stringSet).toString());
            }
        });


    }
    public void defines(){
        sp=getSharedPreferences("db", 0);
        editor=sp.edit();
        yaz= (Button) findViewById(R.id.button);
        editText= (EditText) findViewById(R.id.editText);
        textView= (TextView) findViewById(R.id.textview);
        stringSet=sp.getStringSet("set",new HashSet<String>());
    }
}
