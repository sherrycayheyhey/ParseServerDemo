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

import com.parse.FindCallback;
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
import com.parse.SignUpCallback;

import java.util.List;


public class MainActivity extends AppCompatActivity {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    /*
    //get all the Score objects (delete the first query line to do this)
    ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");

    //search for a specific username
    query.whereEqualTo("username", "Sherry");
    query.setLimit(1); //get only one result back

    query.findInBackground(new FindCallback<ParseObject>() {
      @Override
      public void done(List<ParseObject> objects, ParseException e) {
        if (e == null) {
          if (objects.size() > 0) {
            for(ParseObject object : objects) {
              Log.i("username", object.getString("username"));
              Log.i("score", object.getString("score"));
            }
          }
        }
      }
    });
    */

    /*//CHALLENGE: If the user has more than 50 points, add 20 to their score
    ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");

    //search for scores greater than 50
    query.whereGreaterThan("score", 50);

    query.findInBackground(new FindCallback<ParseObject>() {
      @Override
      public void done(List<ParseObject> objects, ParseException e) {
        if (e == null && objects != null) {
            for(ParseObject score : objects) {
              score.put("score", score.getInt("score") + 20);
              score.saveInBackground();
              //check that the score updated in Parse
            }
        }
      }
    });*/


    //****************************User Stuff****************************
    /*
    //creates the user
    ParseUser user = new ParseUser();
    user.setUsername("sherry");
    user.setPassword("password");

    user.signUpInBackground(new SignUpCallback() {
      @Override
      public void done(ParseException e) {
        if (e == null) {
          //everything was ok
          Log.i("sign up ok!", "we did it");
        } else {
          e.printStackTrace();
        }
      }
    });
    */

    /*
    //user login
    ParseUser.logInInBackground("sherry", "password", new LogInCallback() {
      @Override
      public void done(ParseUser user, ParseException e) {
        if (user != null) {
          Log.i("woohoo", "you logged in!");
        } else {
            e.printStackTrace();
        }
      }
    });
    */

    
    //when the app launches, see if there's a logged in user
    if (ParseUser.getCurrentUser() != null) {
      Log.i("signed in", ParseUser.getCurrentUser().getUsername());
    } else {
      //this is where you would want to show the login or signup functionality
      Log.i("didn't work", "not signed in");
    }

    //log out a user
    //ParseUser.logOut();

    //allows us to check how much a user is using the app
    ParseAnalytics.trackAppOpenedInBackground(getIntent());
  }

}