package cima.pro.calculatorez;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spOps;
    Button GetResult;
    EditText num1, num2;
    TextView Result;

//MAIN
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refs();
        GetResult.setOnClickListener(doOperation);
    }

    //Button Method
    private View.OnClickListener doOperation = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            double x = 0, y = 0;

            x = Parser(x, num1);
            y = Parser(y, num2);
            double z = Operate(x, y);
            Display(z);

        }
    };
    //Reference Method
    private void refs()
    {
        spOps=findViewById(R.id.spinner);
        GetResult = findViewById(R.id.Equals);
        num1 = findViewById(R.id.Num1);
        num2 = findViewById(R.id.Num2);
        Result = findViewById(R.id.Result);


    }
    private double Parser(double num, EditText editText)
    {
        try
        {
            num = Double.parseDouble(editText.getText().toString());
        }
        catch (Exception e)
        {
            Toast.makeText(getApplication(),"Invalid input",Toast.LENGTH_SHORT).show();
        }

        return num;

    }
    private double Operate(double a, double b)
    {
        double answer = 0;
        String Operator = spOps.getSelectedItem().toString();
        switch (Operator.trim().charAt(0))
        {

            case '+':
                answer = a+b;
                break;
            case '-':
                answer = a-b;
                break;
            case '/':
                answer = a/b;
                break;
            case '*':
                answer = a*b;
                break;

        }
        return answer;
    }

    private void Display(double a)
    {
        if (a % 1 == 0)
        {
            int i = (int)(a);
            Result.setText("Answer is: " + i);
        }
        else
        {
            Result.setText("Answer is: " + a);
        }

    }
}
