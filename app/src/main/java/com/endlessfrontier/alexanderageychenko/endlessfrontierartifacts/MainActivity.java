package com.endlessfrontier.alexanderageychenko.endlessfrontierartifacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.endlessfrontier.alexanderageychenko.endlessfrontierartifacts.model.FragmentCroupier;
import com.endlessfrontier.alexanderageychenko.endlessfrontierartifacts.views.CollectionFragment;

public class MainActivity extends AppCompatActivity {
    public FragmentCroupier fragmentCroupier = new FragmentCroupier();
    private CollectionFragment collectionFragment = new CollectionFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();

    }

    @Override
    protected void onStart() {
        super.onStart();
        openFragmentLastPosition();
    }

    private void openFragmentLastPosition() {
        if (fragmentCroupier.getLastLoadTag().isEmpty()) {
            fragmentCroupier.loadBackStack("collection");
        } else {
            fragmentCroupier.loadBackStack(fragmentCroupier.getLastLoadTag());
        }
    }

    private void initFragment() {
        fragmentCroupier.init(getFragmentManager(), R.id.homeFragmentFrame);
        fragmentCroupier.addFragment("collection", collectionFragment);
    }


}
