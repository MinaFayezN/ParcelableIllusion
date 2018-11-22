package dev.mina.parcelableillusion;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static dev.mina.parcelableillusion.FirstActivity.FIRST_CHILD_EXTRA;
import static dev.mina.parcelableillusion.FirstActivity.SECOND_CHILD_EXTRA;


public class FirstFragment extends Fragment {

    private ChildOne firstChild;
    private ChildTwo secondChild;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        Button firstButton = view.findViewById(R.id.create_child_one);
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
        Button secondButton = view.findViewById(R.id.create_child_two);
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
        Button sendItems = view.findViewById(R.id.send_items);

        sendItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                if (firstChild != null)
                    bundle.putParcelable(FIRST_CHILD_EXTRA, firstChild);
                if (secondChild != null)
                    bundle.putParcelable(SECOND_CHILD_EXTRA, secondChild);
                SecondFragment fragment = new SecondFragment();
                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            }
        });
        return view;
    }

}
