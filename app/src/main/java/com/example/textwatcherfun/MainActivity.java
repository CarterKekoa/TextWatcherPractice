package com.example.textwatcherfun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        final EditText nameEditText = (EditText) findViewById(R.id.nameEditText);
        final TextView helloTextView = (TextView) findViewById(R.id.helloTextField);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEditText.getText().toString();
                if (name.length() > 0){
                    helloTextView.setText(name + " is a nerd");
                } else {
                    helloTextView.setText("");
                    //show a Toast
                    //toast: short message displayed for a short period of time
                    //we use a static method makeText()
                    Toast toast = Toast.makeText(MainActivity.this, "Please enter a name", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        //we don't even need the hello button
        //we can listen for edit text text changed events
        //with the TextWatcher interface
        nameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //we can use this one or afterTextChanged
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String name = editable.toString();
                if (name.length() > 0) {
                    helloTextView.setText("Hello, " + name);
                } else {
                    helloTextView.setText("");
                }
            }
        });
    }
}
