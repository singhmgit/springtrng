package com.tavant;

import com.tavant.training.boot.AssignUsername;
import org.junit.Test;

/**
 * Created on 26-08-2015.
 */
public class RunProgram {

    @Test
    public void runProgram() {
        AssignUsername boot = new AssignUsername();
        boot.assign("test1", "facebook");

        boot.assign("test1", "twitter");

        boot.assign("test1", "github");
    }

}
