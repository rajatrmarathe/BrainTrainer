package com.example.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView timer;
    TextView sumText;
    Button hide;
    CountDownTimer countDownTimer;
    TextView rw;
    TextView scoreb;
    Button button;
    Button button2;
    Button button3;
    Button button4;
    Button play_ag;
    android.support.v7.widget.GridLayout options;
    ArrayList<Integer> answers=new ArrayList();
    int answer_loc;
    int score=0;
    int no_of_questions=0;

    public void start_timer()
    {

        countDownTimer=new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                timer.setText(Integer.toString((int)millisUntilFinished/1000));


            }

            @Override
            public void onFinish() {
                options.setVisibility(View.INVISIBLE);
                scoreb.setVisibility(View.INVISIBLE);
                sumText.setVisibility(View.INVISIBLE);
                timer.setVisibility(View.INVISIBLE);
                play_ag.setVisibility(View.VISIBLE);

                String final_ans=score+"/"+no_of_questions;
                rw.setText("Time Up Your Score is: "+final_ans);



            }
        }.start();
    }

    public void play_again(View view)
    {


        score=0;
        no_of_questions=0;
        answers.clear();
        rw.setText("");
        scoreb.setText("0/0");
        options.setVisibility(View.VISIBLE);
        sumText.setVisibility(View.VISIBLE);
        scoreb.setVisibility(View.VISIBLE);
        timer.setVisibility(View.VISIBLE);
        play_ag.setVisibility(View.INVISIBLE);

        start_timer();





    }


    public void generate_ques()
    {

        Random rando=new Random();
        int a=rando.nextInt(21);
        int b=rando.nextInt(21);

        sumText.setText(Integer.toString(a)+" + "+Integer.toString(b));


        answer_loc=rando.nextInt(4); //correct answer location
        answers.clear();
        int incorrect_ans;
        for(int i=0;i<4;i++)
        {
            if(i==answer_loc)
            {
                answers.add(a+b);
            }

            else
            {
                incorrect_ans=rando.nextInt(41);
                while(incorrect_ans==(a+b))
                {
                    incorrect_ans=rando.nextInt(41);
                }
                answers.add(incorrect_ans);
            }
        }

        button.setText(Integer.toString(answers.get(0)));
        button2.setText(Integer.toString(answers.get(1)));
        button3.setText(Integer.toString(answers.get(2)));
        button4.setText(Integer.toString(answers.get(3)));



    }

    public void score_update(View view)
    {

        //Log.i("tag", view.getTag().toString());
        if(view.getTag().toString().equals(Integer.toString(answer_loc)))
        {
            score++;
            rw.setText("Correct!");

        }
        else {


            rw.setText("Incorrect");
        }
        no_of_questions++;

        scoreb.setText(Integer.toString(score)+"/"+Integer.toString(no_of_questions));
        generate_ques();

    }

    public void hide(View view)
    {

        hide.setVisibility(View.INVISIBLE);
        options.setVisibility(View.VISIBLE);
        sumText.setVisibility(View.VISIBLE);

        start_timer();




    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer= findViewById(R.id.timer);
        hide = findViewById(R.id.hide);
        rw=findViewById(R.id.rw);
        scoreb=findViewById(R.id.scoreboard);
        sumText=findViewById(R.id.sumText);
        options=findViewById(R.id.options);

        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        play_ag=findViewById(R.id.playagain);

        Random rando=new Random();
        int a=rando.nextInt(21);
        int b=rando.nextInt(21);

        sumText.setText(Integer.toString(a)+" + "+Integer.toString(b));

        answer_loc=rando.nextInt(4); //correct answer location
        int incorrect_ans;
        for(int i=0;i<4;i++)
        {
            if(i==answer_loc)
            {
                answers.add(a+b);
            }

            else
            {
                incorrect_ans=rando.nextInt(41);
                while(incorrect_ans==(a+b))
                {
                    incorrect_ans=rando.nextInt(41);
                }
                answers.add(incorrect_ans);
            }
        }

        button.setText(Integer.toString(answers.get(0)));
        button2.setText(Integer.toString(answers.get(1)));
        button3.setText(Integer.toString(answers.get(2)));
        button4.setText(Integer.toString(answers.get(3)));

        


    }
}
