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

public class SecondFragment extends Fragment {


    private ChildOne firstChild;
    private ChildTwo secondChild;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        Button retrieveChildOne = view.findViewById(R.id.retrieve_child_one);
        retrieveChildOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstChild = getArguments().getParcelable(FIRST_CHILD_EXTRA);
            }
        });
        Button retrieveChildTwo = view.findViewById(R.id.retrieve_child_two);
        retrieveChildTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondChild = getArguments().getParcelable(SECOND_CHILD_EXTRA);
            }
        });
        return view;
    }


}
