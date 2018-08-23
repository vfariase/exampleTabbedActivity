package cl.companyvfarias.shrinkquizz;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class PartyFragment extends Fragment {


    public PartyFragment() {
        // Required empty public constructor
        Log.d("Constructor", "PartyFragment: ");
    }

    public static PartyFragment newInstance()


    {
        return new PartyFragment();
    }

        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
            Log.d("OnCreateView", "Inflate the layout for this fragment ");
        return inflater.inflate(R.layout.fragment_party, container, false);
    }

    /*@Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       final RadioGroup radioGroup=view.findViewById(R.id.partyRg);

        Button btn=view.findViewById(R.id.partyBtn);
        Log.d("RadioButton", "onViewCreated: "+radioGroup.getCheckedRadioButtonId());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("RadioButton", "onViewCreated: "+radioGroup.getCheckedRadioButtonId());
            }
        });

    }*/

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final RadioGroup radioGroup=view.findViewById(R.id.partyRg);

        Button btn=view.findViewById(R.id.partyBtn);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = radioGroup.getCheckedRadioButtonId();

                if(id!=-1)
                    {
                     RadioButton radioButton=radioGroup.findViewById(id);
                     String awnser =  radioButton.getText().toString();
                     //Toast.makeText(getContext(),"Texto RadioButton "+awnser, Toast.LENGTH_SHORT).show();
                        showDialog(awnser);
                    }
                else
                    {
                        Toast.makeText(getContext(),"Debe seleccionar una opción ", Toast.LENGTH_SHORT).show();
                    }

                //Toast.makeText(getContext(),"Ha presionado un boton "+id, Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void showDialog(String answer)
    {
        final AlertDialog.Builder alertDialog=new AlertDialog.Builder(getActivity());
        alertDialog.setTitle("Nivel de fiesta");
        alertDialog.setMessage("NIvel de alcohol");
        alertDialog.setPositiveButton(new PartyResult(answer).score(), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        alertDialog.show();

        }


}

