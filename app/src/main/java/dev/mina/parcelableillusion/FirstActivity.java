package dev.mina.parcelableillusion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


class FirstActivity extends AppCompatActivity {

    public static String FIRST_CHILD_EXTRA = "FirstChild";
    public static String SECOND_CHILD_EXTRA = "SecondChild";

    private ChildOne firstChild;
    private ChildTwo secondChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FirstFragment()).commit();
        Button firstButton = findViewById(R.id.create_child_one);
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstChild = new ChildOne();
                firstChild.childString = "One";
                firstChild.childEnum = SecondEnum.CHILD_ITEM_TWO;

                firstChild.firstNo = 123;
                firstChild.secondNo = 123;
                firstChild.firstText = "Parent One";
                firstChild.enumItem = FirstEnum.ITEM_TWO;
            }
        });
        Button secondButton = findViewById(R.id.create_child_two);
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondChild = new ChildTwo();
                secondChild.childNo = 11;
                secondChild.childText = "Two";

                secondChild.firstNo = 456;
                secondChild.secondNo = 456;
                secondChild.firstText = "Parent Two";
                secondChild.enumItem = FirstEnum.ITEM_TWO;
            }
        });
        Button sendItems = findViewById(R.id.send_items);

        sendItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                Bundle bundle = new Bundle();
                if (firstChild != null)
                    bundle.putParcelable(FIRST_CHILD_EXTRA, firstChild);
                if (secondChild != null)
                    bundle.putParcelable(SECOND_CHILD_EXTRA, secondChild);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
