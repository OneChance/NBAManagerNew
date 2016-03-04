package com.zhstar.demo.nbamanager.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.zhstar.demo.nbamanager.R;

/**
 * Created by ceeg on 2015/3/23.
 */
public class MarketFragment extends Fragment {

    private Spinner posSpinner;

    private static String[] pos = new String[]{"ALL","C","F","G"};

    private ArrayAdapter arrayAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.market_fragment, container, false);

        posSpinner = (Spinner) view.findViewById(R.id.spin_pos);

        arrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, pos);
        posSpinner.setAdapter(arrayAdapter);
        posSpinner.setSelection(0,true);

        return view;
    }
}
