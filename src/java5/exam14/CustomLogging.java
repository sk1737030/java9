package java5.exam14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Filter;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomLogging implements Filter {

    private List<String> strs;

    public CustomLogging(String... strs) {
        this.strs = Arrays.asList(strs);
    }

    @Override
    public boolean isLoggable(LogRecord record) {
        for(String str : strs) {
            if(record.getMessage().contains(str))
                return false;
        }
        return true;
    }


}
