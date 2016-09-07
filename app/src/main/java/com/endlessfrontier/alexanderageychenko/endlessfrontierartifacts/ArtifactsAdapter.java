package com.endlessfrontier.alexanderageychenko.endlessfrontierartifacts;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.endlessfrontier.alexanderageychenko.endlessfrontierartifacts.model.Artifact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by vladimiryuyukin on 26.02.16.
 */
public class ArtifactsAdapter extends RecyclerView.Adapter<ArtifactsAdapter.ViewHolder> {
    Context context;
    ArrayList<Artifact> data = new ArrayList<>();


    public void setData(Context context, ArrayList<Artifact> data) {
        if (context != null)
            this.context = context;
        this.data.clear();
        if (data != null) {
            this.data.addAll(data);
            sortByAlphabet(this.data);
        }
        notifyDataSetChanged();
    }

    private ArrayList<Artifact> sortByAlphabet(ArrayList<Artifact> list) {
        Collections.sort(list, new Comparator<Artifact>() {
            public int compare(Artifact o1, Artifact o2) {
                return o1.stars.compareTo(o2.stars);
            }
        });
        return list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.artifact_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Artifact item = data.get(position);
        holder.name.setText(item.item_name);
        holder.stars.setText(item.stars);
        holder.source.setText(item.source);
        try {
            holder.param1.setText(item.attributes.get(0).getFullName());
            holder.param2.setText(item.attributes.get(1).getFullName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            holder.material1.setText(item.materials.get(0));
            holder.material2.setText(item.materials.get(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Integer stars = Integer.parseInt(item.stars.substring(0, 1));
        if (stars != null) {
            switch (stars) {
                case 6: {
                    holder.image.setBackgroundColor(context.getResources().getColor(R.color.main_orange));
                    break;
                }
                case 5: {
                    holder.image.setBackgroundColor(context.getResources().getColor(R.color.main_red));
                    break;
                }
                case 4: {
                    holder.image.setBackgroundColor(context.getResources().getColor(R.color.main_blue));
                    break;
                }
                case 3: {
                    holder.image.setBackgroundColor(context.getResources().getColor(R.color.main_green));
                    break;
                }
            }
        } else {
            holder.image.setBackgroundColor(context.getResources().getColor(R.color.main_grey));
        }
    }



    @Override
    public int getItemCount() {
        return data.size();
    }


public class ViewHolder extends RecyclerView.ViewHolder {
    TextView name;
    TextView stars;
    TextView source;
    TextView param1;
    TextView param2;
    TextView material1;
    TextView material2;
    ImageView image;

    public ViewHolder(View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.name);
        stars = (TextView) itemView.findViewById(R.id.stars);
        source = (TextView) itemView.findViewById(R.id.source);
        param1 = (TextView) itemView.findViewById(R.id.param1);
        param2 = (TextView) itemView.findViewById(R.id.param2);
        material1 = (TextView) itemView.findViewById(R.id.material1);
        material2 = (TextView) itemView.findViewById(R.id.material12);
        image = (ImageView) itemView.findViewById(R.id.image);
    }
}
}
