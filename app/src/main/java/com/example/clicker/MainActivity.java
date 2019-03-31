package com.example.clicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {


    Button btnClick;
    Button btnReset;
    TextView txtCount;
    private TextView mTextWord;
    private TextView textout;
    //private TextInputEditText tlumaczenie;

    private HashMap<String, String> words;
    private List<String> wordsKeys;

    String selectedWordKey;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClick = (Button) findViewById(R.id.buttonClick);
        btnReset = (Button) findViewById(R.id.buttonReset);
        txtCount = (TextView) findViewById(R.id.textViewCount);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*String countValue = txtCount.getText().toString();
                int intCountValue = Integer.parseInt(countValue);
                intCountValue++;*/

                //txtCount.setText(String.valueOf(intCountValue));
                BufferedReader br = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.dictionary)));
                Type mapType = new TypeToken<HashMap<String, String>>(){}.getType();
                words = new Gson().fromJson(br, mapType);
                wordsKeys = new ArrayList<String>(words.keySet());


                getNewWord();

            }
            private void getNewWord() {
                Random rand = new Random();
                selectedWordKey = wordsKeys.get(rand.nextInt(words.size()));
                txtCount.setText(selectedWordKey);
            }


            });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtCount.setText(tu chcę wyswietlić value);
            }
        });



    }
}
