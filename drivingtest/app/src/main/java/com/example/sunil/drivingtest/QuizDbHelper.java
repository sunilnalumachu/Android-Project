package com.example.sunil.drivingtest;
/**
 * Created by Sunil on 7/12/2016.
 * I got the idea of start on this code by implementing dbhelpher online from parallelcode site but i changed the entire code//....
 *
 */
import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class QuizDbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "QuizTEST";
    private static final String TABLE_ANSWER = "quest";
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer";
    private static final String KEY_CHOA= "opta";
    private static final String KEY_CHOB= "optb";
    private static final String KEY_CHOC= "optc";
    private SQLiteDatabase dbase;
    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_ANSWER + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_CHOA +" TEXT, "
                +KEY_CHOB +" TEXT, "+KEY_CHOC+" TEXT)";
        db.execSQL(sql);
        addQuestions();
    }
    private void addQuestions()
    {
        Question q1=new Question("The driver of a motor vehicle may overtake and " +
                "pass to the right of another vehicle only when",
                "the vehicle overtaken is making or about to make a left turn",
                "the vehicle overtaken is making or about to make a right turn",
                "none of the above", "A");
        this.addQuestion(q1);
        Question q2=new Question("When approaching a roundabout" +
                " intersection, you must always","move in clockwise direction","enter from left",
                "yield to traffic in circle and pedestrains in crosswalks","C");
        this.addQuestion(q2);
        Question q3=new Question("Missouri motor vehicle law requires that __________ must wear seat belts if the driver i" +
                "s a holder of an intermediate driver's license.","the driver", "the driver and back passenger",
                "the driver and all passengers","C");
        this.addQuestion(q3);
        Question q4=new Question("When you see a stopping sign at a railroad crossing," +
                " you must stop _________ before the railroad tracks.",    "within 15 to 50 feet", "within 5 to 50 feet",
                "within 15 to 40 feet","A");
        this.addQuestion(q4);
        Question q5=new Question("When following a vehicle at night, " +
                "you should use your low-beams","within 500 feet of vehicle ahead","within 500 feet of vehicle ahead",
                "within 300 feet of vehicle ahead","C");
        this.addQuestion(q5);
        Question q6=new Question("The ________ represent danger areas around trucks " +
                "where collisions are more likely to occur.","stopzones","zerozones",
                "nozones","C");
        this.addQuestion(q6);
        Question q7=new Question("When approaching a roundabout" +
                " intersection, you must always","move in clockwise direction","enter from left",
                "yield to traffic in circle and pedestrains in crosswalks","C");
        this.addQuestion(q7);
        Question q8=new Question("When you reach a marked or unmarked " +
                "crossing, you must yield and watch for", "heavy vehicles",
                "pedestrian", "trucks", "B");
        this.addQuestion(q8);
        Question q9=new Question("When passing another vehicle, get through the other" +
                " driver's blind spot as quickly as you can","by increasing your speed","by changing gears",
                "without exceeding the speed limit","C");
        this.addQuestion(q9);
        Question q10=new Question("The first step in Missouri's " +
                "Graduated Driver License program for young drivers is?","issuing a primary licence ","issuing instrumental permit",
                "issuing full driving licence","B");
        this.addQuestion(q10);
        Question q11=new Question("What should you do before leaving your " +
                "vehicle parked on a downhill slope parallel to the curb?","turn wheels to left","keep wheels parallel to curb",
                "turn wheels to right","C");
        this.addQuestion(q11);
        Question q12=new Question("A vehicle's stopping distance is equal to?","the sum of braking system and reaction distance",
                "the braking distance",
                "the sum of following distance","A");
        this.addQuestion(q12);
        Question q13=new Question("If your vehicle starts to hydroplane, you should?","hit brakes",
                "press down on your accelator",
                "slow down gradually","C");
        this.addQuestion(q13);
        Question q14=new Question("You should use your turn signals well in advance " +
                "at least __________ before you actually make a turn.?","100 feet",
                "50 feet",
                "25 feet","A");
        this.addQuestion(q14);
        Question q15=new Question("When entering a highway, " +
                "you must use the entrance ramp and __________ to increase your speed to" +
                " match the speed of the other vehicles on the highway.?","accelaration lane",
                "shoulder lane",
                "decelaration lane","A");
        this.addQuestion(q15);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ANSWER);
        onCreate(db);
    }
    public void addQuestion(Question quest) {
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_CHOA, quest.getOPTA());
        values.put(KEY_CHOB, quest.getOPTB());
        values.put(KEY_CHOC, quest.getOPTC());
        dbase.insert(TABLE_ANSWER, null, values);
    }
    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        String selectQuery = "SELECT  * FROM " + TABLE_ANSWER;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        return quesList;
    }
    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_ANSWER;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
}
