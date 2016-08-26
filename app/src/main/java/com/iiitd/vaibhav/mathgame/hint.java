package com.iiitd.vaibhav.mathgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class hint extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);
        Bundle data_from_main = getIntent().getExtras();
        int question = 0;
        if(data_from_main != null){
            question = data_from_main.getInt("current_question");
        }
        EditText controller_txt_hint_display = (EditText)findViewById(R.id.txt_hint_display);
        String solution = "";
        solution = "This number has the following factors :-\n" + find_factors(question);
        controller_txt_hint_display.setText(solution, TextView.BufferType.EDITABLE);
    }

    public String find_factors(int current_question){
        int i, count = 0;
        String ret = "";
        for(i = 1 ; i <= current_question ; i++){
            if(current_question % i == 0) {
                count++;
                ret = ret + count + ") " + i + "\n";
            }
        }
        return ret;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(getApplicationContext(), "Hint Seen !", Toast.LENGTH_SHORT).show();
    }
}
