package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.*;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText inputBox;
    private final List<String> operations = Arrays.asList("+", "-", "×", "*", "÷", "/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputBox = findViewById(R.id.textView);
        // prevent the users keyboard from popping up but keep the carrot
        inputBox.setShowSoftInputOnFocus(false);
    }

    private String insert(String newStr, String oldString, int pos) {
        String leftOfCursor = oldString.substring(0, pos);
        String rightOfCursor = oldString.substring(pos);
        return leftOfCursor + newStr + rightOfCursor;
    }

    private void updateInputBox(String newStr) {
        String input = inputBox.getText().toString();
        int cursorPos = inputBox.getSelectionStart();
        inputBox.setText(insert(newStr, input, cursorPos));
        inputBox.setSelection(cursorPos + 1);
    }

    public void btnZero(View v) {
        updateInputBox("0");
    }

    public void btnOne(View v) {
        updateInputBox("1");
    }


    public void btnTwo(View v) {
        updateInputBox("2");
    }


    public void btnThree(View v) {
        updateInputBox("3");
    }


    public void btnFour(View v) {
        updateInputBox("4");
    }


    public void btnFive(View v) {
        updateInputBox("5");
    }


    public void btnSix(View v) {
        updateInputBox("6");
    }


    public void btnSeven(View v) {
        updateInputBox("7");
    }


    public void btnEight(View v) {
        updateInputBox("8");
    }


    public void btnNine(View v) {
        updateInputBox("9");
    }

    public void btnClear(View v) {
        inputBox.setText("");
    }

    public void btnLeftParentheses(View v) {
        updateInputBox("(");
    }

    public void btnRightParentheses(View v) {
        updateInputBox(")");
    }

    public void btnDivide(View v) {
        updateInputBox("÷");
    }

    public void btnMultiply(View v) {
        updateInputBox("×");
    }

    public void btnMinus(View v) {
        updateInputBox("-");
    }

    public void btnPlus(View v) {
        updateInputBox("+");
    }

    public void btnDecimal(View v) {
        updateInputBox(".");
    }

    public void btnBackspace(View v) {
        int cursorPosEnd = inputBox.getSelectionEnd();
        int textLength = inputBox.getText().length();

        if (cursorPosEnd != 0 && textLength != 0) {
            SpannableStringBuilder selection = (SpannableStringBuilder) inputBox.getText();
            selection.replace(cursorPosEnd - 1, cursorPosEnd, "");
            inputBox.setText(selection);
            // puts the cursor back in the correct spot
            inputBox.setSelection(cursorPosEnd - 1);
        }
    }

    public void btnEquals(View v) {
        String inputBoxText = inputBox.getText().toString();

        inputBoxText = inputBoxText.replaceAll("÷", "/");
        inputBoxText = inputBoxText.replaceAll("×", "*");

        Expression expression = new Expression(inputBoxText);

        String result = String.valueOf(expression.calculate());

        inputBox.setText(result);
        // puts the cursor back in the correct spot
        inputBox.setSelection(result.length());
    }
}