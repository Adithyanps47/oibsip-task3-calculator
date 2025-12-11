package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.operator.Operator;
import net.objecthunter.exp4j.function.Function;

public class MainActivity extends AppCompatActivity {

    private EditText etInput;
    private Group sciGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = findViewById(R.id.etInput);
        sciGroup = findViewById(R.id.sciGroup);

        etInput.setShowSoftInputOnFocus(false);

        setNumericListeners();
        setOperatorListeners();
        setScientificListeners();
        setFunctionalListeners();
    }

    private void setNumericListeners() {
        int[] numberIds = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
                R.id.btn4, R.id.btn5, R.id.btn6,
                R.id.btn7, R.id.btn8, R.id.btn9, R.id.btnDot
        };
        View.OnClickListener listener = v -> insertText(((Button)v).getText().toString());
        for (int id : numberIds) findViewById(id).setOnClickListener(listener);
    }

    private void setOperatorListeners() {
        int[] opIds = { R.id.btnPlus, R.id.btnMinus, R.id.btnMultiply, R.id.btnDivide };
        View.OnClickListener listener = v -> insertText(((Button)v).getText().toString());
        for (int id : opIds) findViewById(id).setOnClickListener(listener);
    }

    private void setScientificListeners() {
        findViewById(R.id.btnSciTrigger).setOnClickListener(v -> {
            sciGroup.setVisibility(sciGroup.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
        });

        findViewById(R.id.btnSin).setOnClickListener(v -> insertText("sin("));
        findViewById(R.id.btnCos).setOnClickListener(v -> insertText("cos("));
        findViewById(R.id.btnTan).setOnClickListener(v -> insertText("tan("));
        findViewById(R.id.btnLog).setOnClickListener(v -> insertText("log("));
        findViewById(R.id.btnSqrt).setOnClickListener(v -> insertText("sqrt("));
        findViewById(R.id.btnPower).setOnClickListener(v -> insertText("^"));
        findViewById(R.id.btnFactorial).setOnClickListener(v -> insertText("!"));

        findViewById(R.id.btnBracket).setOnClickListener(v -> {
            String text = etInput.getText().toString();
            int openCount = 0;
            for (char c : text.toCharArray()) {
                if (c == '(') openCount++;
                else if (c == ')') openCount--;
            }

            if (openCount > 0 && text.length() > 0) {
                char lastChar = text.charAt(text.length() - 1);
                if (Character.isDigit(lastChar) || lastChar == ')') {
                    insertText(")");
                } else {
                    insertText("(");
                }
            } else {
                insertText("(");
            }
        });
    }

    private void setFunctionalListeners() {
        findViewById(R.id.btnAC).setOnClickListener(v -> etInput.setText(""));
        findViewById(R.id.btnPercent).setOnClickListener(v -> insertText("%"));

        findViewById(R.id.btnBackspace).setOnClickListener(v -> {
            Editable text = etInput.getText();
            int cursorPosition = etInput.getSelectionStart();
            if (cursorPosition > 0) text.delete(cursorPosition - 1, cursorPosition);
        });

        findViewById(R.id.btnEquals).setOnClickListener(v -> calculateResult());
    }

    private void insertText(String strToAdd) {
        int start = Math.max(etInput.getSelectionStart(), 0);
        int end = Math.max(etInput.getSelectionEnd(), 0);
        etInput.getText().replace(Math.min(start, end), Math.max(start, end), strToAdd, 0, strToAdd.length());
    }

    private void calculateResult() {
        String txt = etInput.getText().toString();
        if (txt.isEmpty()) return;

        try {
            String exprStr = txt.replace("×", "*")
                    .replace("÷", "/")
                    .replace("−", "-")
                    .replace("%", "/100");

            exprStr = exprStr.replaceAll("(?<=\\d)\\(", "*(");
            exprStr = exprStr.replaceAll("\\)(?=\\d)", ")*");

            int openBrackets = 0;
            int closeBrackets = 0;
            for (char c : exprStr.toCharArray()) {
                if (c == '(') openBrackets++;
                if (c == ')') closeBrackets++;
            }
            while (openBrackets > closeBrackets) {
                exprStr += ")";
                closeBrackets++;
            }

            Expression expression = new ExpressionBuilder(exprStr)
                    .function(sinDeg)
                    .function(cosDeg)
                    .function(tanDeg)
                    .function(logFunc)
                    .operator(factorialOp)
                    .build();

            double result = expression.evaluate();

            if (Double.isInfinite(result) || Double.isNaN(result)) {
                etInput.setText("Error");
            } else {
                etInput.setText(result == (long) result ? String.valueOf((long) result) : String.valueOf(result));
            }
            etInput.setSelection(etInput.getText().length());

        } catch (ArithmeticException e) {
            etInput.setError("Math Error");
        } catch (Exception e) {
            etInput.setError("Invalid Expression");
        }
    }

       Operator factorialOp = new Operator("!", 1, true, Operator.PRECEDENCE_POWER + 1) {
        @Override
        public double apply(double... args) {
            int arg = (int) args[0];
            if ((double) arg != args[0]) {
                throw new IllegalArgumentException("Operand for factorial has to be an integer");
            }
            if (arg < 0) {
                throw new IllegalArgumentException("The operand of the factorial can not be less than zero");
            }
            double result = 1;
            for (int i = 1; i <= arg; i++) {
                result *= i;
            }
            return result;
        }
    };

   Function sinDeg = new Function("sin", 1) {
        @Override
        public double apply(double... args) {
            return Math.sin(Math.toRadians(args[0]));
        }
    };

    Function cosDeg = new Function("cos", 1) {
        @Override
        public double apply(double... args) {
            return Math.cos(Math.toRadians(args[0]));
        }
    };

    Function tanDeg = new Function("tan", 1) {
        @Override
        public double apply(double... args) {
            return Math.tan(Math.toRadians(args[0]));
        }
    };
    Function logFunc = new Function("log", 1) {
        @Override
        public double apply(double... args) {
            return Math.log10(args[0]);
        }
    };
}