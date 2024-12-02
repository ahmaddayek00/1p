package com.example.unitconverter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView,textView2,textView4,valueinpounds;
    Button button;
    private View textview;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview=findViewById(R.id.textView);
        textView2=findViewById(R.id.textView2);
        textView4=findViewById(R.id.textView4);
        valueinpounds=findViewById(R.id.valueOfPounds);

        editText=findViewById(R.id.editText);
        button=findViewById(R.id.button);

        button.setOnClickListener(new textView.OnClickListener(){
            @override
            public void onClick(View v){

                ConvertFromKiloToPound();

            }


        });



    }

    private void ConvertFromKiloToPound() {
        string valueEnteredinKILO=editText.getText().toString();
        double kilo = Double.parseDouble(valueEnteredinKILO);
        double pounds=kilo* 2.205;
valueinpounds.setText(""+ pounds);
}
    }
