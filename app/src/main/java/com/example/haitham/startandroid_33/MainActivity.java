package com.example.haitham.startandroid_33;


import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    EditText et ;
    Button btnSave,btnLoad;
    SharedPreferences sPref;

    final String SAVED_TEXT = "saved_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText)findViewById(R.id.editText);

        btnSave = (Button)findViewById(R.id.button);
        btnLoad = (Button)findViewById(R.id.button2);

        btnSave.setOnClickListener(this);
        btnLoad.setOnClickListener(this);


        loadText();

    }


    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.button:
            saveText();
            break;
        case R.id.button2:
            loadText();
            break;
    }
    }
    public void saveText(){
        sPref = getSharedPreferences("MyPref",MODE_WORLD_READABLE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT,et.getText().toString());
        ed.commit();
        Toast.makeText(this,"Text saved",Toast.LENGTH_LONG).show();
    }
    public void loadText(){
        sPref = getSharedPreferences("MyPref",MODE_WORLD_READABLE);
        String saveText = sPref.getString(SAVED_TEXT,"");
        et.setText(saveText);
        Toast.makeText(this,"Text loaded",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onDestroy() {

        saveText();
        super.onDestroy();
    }
}














