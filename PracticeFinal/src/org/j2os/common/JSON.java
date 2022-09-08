package org.j2os.common;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JSON {
    public static String getString(Object object) {
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(object);
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
