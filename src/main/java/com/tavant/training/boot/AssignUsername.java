package com.tavant.training.boot;

import com.tavant.training.db.DBConnection;
import com.tavant.training.generator.FacebookGenerator;
import com.tavant.training.generator.GithubGenerator;
import com.tavant.training.generator.TwitterGenerator;

/**
 * Created on 26-08-2015.
 */
public class AssignUsername {
    public String assign(String username, String source) {
        AssignUsername boot = new AssignUsername();
        if ("facebook".equals(source)) {
            FacebookGenerator gen = new FacebookGenerator();
            String name = gen.name(username);
            boot.updateUser(1, name);
        } else if ("twitter".equals(source)) {
            TwitterGenerator gen = new TwitterGenerator();
            String name = gen.name(username);
            boot.updateUser(1, name);
        } else if ("github".equals(source)) {
            GithubGenerator gen = new GithubGenerator();
            String name = gen.name(username);
            boot.updateUser(1, name);
        }
        return boot.getUser(1);
    }

    private String getUser(Integer userId) {
        DBConnection db = new DBConnection("localhost");
        return db.getName(userId);
    }

    private void updateUser(Integer userId, String name) {
        DBConnection db = new DBConnection("localhost");
        db.updateRecord(userId, name);
    }
}
