package example.com.collegecircullar;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeContent extends Fragment {
    GridView gv;
    Context context;
    ArrayList prgmName;
    public static String[] prgmNameList = {"Quants", "Logical", "Sample paper"};
    public static int[] prgmImages =
            {R.drawable.quants, R.drawable.logical, R.drawable.sample_papers};
   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_content);
        gv=(GridView) findViewById(R.id.gridview);
        gv.setAdapter(new HomeContentAdapter(this, prgmNameList,prgmImages));
    }*/

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_content, container, false);

        gv = (GridView) v.findViewById(R.id.gridview);
        gv.setAdapter(new HomeContentAdapter(getActivity(), prgmNameList, prgmImages));

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedFromList = String.valueOf(gv.getItemAtPosition(position));
                System.out.println("selectedList"+selectedFromList);
                switch (selectedFromList){
                    case "0":
                            startActivity(new Intent(getContext(),QuantsTitles.class));
                        /*FragmentManager fragmentManager = getFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.frame, new QuantsTitles()).commit();*/
                        break;
                }
            }
        });
        return v;
    }
}