package com.endlessfrontier.alexanderageychenko.endlessfrontierartifacts.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.endlessfrontier.alexanderageychenko.endlessfrontierartifacts.ArtifactsAdapter;
import com.endlessfrontier.alexanderageychenko.endlessfrontierartifacts.R;
import com.endlessfrontier.alexanderageychenko.endlessfrontierartifacts.data.Depository;
import com.endlessfrontier.alexanderageychenko.endlessfrontierartifacts.model.ExFragment;

import java.io.IOException;


/**
 * Created by vladimiryuyukin on 01.02.16.
 */
public class CollectionFragment extends ExFragment {
    private static final String TAG = "CollectionFragment";
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ArtifactsAdapter artifactsAdapter = new ArtifactsAdapter();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.collection_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        recyclerView = (RecyclerView) view.findViewById(R.id.artifacts_list);
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(artifactsAdapter);
        artifactsAdapter.setData(getActivity(), Depository.getInstance().getArtifactsList());
        artifactsAdapter.notifyDataSetChanged();
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
