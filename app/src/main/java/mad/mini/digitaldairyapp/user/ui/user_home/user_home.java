package mad.mini.digitaldairyapp.user.ui.user_home;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mad.mini.digitaldairyapp.R;

public class user_home extends Fragment {

    private UserHomeViewModel mViewModel;

    public static user_home newInstance() {
        return new user_home();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.user_home, container, false);
    }
}