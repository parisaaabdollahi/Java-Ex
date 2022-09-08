package org.j2os.common;

import org.j2os.Exception.InputValidatorException;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ErrorWrapper {
    public static Map<String, String> getError(Exception e) {
        Map<String, String> map = new HashMap<>();
        e.printStackTrace();
        if (e instanceof SQLException) {
            map.put("CODE", "101");
            map.put("MESSAGE", "DATABASE ERROR");
        } else if (e instanceof InputValidatorException) {
            map.put("CODE", "102");
            map.put("MESSAGE", "CHECK PARAMETER");
        } else {
            map.put("CODE", "200");
            map.put("MESSAGE", "CONNECT TO SUPORT");
        }
        return map;
    }
}
