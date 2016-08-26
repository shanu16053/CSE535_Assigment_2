package com.iiitd.vaibhav.mathgame;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Solution extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution);
        Bundle data_from_main = getIntent().getExtras();
        int question = 0;
        if(data_from_main != null){
            question = data_from_main.getInt("current_question");
        }
        EditText controller_txt_solution_display = (EditText)findViewById(R.id.txt_solution_display);
        //making the solution
        String solution = "";
        if(isPrime(question)){
            solution = "This number is a prime number as it's only factors are :- \n 1) 1\n2) " + question;
        }
        else{
            solution = "This number has the following factors :-\n" + find_factors(question) + "Thus, this can't be a prime number as a prime number has only two factors.";
        }
        //made solution
        controller_txt_solution_display.setText(solution, TextView.BufferType.EDITABLE);
    }

    public boolean isPrime(int current_question){
        int i, limit = (int)Math.sqrt((current_question*1.0));
        for(i = 2 ; i < limit ; i++){
            if(current_question % i == 0)
                return false;
        }
        return true;
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
        Toast.makeText(getApplicationContext(), "Solution Seen !", Toast.LENGTH_SHORT).show();
    }

}
