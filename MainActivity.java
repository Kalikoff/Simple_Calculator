// Калмыков 303
package com.example.simple_calculator.kalmykov303;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText textA;
    EditText textB;
    TextView textResult;
    float a, b, result;
    boolean isInputError = false; // Наличие ошибки при вводе значений

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textA = findViewById(R.id.editTextA);
        textB = findViewById(R.id.editTextB);
        textResult = findViewById(R.id.textViewResult);
    }

    // Проверка какая кнопка нажата
    public void Button_Click(View v) {
        Button button = (Button)v;
        String buttonText = button.getText().toString();

        Get_Values();

        if (isInputError) // Если при вводе значений произошла ошибка
            return;

        if (buttonText == getString(R.string.infoAdd)) {
            result = a + b;
        }
        else if (buttonText == getString(R.string.infoSubtract)) {
            result = a - b;
        }
        else if (buttonText == getString(R.string.infoMultiply)) {
            result = a * b;
        }
        else if (buttonText == getString(R.string.infoDivide)) {
            if (a == 0 || b == 0)
                result = 0;
            else
                result = a / b;
        }
        else if (buttonText == getString(R.string.infoSin)) {
            result = (float)Math.sin(a);
        }
        else if (buttonText == getString(R.string.infoCos)) {
            result = (float)Math.cos(a);
        }
        else if (buttonText == getString(R.string.infoTan)) {
            result = (float)Math.tan(a);
        }
        else if (buttonText == getString(R.string.infoSqrt)) {
            result = (float)Math.sqrt(a);
        }
        else if (buttonText == getString(R.string.infoPow)) {
            result = (float)Math.pow(a, b);
        }

        Set_Result(result);
    }

    // Получение чисел A и B
    private void Get_Values() {
        isInputError = false;

        a = Check_for_Errors(a, textA);
        b = Check_for_Errors(b, textB);
    }

    // Проверка editText на исключение
    private float Check_for_Errors(float value, EditText editText) {
        try {
            value = Float.parseFloat(editText.getText().toString());
        }
        catch (Exception e) {
            editText.setError("Введите значение");
            isInputError = true;
        }

        return value;
    }

    // Вывод результата
    private void Set_Result(float value) {
        textResult.setText(String.valueOf(value));
    }
}
// Калмыков 303