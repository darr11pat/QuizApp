package edu.niu.cs.z1779946.quiz240;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import java.util.ArrayList;

/**
 * Created by DARSHAN on 4/30/2017.
 */

public class DatabaseManager extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "quizDB";
    private static final int DATABASE_VERSION = 3;

    private static final String TABLE_QUIZ = "quizQ",
                                ID = "id",
                                QUIZNO = "quizno",
                                QUESTION = "question",
                                OPTIONS = "options",
                                ANSWER = "answer";
    //user's table
    private static final String USER_TABLE = "user_table",
                                UID = "ID",
                                UName = "fullname",
                                UEmail = "email",
                                UuserName = "username",
                                UPassword = "password";

    //build SQL statement
    private String sqlCreate = "create table " + TABLE_QUIZ + " ( " + ID + " integer primary key autoincrement, " + QUIZNO + " integer, "
            + QUESTION + " text, " + OPTIONS + " text, " + ANSWER + " text )";

    private String CREATE_USER_TABLE = "create table " + USER_TABLE + " ( " + UID + " INTEGER PRIMARY KEY AUTOINCREMENT not null, "
            + UName + " TEXT, " + UEmail + " TEXT, " + UuserName + " TEXT, " + UPassword + " TEXT )";

    private String dropTable = "drop table if exists " + TABLE_QUIZ ;

    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + USER_TABLE;

    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }//end of constructor

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(sqlCreate);
    }//end of onCreate

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_USER_TABLE);
        db.execSQL(dropTable);

        onCreate(db);
    }// end of onUpgrade

    public void insert(Question question){
        SQLiteDatabase db = getWritableDatabase();

        String sqlInsert = "insert into " + TABLE_QUIZ + " values( null, '" + question.getQuizNo() + "', '" + question.getQuestion()
                + "', '" + question.getOptions() + "', '" + question.getAnswer() + "' )";

        db.execSQL(sqlInsert);
        db.close();
    }//end of insert

    public ArrayList<Question> selectAll(){
        String sqlSelectAll = "select * from " + TABLE_QUIZ;

        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(sqlSelectAll, null);
        ArrayList<Question> questions = new ArrayList<>();

        while (cursor.moveToNext()){
            Question currentQuestion = new Question(Integer.parseInt(cursor.getString(0)), Integer.parseInt(cursor.getString(1)), cursor.getString(2), cursor.getString(3), cursor.getString(4));
            questions.add(currentQuestion);
        }//end of while

        db.close();
        return questions;
    }//end of select all

    public ArrayList<Question> selectAllById(int id){
        String sqlSelectAll = "select * from " + TABLE_QUIZ + " where " + QUIZNO + " = " + id;

        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(sqlSelectAll, null);
        ArrayList<Question> questions = new ArrayList<>();

        while (cursor.moveToNext()){
            Question currentQuestion = new Question(Integer.parseInt(cursor.getString(0)), Integer.parseInt(cursor.getString(1)), cursor.getString(2), cursor.getString(3), cursor.getString(4));
            questions.add(currentQuestion);
        }//end of while

        db.close();
        return questions;
    }//end of select all

    /*public String checkAnswer(int questionID, int selectedOption){
        String sqlCheck = "select " + ANSWER + " from " + TABLE_QUIZ + " where " + ID + " = " + questionID;

        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.rawQuery(sqlCheck, null);
        String answer = cursor.getString(0);

        db.close();
        return answer;
    }*/

    //insert new user data
    public void U_insertData(NewUser newUser) {
        SQLiteDatabase db = this.getWritableDatabase();

        String sqlInsert = "Insert into " + USER_TABLE + " values( null, '" + newUser.getFullName() + "', '"
                + newUser.getEmail() + "', '" + newUser.getUserName() + "', '" + newUser.getPassword() + "' )";

        db.execSQL(sqlInsert);
        db.close();
    }

    public String U_checkUser(String uName){
        String sqlCheck = "select * from " + USER_TABLE + " where " + UuserName + " = " + uName;

        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor1 = db.query("USER_TABLE", null ,"UuserName=?", new String[]{uName}, null, null, null);

        if(cursor1.getCount() < 1){
            cursor1.close();
            return "NOT EXIST";
        }
        cursor1.moveToFirst();

        String passStr = cursor1.getString(cursor1.getColumnIndex("UPassword"));

        Log.d("PASSWORD = ", passStr);

        db.close();
        return passStr;
    }

}//end of class
