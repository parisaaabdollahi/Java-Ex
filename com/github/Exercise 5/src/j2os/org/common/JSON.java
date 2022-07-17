package j2os.org.common;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JSON {
    public static String getString(Object o) {
        ObjectMapper objectMapper = new ObjectMapper();
try{
return objectMapper.writeValueAsString(o);
}
catch (IOException e){
throw new RuntimeException(e);
}
    }
}
