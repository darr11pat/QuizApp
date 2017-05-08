package edu.niu.cs.z1779946.quiz240;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import java.util.ArrayList;

/**
 * Created by DARSHAN on 4/30/2017.
 */

public class DatabaseManager extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "quizDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_QUIZ = "quizQ",
                                ID = "id",
                                QUIZNO = "quizno",
                                QUESTION = "question",
                                OPTIONS = "options",
                                ANSWER = "answer";


    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }//end of constructor

    @Override
    public void onCreate(SQLiteDatabase db) {
        //build SQL statement
        String sqlCreate = "create table " + TABLE_QUIZ + " ( " + ID + " integer primary key autoincrement, " + QUIZNO + " integer, "
                            + QUESTION + " text, " + OPTIONS + " text, " + ANSWER + " text )";
        db.execSQL(sqlCreate);
    }//end of onCreate

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropTable = "drop table if exists " + TABLE_QUIZ ;
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

    public String checkAnswer(int questionID, int selectedOption){
        String sqlCheck = "select " + ANSWER + " from " + TABLE_QUIZ + " where " + ID + " = " + questionID;

        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.rawQuery(sqlCheck, null);

        return cursor.getString(0);
    }

}//end of class
