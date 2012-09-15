package org.trafficlights.domain;

import static java.util.Arrays.*;
import static org.junit.Assert.*;
import static org.trafficlights.domain.LightState.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CrossingValidatorTest {

    @Parameters
    public static List<Object[]> values() {
        return asList(new Object[][] {
                {RED,GREEN,true},
                {RED,RED,true},
                {RED,RED_YELLOW,true},
                {RED,UNKNOWN,false},
                {RED,YELLOW,true},

                {GREEN,GREEN,false},
                {GREEN,RED,true},
                {GREEN,RED_YELLOW,false},
                {GREEN,UNKNOWN,false},
                {GREEN,YELLOW,false},

                {RED_YELLOW,GREEN,false},
                {RED_YELLOW,RED,true},
                {RED_YELLOW,RED_YELLOW,false},
                {RED_YELLOW,UNKNOWN,false},
                {RED_YELLOW,YELLOW,false},

                {UNKNOWN,GREEN,false},
                {UNKNOWN,RED,false},
                {UNKNOWN,RED_YELLOW,false},
                {UNKNOWN,UNKNOWN,false},
                {UNKNOWN,YELLOW,false},

                {YELLOW,GREEN,false},
                {YELLOW,RED,true},
                {YELLOW,RED_YELLOW,false},
                {YELLOW,UNKNOWN,false},
                {YELLOW,YELLOW,false},
        });
    }

    private static LightState firstState;
    private static LightState secondState;
    private boolean valid;

    public CrossingValidatorTest(LightState firstState, LightState secondState, boolean valid) {
        this.firstState = firstState;
        this.secondState = secondState;
        this.valid = valid;
    }

    @Test
    public void isValidConfiguration() {
        assertEquals(valid,new CrossingValidator().isValidConfiguration(firstState,secondState));
    }
}