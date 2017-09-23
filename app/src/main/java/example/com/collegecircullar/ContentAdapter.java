package example.com.collegecircullar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Justin Joy (jojus) on 19-08-2017.
 */

class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ViewHolder> {
    private List<Topics> quants_title;
    private Context mContext;

    ContentAdapter(Context context, List<Topics> list) {
        mContext = context;
        quants_title = list;
    }

    @Override
    public ContentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.quants_title_customize, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContentAdapter.ViewHolder holder, int position) {
        Topics topics = new Topics();
        System.out.println("@@@Topics@@@" + topics.getTopic());
        holder.title.setText(topics.getTopic());
    }

    @Override
    public int getItemCount() {
        System.out.println("##item counts##" + quants_title.size());
        return quants_title.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;

        ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.quants_title);
        }
    }
}
