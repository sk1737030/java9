package java5.exam15;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {

    @Override
    public String getHead(Handler h) {
        String header = "<html>";
        header += "<!DOCTYPE html>";
        header += "<head><meta charset=\"UTF-8\"></head>";
        header += "<body>";

        header += "<table border=\"1\">";
        header += "<tr>";
        header += "<th>level</th>";
        header += "<th>time</th>";
        header += "<th>message</th>";
        header += "</tr>";
        return header;
    }

    @Override
    public String format(LogRecord record) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<tr>");
        stringBuilder.append("<td> ");
        stringBuilder.append(record.getLoggerName());
        stringBuilder.append("</td>");
        stringBuilder.append("<td>");
        stringBuilder.append(new Date(record.getMillis()));
        stringBuilder.append("</td>");
        stringBuilder.append("<td>");
        stringBuilder.append(record.getMessage());
        stringBuilder.append("</td>");

        return stringBuilder.toString();
    }

    @Override
    public String getTail(Handler h) {
        return "</table></body></html>";
    }


}
