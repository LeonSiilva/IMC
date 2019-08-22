package com.example.leonpsilva.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editTextAltura);
        editText2 = findViewById(R.id.editTextPeso);
        textViewResult = findViewById(R.id.textViewResultado);

        textViewResult.setText("");

    }

    public void imc (View v) {
        String num1Text = editText1.getText().toString().replace(",",".");
        String num2Text = editText2.getText().toString().replace(",",".");

        Double Altura = Double.parseDouble(num1Text);
        Double Peso = Double.parseDouble(num2Text);

        Double resultado = Peso / (Altura * Altura);

        DecimalFormat df = new DecimalFormat("#.##");
        String resultadoText = df.format(resultado);

        if(resultado <18.5) {
            textViewResult.setText(resultadoText + " - Magreza");
        }
        else {
            textViewResult.setText(resultadoText + " - Saudavel");
        }
        if (resultado >=24.9) {
            textViewResult.setText(resultadoText + " - Sobrepeso");
        }
        else {
            textViewResult.setText(resultadoText + " - Saudavel");
        }
        if (resultado >29.9) {
            textViewResult.setText(resultadoText + " - Obesidade Grau1");
        }
        else {
            textViewResult.setText(resultadoText + " - Sobrepeso");
        }
        if (resultado >34.9) {
            textViewResult.setText(resultadoText + " - Obesidade Severa Grau2");
        }
        else {
            textViewResult.setText(resultadoText + " - Obesidade Grau1");
        }
        if (resultado >39.9) {
            textViewResult.setText(resultadoText + " - Obesidade Mórbita Grau3");
        }
        else {
            textViewResult.setText(resultadoText + " - Obesidade Severa Grau2");
        }

    }
}
