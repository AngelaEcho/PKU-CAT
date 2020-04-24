<<<<<<< HEAD
package com.example.pkucat.ui.archive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.pkucat.R;

public class ArchiveFragment extends Fragment {
    private ArchiveViewModel archiveViewModel;
    private Button bSearchArchive;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_archive, container, false);
        bSearchArchive = (Button) root.findViewById(R.id.searchArchive_button);
        return root;
    }
    public void search(){

    }
}
=======
package com.example.pkucat.ui.archive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.pkucat.R;

public class ArchiveFragment extends Fragment {
    private ArchiveViewModel archiveViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        archiveViewModel =
                ViewModelProviders.of(this).get(ArchiveViewModel.class);
        View root = inflater.inflate(R.layout.fragment_archive, container, false);
        final TextView textView = root.findViewById(R.id.text_archive);
        archiveViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
>>>>>>> e2d708ed7687c459bea18b7d72b70579e7b4d609
