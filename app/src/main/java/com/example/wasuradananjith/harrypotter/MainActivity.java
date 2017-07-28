package com.example.wasuradananjith.harrypotter;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button movieButton, exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieButton = (Button) findViewById(R.id.btnMovies);
        exitButton = (Button) findViewById(R.id.btnChars);

        movieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loadList = new Intent(getBaseContext(), MovieActivity.class);
                startActivity(loadList);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);

                // Setting Dialog Title
                alertDialog.setTitle("Confirm ...");
                alertDialog.setIcon(R.drawable.warningalert);

                // Setting Dialog Message
                alertDialog.setMessage("Are you sure you want to exit?");

                // Setting Icon to Dialog
                //alertDialog.setIcon(R.drawable.save);

                // Setting Positive "Yes" Button
                alertDialog.setNegativeButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User pressed YES button. Write Logic Here
                        Toast.makeText(getApplicationContext(), "Exit",
                                Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });

                // Setting Negative "NO" Button
                alertDialog.setPositiveButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to invoke NO event
                        Toast.makeText(getApplicationContext(), "You selected \"No\"", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });
                // Showing Alert Message
                alertDialog.show();

            }
        });

    }
}