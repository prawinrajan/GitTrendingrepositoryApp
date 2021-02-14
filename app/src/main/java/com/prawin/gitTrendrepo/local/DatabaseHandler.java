package com.prawin.gitTrendrepo.local;


import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import  com.prawin.gitTrendrepo.api.Hero;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "GitTrendsLocal";
    private static final String TABLE_GIT = "gitTrend";
    private static final String author = "author";
    private static final String avatar = "avatar";
    private static final String url = "url";
    private static final String description = "description";
    private static final String language = "language";
    private static final String languageColor = "languageColor";
    private static final String stars = "stars";
    private static final String forks = "forks";
    private static final String currentperiodstars = "currentperiodstars";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_GIT + "(" + author
                + " TEXT," + avatar + " TEXT," + url + " TEXT," +  description + "TEXT,"+
                language + "TEXT, "+ languageColor+ " TEXT," + stars +"TEXT,"+ forks +"TEXT,"+currentperiodstars +"TEXT"+")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GIT);

        // Create tables again
        onCreate(db);
    }

    // code to add the new contact
    void addIntoDatabase(Hero hero) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(author, hero.getAuthor());
        values.put(avatar, hero.getAvatar());
        values.put(url, hero.getUrl());
        values.put(description, hero.getDescription());
        values.put(language, hero.getLanguage());
        values.put(languageColor, hero.getLanguageColor());
        values.put(stars, hero.getStars());
        values.put(forks, hero.getForks());
        values.put(currentperiodstars, hero.getCurrentperiodstars());

        // Inserting Row
        db.insert(TABLE_GIT, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    // code to get the single contact
    public Hero getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_GIT, new String[] { author,
                        avatar, url, description,language,languageColor,stars,forks,currentperiodstars}, language + "=?",
                new String[] { language }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        assert cursor != null;
        // return contact
        return new Hero(cursor.getString(0), cursor.getString(1), cursor.getString(2),cursor.getString(3), cursor.getString(4), cursor.getString(5),cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9));
    }

    // code to get all contacts in a list view
    public List<Hero> getAllData() {
        List<Hero> heroList = new ArrayList<Hero>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_GIT;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Hero hero = new Hero();
                hero.setAuthor(cursor.getString(0));
                hero.setAvatar(cursor.getString(1));
                hero.setUrl(cursor.getString(2));
                hero.setDescription(cursor.getString(3));
                hero.setLanguage(cursor.getString(4));
                hero.setLanguageColor(cursor.getString(5));
                hero.setStars(cursor.getString(6));
                hero.setForks(cursor.getString(7));
                hero.setCurrentperiodstars(cursor.getString(8));

                // Adding contact to list
                heroList.add(hero);
            } while (cursor.moveToNext());
        }

        // return contact list
        return heroList;
    }



    // Deleting single contact
    public void deleteGit(Hero hero) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_GIT, language + " = ?", new String[] { hero.getAuthor()});
        db.close();
    }

    // Getting contacts Count
    public int getContactsCount() {

        String countQuery = "SELECT  * FROM " + TABLE_GIT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);


        // return count
        return cursor.getCount();
        //cursor.close();
    }


    public void addIntoDatabase(String author, String name, String avatar, String url, String description, String language, String languageColor, String stars, String forks, String currentperiodstars) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(author, author);
        values.put(avatar, name);
        values.put(url, url);
        values.put(description, description);
        values.put(language,language );
        values.put(languageColor, languageColor);
        values.put(stars, stars);
        values.put(forks, forks);
        values.put(currentperiodstars, currentperiodstars);

        // Inserting Row
        db.insert(TABLE_GIT, null, values);
        Log.i("statusDetailsDB","completed 200 OK");
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }
}