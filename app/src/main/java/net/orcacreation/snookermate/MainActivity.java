package net.orcacreation.snookermate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int scoreTeamB = 0;
    String lastBall = "None";
    int potRed = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);

    }

    /**
     * Displays method.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));

    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * button method - team A.
     */

    public void redA(View view) {

        if (potRed < 15) {

            if (lastBall != "redA") {
                scoreTeamA = scoreTeamA + 1;
                displayForTeamA(scoreTeamA);
                potRed = potRed + 1;
            } else {
                scoreTeamB = scoreTeamB + 1;
                displayForTeamB(scoreTeamB);
            }
            lastBall = "redA";
        }
    }

    public void blackA(View view) {
        if (lastBall == "redA") {
            scoreTeamA = scoreTeamA + 7;
            displayForTeamA(scoreTeamA);
        } else {
            scoreTeamB = scoreTeamB + 7;
            displayForTeamB(scoreTeamB);
        }
        lastBall = "black";
    }

    public void pinkA(View view) {
        if (lastBall == "redA") {
            scoreTeamA = scoreTeamA + 6;
            displayForTeamA(scoreTeamA);
        } else {
            scoreTeamB = scoreTeamB + 6;
            displayForTeamB(scoreTeamB);
        }
        lastBall = "pink";
    }

    public void blueA(View view) {
        if (lastBall == "redA") {
            scoreTeamA = scoreTeamA + 5;
            displayForTeamA(scoreTeamA);
        } else {
            scoreTeamB = scoreTeamB + 5;
            displayForTeamB(scoreTeamB);
        }
        lastBall = "blue";
    }

    public void brownA(View view) {
        if (lastBall == "redA") {
            scoreTeamA = scoreTeamA + 4;
            displayForTeamA(scoreTeamA);
        } else {
            scoreTeamB = scoreTeamB + 4;
            displayForTeamB(scoreTeamB);
        }
        lastBall = "brown";
    }

    public void greenA(View view) {
        if (lastBall == "redA") {
            scoreTeamA = scoreTeamA + 3;
            displayForTeamA(scoreTeamA);
        } else {
            scoreTeamB = scoreTeamB + 3;
            displayForTeamB(scoreTeamB);
        }
        lastBall = "green";
    }

    public void yellowA(View view) {
        if (lastBall == "redA") {
            scoreTeamA = scoreTeamA + 2;
            displayForTeamA(scoreTeamA);
        } else {
            scoreTeamB = scoreTeamB + 2;
            displayForTeamB(scoreTeamB);
        }
        lastBall = "yellow";
    }


    /**
     * button method - team B.
     */
    public void redB(View view) {
        if (potRed < 15) {
            if (lastBall != "redB") {
                scoreTeamB = scoreTeamB + 1;
                displayForTeamB(scoreTeamB);
                potRed = potRed + 1;
            } else {
                scoreTeamA = scoreTeamA + 1;
                displayForTeamA(scoreTeamA);
            }
            lastBall = "redB";
        }
    }

    public void blackB(View view) {
        if (lastBall == "redB") {
            scoreTeamB = scoreTeamB + 7;
            displayForTeamB(scoreTeamB);
        } else {
            scoreTeamA = scoreTeamA + 7;
            displayForTeamA(scoreTeamA);
        }
        lastBall = "black";
    }

    public void pinkB(View view) {
        if (lastBall == "redB") {
            scoreTeamB = scoreTeamB + 6;
            displayForTeamB(scoreTeamB);
        } else {
            scoreTeamA = scoreTeamA + 6;
            displayForTeamA(scoreTeamA);
        }
        lastBall = "pink";
    }

    public void blueB(View view) {
        if (lastBall == "redB") {
            scoreTeamB = scoreTeamB + 5;
            displayForTeamB(scoreTeamB);
        } else {
            scoreTeamA = scoreTeamA + 5;
            displayForTeamA(scoreTeamA);
        }
        lastBall = "blue";
    }

    public void brownB(View view) {
        if (lastBall == "redB") {
            scoreTeamB = scoreTeamB + 4;
            displayForTeamB(scoreTeamB);
        } else {
            scoreTeamA = scoreTeamA + 4;
            displayForTeamA(scoreTeamA);
        }
        lastBall = "brown";
    }

    public void greenB(View view) {
        if (lastBall == "redB") {
            scoreTeamB = scoreTeamB + 3;
            displayForTeamB(scoreTeamB);
        } else {
            scoreTeamA = scoreTeamA + 3;
            displayForTeamA(scoreTeamA);
        }
        lastBall = "green";
    }

    public void yellowB(View view) {
        if (lastBall == "redB") {
            scoreTeamB = scoreTeamB + 2;
            displayForTeamB(scoreTeamB);
        } else {
            scoreTeamA = scoreTeamA + 2;
            displayForTeamA(scoreTeamA);
        }
        lastBall = "yellow";
    }

    /**
     * button method - OTHERS.
     */

    public void resetScore(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        potRed = 0;
        lastBall = "None";
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    public void over(View view) {
        lastBall = "None";
    }


}
