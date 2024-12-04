package org.grp5.thetask;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class is for methods that solves, calculates or changes something and returns it.
 * It's a class for methods that can be used anywhere.
 */
public class Helper {

    // converter for deadline time
    public static long convertToMilliSeconds(String deadline) {
        if (deadline == null || deadline.isEmpty()) {
            return -1; // set -1 to return no dealine fooling the standard
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
            Date date = sdf.parse(deadline);
            return date.getTime();
        } catch (Exception e) {
            return -1; // if we get error default to no deadline
        }
    }
}
