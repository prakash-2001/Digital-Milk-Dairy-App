package mad.mini.digitaldairyapp.admin.ui.admin_home;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mad.mini.digitaldairyapp.R;

public class admin_home extends Fragment {

    private AdminHomeViewModel mViewModel;

    public static admin_home newInstance() {
        return new admin_home();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.admin_home, container, false);
    }

}