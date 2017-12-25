package com.example.android.scoreboard;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.logging.Handler;


public class MainActivity extends AppCompatActivity {

    Spinner spinner_team;
    ArrayAdapter<CharSequence> temre;
    int teamOneGoal=0, teamOneFoul=0;
    int teamTwoGoal=0, teamTwoFoul=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spinner_team = (Spinner) findViewById(R.id.spinner_team_one);

        temre = ArrayAdapter.createFromResource(this, R.array.team_array, R.layout.my_spinner);

        temre.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_team.setAdapter(temre);

        spinner_team = (Spinner) findViewById(R.id.spinner_team_two);

        spinner_team.setAdapter(temre);


        RelativeLayout linearLayout = (RelativeLayout)findViewById(R.id.layout);
        Resources res = getResources();
        Drawable portrait = res.getDrawable(R.drawable.futbol3);
        Drawable landscape = res.getDrawable(R.drawable.futbol2);

        WindowManager window = (WindowManager)getSystemService(WINDOW_SERVICE);
        Display display = window.getDefaultDisplay();
        int num = display.getRotation();
        if (num == 0){
            linearLayout.setBackgroundDrawable(portrait);
        }else if (num == 1 || num == 3){
            linearLayout.setBackgroundDrawable(landscape);
        }else{
            linearLayout.setBackgroundDrawable(portrait);
        }
    }



    public void displayTeamOneGoal(int goal)
    {
        TextView ScoreView = (TextView) findViewById(R.id.teamOneGoal);
        ScoreView.setText(String.valueOf(goal));
    }

    public void addTeamOneGoal(View view)
    {
        teamOneGoal=teamOneGoal+1;
        displayTeamOneGoal(teamOneGoal);


    }

    public void displayTeamOneFoul(int foul)
    {
        TextView FoulView = (TextView) findViewById(R.id.teamOneFoul);
        FoulView.setText(String.valueOf(foul));
    }

    public void addTeamOneFoul(View v)
    {
        teamOneFoul=teamOneFoul+1;
        displayTeamOneFoul(teamOneFoul);

    }

    public void displayTeamTwoGoal(int goal)
    {
        TextView ScoreView = (TextView)findViewById(R.id.teamTwoGoal);
        ScoreView.setText(String.valueOf(goal));
    }

    public void addTeamTwoGoal(View v)
    {
        teamTwoGoal=teamTwoGoal+1;
        displayTeamTwoGoal(teamTwoGoal);

    }

    public void displayTeamTwoFoul(int foul)
    {
        TextView FoulView = (TextView) findViewById(R.id.teamTwoFoul);
        FoulView.setText(String.valueOf(foul));
    }

    public void addTeamTwoFoul(View v)
    {
        teamTwoFoul=teamTwoFoul+1;
        displayTeamTwoFoul(teamTwoFoul);

    }

    public void reset(View v)
    {
        teamOneGoal=0;
        teamOneFoul=0;
        teamTwoGoal=0;
        teamTwoFoul=0;
        displayTeamOneGoal(teamOneGoal);
        displayTeamOneFoul(teamOneFoul);
        displayTeamTwoGoal(teamTwoGoal);
        displayTeamTwoFoul(teamTwoFoul);

    }


}


//Spinner spinner;
//ArrayAdapter<CharSequence>adapter;

//spinner = (Spinner) findViewById(R.id.spinner);

//adapter = ArrayAdapter.createFromResource(this, R.array.team_array, android.R.layout.simple_spinner_item);

//adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

//spinner.setAdapter(adapter);
