package mad.mini.digitaldairyapp.admin.ui.entry;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mad.mini.digitaldairyapp.Database;
import mad.mini.digitaldairyapp.R;
import mad.mini.digitaldairyapp.admin.admin;

public class ad_entry extends Fragment {

    private EditText en_id, en_date, en_time, en_ltr, en_fat, en_deg, en_price;
    private Button en_sb_btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.ad_entry, container, false);

        en_id = rootView.findViewById(R.id.en_id);
        en_date = rootView.findViewById(R.id.entry_date);
        en_time = rootView.findViewById(R.id.entry_time);
        en_ltr = rootView.findViewById(R.id.entry_ltr);
        en_fat = rootView.findViewById(R.id.entry_milk_fat);
        en_deg = rootView.findViewById(R.id.entry_milk_degree);
        en_price = rootView.findViewById(R.id.entry_market_price);
        en_sb_btn = rootView.findViewById(R.id.entry_btn);

        en_sb_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String entry_d_id = en_id.getText().toString();
                String entry_d_date = en_date.getText().toString();
                String entry_d_time = en_time.getText().toString();
                String entry_d_ltr = en_ltr.getText().toString();
                String entry_d_fat = en_fat.getText().toString();
                String entry_d_deg = en_deg.getText().toString();
                String entry_d_price = en_price.getText().toString();
                if (entry_d_id.isEmpty() || entry_d_date.isEmpty() || entry_d_time.isEmpty() || entry_d_ltr.isEmpty() || entry_d_fat.isEmpty() || entry_d_deg.isEmpty() || entry_d_price.isEmpty()) {
                    Toast.makeText(getContext(), "Please fill in all details", Toast.LENGTH_SHORT).show();
                }  else {
                    // Assuming Database class handles data storage correctly
                    Database db = new Database(getContext(), "digital_dairy_app", null, 1);
                    db.daily_entry_data(entry_d_id, entry_d_date, entry_d_time, entry_d_ltr, entry_d_fat, entry_d_deg, entry_d_price);
                    Toast.makeText(getContext(), "Record inserted", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getActivity(), admin.class));
                }
            }
        });

        return rootView;
    }

}