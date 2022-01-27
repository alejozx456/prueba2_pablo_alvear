package example.com.prueba2_pablo_alvear;


import android.content.SharedPreferences;
import android.widget.Toast;

import java.util.Set;

public class PreferenceChangeListener_PAAV implements SharedPreferences.OnSharedPreferenceChangeListener {
    private MainActivity_PAAV mainActivityPAAV;
    public PreferenceChangeListener_PAAV(MainActivity_PAAV mainActivityPAAV) {
        this.mainActivityPAAV = mainActivityPAAV;
    }
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        this.mainActivityPAAV.setPreferencesChanged(true);

        if (key.equals(this.mainActivityPAAV.getREGIONS())) {
            this.mainActivityPAAV.getQuizViewModelPAAV().setGuessRows(sharedPreferences.getString(
                    MainActivity_PAAV.CHOICES, null));
            this.mainActivityPAAV.getQuizFragment().resetQuiz();
        } else if (key.equals(this.mainActivityPAAV.getCHOICES())) {
            Set<String> regions = sharedPreferences.getStringSet(this.mainActivityPAAV.getREGIONS(),
                    null);
            if (regions != null && regions.size() > 0) {
                this.mainActivityPAAV.getQuizViewModelPAAV().setRegionsSet(regions);
                this.mainActivityPAAV.getQuizFragment().resetQuiz();
            } else {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                regions.add(this.mainActivityPAAV.getString(R.string.default_region));
                editor.putStringSet(this.mainActivityPAAV.getREGIONS(), regions);
                editor.apply();
                Toast.makeText(this.mainActivityPAAV, R.string.default_region_message,
                        Toast.LENGTH_LONG).show();
            }
        }

        Toast.makeText(this.mainActivityPAAV, R.string.restarting_quiz,
                Toast.LENGTH_SHORT).show();
    }
}
