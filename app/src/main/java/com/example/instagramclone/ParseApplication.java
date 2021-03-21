package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("q26kMm6kW6ufThox6JSHwGvK4XAquQfAoAs5t7dS")
                .clientKey("Rt5SJFSqeFoGrF54boboFzOq4wwwiAY3gkKHjCtW")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
