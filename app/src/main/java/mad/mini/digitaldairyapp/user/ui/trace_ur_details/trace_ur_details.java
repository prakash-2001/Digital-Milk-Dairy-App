package mad.mini.digitaldairyapp.user.ui.trace_ur_details;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mad.mini.digitaldairyapp.R;

public class trace_ur_details extends Fragment {

    private TraceUrDetailsViewModel mViewModel;

    public static trace_ur_details newInstance() {
        return new trace_ur_details();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.trace_ur_details, container, false);
    }
}