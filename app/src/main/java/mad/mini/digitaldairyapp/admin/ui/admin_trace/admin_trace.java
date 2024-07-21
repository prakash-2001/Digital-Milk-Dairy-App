package mad.mini.digitaldairyapp.admin.ui.admin_trace;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mad.mini.digitaldairyapp.R;

public class admin_trace extends Fragment {

    private AdminTraceViewModel mViewModel;

    public static admin_trace newInstance() {
        return new admin_trace();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.admin_trace, container, false);
    }


}