package dev.mina.parcelableillusion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static dev.mina.parcelableillusion.FirstActivity.FIRST_CHILD_EXTRA;
import static dev.mina.parcelableillusion.FirstActivity.SECOND_CHILD_EXTRA;


class SecondActivity extends AppCompatActivity {

    private ChildOne firstChild;
    private ChildTwo secondChild;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button retrieveChildOne = findViewById(R.id.retrieve_child_one);
        retrieveChildOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstChild = getIntent().getParcelableExtra(FIRST_CHILD_EXTRA);
            }
        });
        Button retrieveChildTwo = findViewById(R.id.retrieve_child_two);
        retrieveChildTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondChild = getIntent().getParcelableExtra(SECOND_CHILD_EXTRA);
            }
        });
    }
}
