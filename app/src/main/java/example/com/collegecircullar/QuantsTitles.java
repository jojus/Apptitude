package example.com.collegecircullar;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Justin Joy (jojus) on 19-08-2017.
 */

public class QuantsTitles extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ContentAdapter mContentAdapter;
    private List<Topics> mList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quants_list);
        mRecyclerView = (RecyclerView) findViewById(R.id.quants_recycler);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(QuantsTitles.this);
        mRecyclerView.setLayoutManager(llm);
        // initilize views
        initializeViews();
    }

  /*  @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        // connect with xml layout
        View v = inflater.inflate(R.layout.quants_list, container, false);
        // mapping to xml
        mRecyclerView = (RecyclerView) v.findViewById(R.id.quants_recycler);
        // initilize views
        initializeViews();

        return v;
    }*/

    private void initializeViews() {
        Topics t = new Topics();
        mList = new ArrayList<>();
        t.setTopic("Age");
        t.setTopic(" Area");
        t.setTopic("Average");
        t.setTopic("Banker's Discount");
        t.setTopic("Boats and Streams");
        t.setTopic("Calendar");
        t.setTopic(" Chain Rule");
        t.setTopic(" Clock");
        t.setTopic("Decimal Fractions");
        t.setTopic("H.C.F. and L.C.M.");
        t.setTopic(" Height and Distance");
        t.setTopic(" Logarithm");
        t.setTopic(" Mixture and Alligation");
        t.setTopic("Numbers");
        t.setTopic("Partnerships");
        t.setTopic("Percentage");
        t.setTopic("Permutations and Combinations ");
        t.setTopic("Pipes and Cistern");
        t.setTopic("Probability");
        t.setTopic("Profit and Loss");
        t.setTopic("Races and Games");
        t.setTopic("Series - Odd Man Out");
        t.setTopic("Series - Find Missing Number");
        t.setTopic("Simple Interest");
        t.setTopic("Compound Interest");
        t.setTopic("Simplification");
        t.setTopic("Square Root and Cube Root");
        t.setTopic("Stocks and Shares");
        t.setTopic("Surds and Indices");
        t.setTopic("Time and Distance");
        t.setTopic("Time and Work");
        t.setTopic("Trains");
        mList.add(t);
        mContentAdapter = new ContentAdapter(QuantsTitles.this,mList);
        mRecyclerView.setAdapter(mContentAdapter);
    }
}