package edu.temple.otherlab6;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PaletteFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class PaletteFragment extends Fragment {

    private static final String English = "English";
    private static final String Spanish = "Spanish";
    private String[] engcolorarray;
    private String[] spancolorarray;
    OnColorSelectedListener click;

    public PaletteFragment() {
    }

    public static PaletteFragment newInstance(String[] engcolorarray, String[] spancolorarray) {

        PaletteFragment fragment = new PaletteFragment();
        Bundle args = new Bundle();
        args.putStringArray(English, engcolorarray);
        args.putStringArray(Spanish, spancolorarray);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            engcolorarray = getArguments().getStringArray(English);
            spancolorarray = getArguments().getStringArray(Spanish);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_palette, container, false);
        //ConstraintLayout backgroundcolor=(ConstraintLayout)view.findViewById(R.id.main_layout);
        Spinner spinner = view.findViewById(R.id.spinner);
        spinner.setAdapter(new ColorAdapter(getActivity(), engcolorarray, spancolorarray));
        spinner.setSelection(0,false);
        //final ConstraintLayout backgroundcolor = (ConstraintLayout) getView().findViewById(R.id.main_layout);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected (AdapterView<?> adapterView, View view, int position, long id){
                //final ConstraintLayout backgroundcolor = (ConstraintLayout) getView().findViewById(R.id.main_layout);
                 click.onColorSelected(position);
                //backgroundcolor.setBackgroundColor(Color.parseColor((String) androidColors[position]));
                view.setBackgroundColor(Color.WHITE);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView){

            }
        } );

        return view;
    }


    public interface OnColorSelectedListener {
        void onColorSelected(int position);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            click = (OnColorSelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnColorSelectedListener");
        }
    }

}

