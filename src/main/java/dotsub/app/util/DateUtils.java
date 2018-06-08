package dotsub.app.util;

import java.text.SimpleDateFormat;
import java.nio.file.attribute.FileTime;

public class DateUtils {

  public final static String FORMAT_MM_DD_YYYY = "MM/dd/yyyy";

  public final static String FORMAT_MM_DD_YYYY_HH_MM_SS ="MM/dd/yyyy HH:mm:ss";

  public static String parseFileTime(FileTime date, String format) {

      if (date == null ) {
        return "";
      }

      if (format == null) {
        return "";
      }

      SimpleDateFormat df = new SimpleDateFormat(format);
      String dateParse = df.format(date.toMillis());
      return dateParse;
  }

}
