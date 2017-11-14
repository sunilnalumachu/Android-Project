package com.example.sunil.drivingtest;
import java.util.List;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
public class QuizDifficultActivity extends Activity {
    List<Question> quesList;
    int score=0;
    int qid=10;
    Question currentQ;
    TextView txtQuestion;
    RadioButton rada, radb, radc;
    Button btNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        QuizDbHelper db=new QuizDbHelper(this);
        quesList=db.getAllQuestions();
        currentQ=quesList.get(qid);
        txtQuestion=(TextView)findViewById(R.id.textView1);
        rada=(RadioButton)findViewById(R.id.radio0);
        radb=(RadioButton)findViewById(R.id.radio1);
        radc=(RadioButton)findViewById(R.id.radio2);
        btNext=(Button)findViewById(R.id.button1);
        setQuestionView();
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ans;
                if(rada.isChecked()) ans = "A";
                else if (radb.isChecked()) ans = "B";
                else ans = "C";
                Log.d("QUIZ222", "Correct answer is [" + currentQ.getANSWER() + "], your answer was: ["
                        + ans + "]");
                if(currentQ.getANSWER().equals(ans))
                {
                    score++;
                    Log.d("score", "Your score"+score);
                }
                if(qid<15){
                    currentQ=quesList.get(qid);
                    setQuestionView();
                }else{
                    Intent intent = new Intent(QuizDifficultActivity.this, ResultActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("score", score);
                    intent.putExtras(b);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_quiz, menu);
        return true;
    }
    private void setQuestionView()
    {
        txtQuestion.setText(currentQ.getQUESTION());
        rada.setText(currentQ.getOPTA());
        radb.setText(currentQ.getOPTB());
        radc.setText(currentQ.getOPTC());
        qid++;
    }
}
