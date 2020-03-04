package com.example.flashcardapp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public  class AddCardActivity extends AppCompatActivity {
    EditText questionField, answerField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        findViewById(R.id.finishCardBtn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                questionField  = findViewById(R.id.addCardQuestion);
                answerField = findViewById(R.id.addCardAnwer);
                Intent data = new Intent(); // create a new Intent, this is where we will put our data
                data.putExtra("question", questionField.getText().toString()); // puts one string into the Intent, with the key as 'string1'
                data.putExtra("answer", answerField.getText().toString()); // puts another string into the Intent, with the key as 'string2
                setResult(RESULT_OK, data); // set result code and bundle data for response
                finish(); // closes this activity and pass data to the original activity that launched this activity

            }
        });

    }
}