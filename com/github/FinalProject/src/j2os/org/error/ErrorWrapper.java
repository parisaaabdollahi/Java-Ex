package j2os.org.error;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ErrorWrapper {
    public static Map<String,String> getErrorMessage(Exception e){
Map<String,String> map=new HashMap<>();
e.printStackTrace();
if (e instanceof SQLException){
map.put("CODE","101");
map.put("MESSAGE","DATABASE ERROR");
} else if (e instanceof IOException){
    map.put("CODE","102");
    map.put("MESSAGE","READ/WRITE ERROR");
    }
else if (e instanceof InputVallidationException){
    map.put("CODE","103");
    map.put("MESSAGE","CHECK YOUR INPUT");
}
return map;
}

    }

