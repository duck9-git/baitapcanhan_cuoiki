package duck.chinh.baitapcanhan_cuoiki.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import duck.chinh.baitapcanhan_cuoiki.R;

public class BookmarkFragment extends Fragment {
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_bookmark, container, false);

        // You can initialize views or set up listeners here

        return rootView;
    }
}
