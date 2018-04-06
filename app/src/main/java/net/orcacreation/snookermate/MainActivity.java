package net.orcacreation.snookermate;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int scoreTeamB = 0;
    String lastBall = "None";
    int potRed = 0;
    int potPin = 0;
    boolean foulState = false;

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
        TextView scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        TextView scoreView = findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForPotRed() {
        TextView potRedView = findViewById(R.id.pot_red_value);
        if (potRed >= 15){
            potRedView.setText("Done");
        } else{
        potRedView.setText(String.valueOf(potRed));}
    }

    public void displayForPotPin() {
        TextView potPinView = findViewById(R.id.pot_pin_value);
        potPinView.setText(String.valueOf(potPin));
    }

    public void displayForLastBall() {
        TextView lastBallView = findViewById(R.id.last_ball_value);
        lastBallView.setText(lastBall);
    }

    public void toastResult() {
        String message = "";
        if (scoreTeamA > scoreTeamB)
            message = "  Game Over!" + "\nPlayer 1 wins!";
        if (scoreTeamB > scoreTeamA)
            message = "  Game Over!" + "\nPlayer 2 wins!";

        final Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, 1000);

        //Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Calculation and setting method.
     */

    public void resetLastBall() {
        if (potRed < 15) {
            lastBall = "None";
            displayForLastBall();
        }
    }

    public void reverseFoulState() {
        Button foulButton = findViewById(R.id.foul_button);
        if (foulState) {
            foulState = false;
            foulButton.setTextColor(Color.WHITE);
        } else {
            foulState = true;
            foulButton.setTextColor(Color.RED);
        }
    }

    public void resetFoulState() {
        Button foulButton = findViewById(R.id.foul_button);
        foulState = false;
        foulButton.setTextColor(Color.WHITE);
    }

    /**
     * button method - team A.
     */

    public void redA(View view) {

        if (potRed < 15) {

            if (foulState) {
                scoreTeamB += 1;
                displayForTeamB(scoreTeamB);
                resetLastBall();
                resetFoulState();
                return;
            }

            if (lastBall != "redA") {
                scoreTeamA += 1;
                displayForTeamA(scoreTeamA);
                potRed += 1;
            } else {
                scoreTeamB += 1;
                displayForTeamB(scoreTeamB);
            }
            lastBall = "redA";
        }

        if (potRed == 15) {
            potRed += 1;
            lastBall = "lastRed";
            potPin = 1;
        }
        displayForPotRed();
        displayForLastBall();
        displayForPotPin();
    }

    public void yellowA(View view) {
        calcuratePointA(2, "lastRed", "Yellow");
    }

    public void greenA(View view) {
        calcuratePointA(3, "Yellow", "Green");
    }

    public void brownA(View view) {
        calcuratePointA(4, "Green", "Brown");
    }

    public void blueA(View view) {
        calcuratePointA(5, "Brown", "Blue");
    }

    public void pinkA(View view) {
        calcuratePointA(6, "Blue", "Pink");
    }

    public void blackA(View view) {
        calcuratePointA(7, "Pink", "Black");
    }

    public void calcuratePointA(int pinValue, String oldLastBall, String newLastBall) {
        if (potPin == 7) {
            toastResult();
            return;
        }

        if (potPin >= pinValue) {
            return;
        }

        if (foulState) {
            scoreTeamB += pinValue;
            displayForTeamB(scoreTeamB);
            resetLastBall();
            resetFoulState();
            return;
        }

        if (lastBall.equals("redA")) {
            scoreTeamA += pinValue;
            displayForTeamA(scoreTeamA);
            lastBall = "color";
            displayForLastBall();
            return;
        } else if (lastBall.equals(oldLastBall)) {
            scoreTeamA += pinValue;
            displayForTeamA(scoreTeamA);
            lastBall = newLastBall;
            potPin += 1;
            if (potPin == 7) {
                toastResult();
            }
            displayForLastBall();
            displayForPotPin();
            return;
        } else if (potRed < 15) {
            scoreTeamB += pinValue;
            displayForTeamB(scoreTeamB);
            lastBall = "color";
            displayForLastBall();
        } else {
            scoreTeamB += pinValue;
            displayForTeamB(scoreTeamB);
        }
    }

    /**
     * button method - team B.
     */

    public void redB(View view) {
        if (potRed < 15) {
            if (foulState) {
                scoreTeamA += 1;
                displayForTeamA(scoreTeamA);
                resetLastBall();
                resetFoulState();
                return;
            }

            if (lastBall != "redB") {
                scoreTeamB += 1;
                displayForTeamB(scoreTeamB);
                potRed += 1;
            } else {
                scoreTeamA += 1;
                displayForTeamA(scoreTeamA);
            }
            lastBall = "redB";
            if (potRed == 15) {
                potRed += 1;
                lastBall = "lastRed";
                potPin = 1;
            }
            displayForPotRed();
            displayForLastBall();
            displayForPotPin();
        }
    }

    public void yellowB(View view) {
        calcuratePointB(2, "lastRed", "Yellow");
    }

    public void greenB(View view) {
        calcuratePointB(3, "Yellow", "Green");
    }

    public void brownB(View view) {
        calcuratePointB(4, "Green", "Brown");
    }

    public void blueB(View view) {
        calcuratePointB(5, "Brown", "Blue");
    }

    public void pinkB(View view) {
        calcuratePointB(6, "Blue", "Pink");
    }

    public void blackB(View view) {
        calcuratePointB(7, "Pink", "Black");
    }

    public void calcuratePointB(int pinValue, String oldLastBall, String newLastBall) {
        if (potPin == 7) {
            toastResult();
            return;
        }

        if (potPin >= pinValue) {
            return;
        }

        if (foulState) {
            scoreTeamA += pinValue;
            displayForTeamA(scoreTeamA);
            resetLastBall();
            resetFoulState();
            return;
        }

        if (lastBall.equals("redB")) {
            scoreTeamB += pinValue;
            displayForTeamB(scoreTeamB);
            lastBall = "color";
            displayForLastBall();
            return;
        } else if (lastBall.equals(oldLastBall)) {
            scoreTeamB += pinValue;
            displayForTeamB(scoreTeamB);
            lastBall = newLastBall;
            potPin += 1;
            if (potPin == 7) {
                toastResult();
            }
            displayForLastBall();
            displayForPotPin();
            return;
        } else if (potRed < 15) {
            scoreTeamA += pinValue;
            displayForTeamA(scoreTeamA);
            lastBall = "color";
            displayForLastBall();
        } else {
            scoreTeamA += pinValue;
            displayForTeamA(scoreTeamA);
        }
    }

    /**
     * button method - OTHERS.
     */

    public void resetScore(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        potRed = 0;
        potPin = 0;
        lastBall = "None";
        resetFoulState();
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayForPotRed();
        displayForPotPin();
        displayForLastBall();
    }

    public void over(View view) {
        resetLastBall();
    }

    public void foul(View view) {
        reverseFoulState();
    }
}
