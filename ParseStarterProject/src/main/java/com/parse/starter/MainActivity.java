/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Switch;

import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;


public class MainActivity extends AppCompatActivity {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    /*
    //make a new object and have it stored inside of parse
    //first create a class (role, user, example object, etc.), kind of like in SQL when you make a table

    //all classes in parse need to be uppercase!
    ParseObject score = new ParseObject("Score");
    //take the score object and add some properties onto it, these are like the rows in a SQL table
    score.put("username", "Sherry");
    score.put("score", 1000);
    //save this score object to Parse
    //normal save() would pause until it saves so saveInBackground is better and this has a callback
    score.saveInBackground(new SaveCallback() {
      @Override
      public void done(ParseException e) {
        if (e == null) {
          //everything is ok
          Log.i("Success", "We saved the score!");
        } else {
          e.printStackTrace();
        }
      }
    });
    */

    //get things from Parse server
    ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");
    //use the objectID from the server to get the object
    query.getInBackground("ykY648cnFy", new GetCallback<ParseObject>() {
      @Override
      public void done(ParseObject object, ParseException e) {
        if (e == null && object != null) {

          //update the score
          object.put("score", "1000000"); //should be 1000000 (int) but I messed up
          object.saveInBackground();

          Log.i("username", object.getString("username"));
          // use this line to get the score when the score is actually submitted as an int
          // Log.i("score", Integer.toString(object.getInt("score")));
          Log.i("score", object.getString("score"));
        }
      }
    });

    //CHALLENGE: create a Tweet class, create username and tweet message, save it to parse, query it, update the tweet
    //create a Tweet class
    ParseObject tweet = new ParseObject("Tweet");

    //create usermane and tweet message
    tweet.put("username", "Aaron");
    tweet.put("tweet", "I like D&D.");


    //save it to Parse
    tweet.saveInBackground(new SaveCallback() {
      @Override
      public void done(ParseException e) {
        if (e == null) {
          //everything is ok
          Log.i("Success", "We saved whatever you were trying to save!");
        } else {
          e.printStackTrace();
        }
      }
    });

    //get things from Parse server
    ParseQuery<ParseObject> myQuery = ParseQuery.getQuery("Tweet");
    //use the objectID from the server to get the object
    myQuery.getInBackground("oJvhaHyDWc", new GetCallback<ParseObject>() {
      @Override
      public void done(ParseObject object, ParseException e) {
        if (e == null && object != null) {

          //update the tweet
          object.put("tweet", "I like Aaron <3.");
          object.saveInBackground();

          //query the tweet
          Log.i("username", object.getString("username"));
          Log.i("tweet", object.getString("tweet"));
        }
      }
    });

    //allows us to check how much a user is using the app
    ParseAnalytics.trackAppOpenedInBackground(getIntent());
  }

}