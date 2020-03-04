package com.example.flashcardapp2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    boolean viewAns = false;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) { // this 100 needs to match the 100 we used when we called startActivityForResult!
            String newQuestion = data.getExtras().getString("question");
            String newAnswer = data.getExtras().getString("answer");
            TextView question = findViewById(R.id.flashcardQuestion);
            question.setText(newQuestion);
            TextView answer = findViewById(R.id.flashcardAnswer);
            answer.setText(newAnswer);
            findViewById(R.id.flashcardAnswer).setVisibility(View.INVISIBLE);
            findViewById(R.id.flashcardQuestion).setVisibility(View.VISIBLE);
        }
    }
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.flashcardAnswer).setVisibility(View.INVISIBLE);

        findViewById(R.id.layout).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (viewAns) {
                    Log.d("TOGGLE","Flash card flipped (answer).");
                    findViewById(R.id.flashcardAnswer).setVisibility(View.VISIBLE);
                    findViewById(R.id.flashcardQuestion).setVisibility(View.INVISIBLE);
                    viewAns=false;
                }
                else if (!viewAns) {
                    Log.d("TOGGLE","Flash card flipped (question).");
                    findViewById(R.id.flashcardAnswer).setVisibility(View.INVISIBLE);
                    findViewById(R.id.flashcardQuestion).setVisibility(View.VISIBLE);
                    viewAns=true;
                }


            }
        });

        findViewById(R.id.addCardBtn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddCardActivity.class);
                startActivityForResult(intent, 1);
            }
        });

    }
}

