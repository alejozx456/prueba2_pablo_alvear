package example.com.prueba2_pablo_alvear;
import android.os.Bundle;

import android.app.Dialog;
import android.app.AlertDialog;
import android.content.DialogInterface;


import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import android.util.Log;
public class ResultsDialogFragment_PAAV extends DialogFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final QuizViewModel_PAAV quizViewModelPAAV = ViewModelProviders.of((FragmentActivity) getActivity()).get(QuizViewModel_PAAV.class);
        int totalGuesses = quizViewModelPAAV.getTotalGuesses();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(
                getString(R.string.results, totalGuesses, (1000 / (double) totalGuesses)));

        builder.setPositiveButton(R.string.reset_quiz, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try{
                    MainActivityFragment_PAAV quizFragment = (MainActivityFragment_PAAV) getParentFragment();
                    try{
                        quizFragment.resetQuiz();
                    }catch (Exception e){
                        Log.e(quizViewModelPAAV.getTag(),"Unable to call resetQuiz()", e);
                    }
                }
                catch (Exception e){
                    Log.e(quizViewModelPAAV.getTag(),"Unable to get ActivityMainFragment", e);
                }
            }
        });
        return builder.create();
    }
}
