package id.giansar.example.android;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondFragment secondFragment = new SecondFragment();
                Bundle bundle = new Bundle();
                secondFragment.setArguments(bundle);
                FragmentTransaction fragmentTransaction =
                        getFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragment_container, secondFragment)
                                .addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            MainActivityFragment mainActivityFragment = new MainActivityFragment();
            mainActivityFragment.setArguments(getIntent().getExtras());
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, mainActivityFragment)
                    .commit();
        }
    }

}
