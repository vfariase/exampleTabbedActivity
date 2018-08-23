package cl.companyvfarias.shrinkquizz;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;


public class LuckyFragment extends Fragment {


    public LuckyFragment() {
        // Required empty public constructor
    }

    public static LuckyFragment newInstance()
    {
        return new LuckyFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lucky, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CheckBox happy=view.findViewById(R.id.happyCb);
        final CheckBox mood=view.findViewById(R.id.moobCb);
        Button   btn=view.findViewById(R.id.luckyBtn);

        happy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mood.setChecked(isChecked);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               boolean awnser = mood.isChecked();
                Toast.makeText(getContext(),String.valueOf(awnser), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
