package example.com.prueba2_pablo_alvear;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import androidx.annotation.Nullable;

public class SettingsActivityFragment_PAAV extends PreferenceFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}