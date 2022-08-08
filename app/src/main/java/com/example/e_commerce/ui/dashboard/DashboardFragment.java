package com.example.e_commerce.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.e_commerce.R;
import com.example.e_commerce.SecFragment;
import com.example.e_commerce.ui.FirstFragment;

public class DashboardFragment extends Fragment {
    View root;
    ImageView imgnext;
    ImageView imgnextwo;

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);


        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        Bundle bundle = new Bundle();

        imgnext=root.findViewById(R.id.imgnext);
        imgnextwo=root.findViewById(R.id.imgnextwo);


        imgnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString("key","abc"); // Put anything what you want

                FirstFragment fragment2 = new FirstFragment();
                fragment2.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, fragment2)
                        .addToBackStack(null)
                        .commit();
            }
        });
        imgnextwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment frag = new SecFragment();

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.nav_host_fragment, frag);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.addToBackStack(null);
                ft.commit();

            }
        });
        return root;
    }

}