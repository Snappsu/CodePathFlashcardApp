package com.example.flashcardapp2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    boolean viewAns = false;

    @Override
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


    }
}

