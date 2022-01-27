package example.com.prueba2_pablo_alvear;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
public class GuessButtonListener_PAAV implements OnClickListener {
    private MainActivityFragment_PAAV mainActivityFragmentPAAV;
    private Handler handler;
    public GuessButtonListener_PAAV(MainActivityFragment_PAAV mainActivityFragmentPAAV) {
        this.mainActivityFragmentPAAV = mainActivityFragmentPAAV;
        this.handler = new Handler();
    }
    @Override
    public void onClick(View v) {
        Button guessButton = ((Button) v);
        String guess = guessButton.getText().toString();
        String answer = this.mainActivityFragmentPAAV.getQuizViewModelPAAV().getCorrectCountryName();
        this.mainActivityFragmentPAAV.getQuizViewModelPAAV().setTotalGuesses(1);

        if (guess.equals(answer)) {
            this.mainActivityFragmentPAAV.getQuizViewModelPAAV().setCorrectAnswers(1);
            this.mainActivityFragmentPAAV.getAnswerTextView().setText(answer + "!");
            this.mainActivityFragmentPAAV.getAnswerTextView().setTextColor(
                    this.mainActivityFragmentPAAV.getResources().getColor(R.color.correct_answer));

            this.mainActivityFragmentPAAV.disableButtons();

            if (this.mainActivityFragmentPAAV.getQuizViewModelPAAV().getCorrectAnswers()
                    == QuizViewModel_PAAV.getFlagsInQuiz()) {
                ResultsDialogFragment_PAAV quizResults = new ResultsDialogFragment_PAAV();
                quizResults.setCancelable(false);
                try {
                    quizResults.show(mainActivityFragmentPAAV.getChildFragmentManager(), "Quiz Results");
                } catch (NullPointerException e) {
                    Log.e(QuizViewModel_PAAV.getTag(),
                            "GuessButtonListener: this.mainActivityFragment.getFragmentManager() " +
                                    "returned null",
                            e);
                }
            } else {
                this.handler.postDelayed(
                        new Runnable() {
                            @Override
                            public void run() {
                                mainActivityFragmentPAAV.animate(true);
                            }
                        }, 2000);
            }
        } else {
            this.mainActivityFragmentPAAV.incorrectAnswerAnimation();
            guessButton.setEnabled(false);
        }
    }
}
