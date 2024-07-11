package Basics.TimeZone;

// https://mkyong.com/java/java-display-list-of-timezone-with-gmt/

import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class demo1 {

  public static void main(String[] args) {

    String[] ids = TimeZone.getAvailableIDs();
      Set<String> hash_Set = new HashSet<String>();

    for (String id : ids) {

      String name = getTZName(TimeZone.getTimeZone(id));

      // if (!hash_Set.contains(name) && !name.contains("GMT")){
      if (true) {
        String res = displayTimeZone(TimeZone.getTimeZone(id));
        System.out.println(displayTimeZone(TimeZone.getTimeZone(id)));
        hash_Set.add(name);
      }
    }

    System.out.println("\nTotal TimeZone ID " + ids.length);
  }

  public static String getTZName(TimeZone tz) {
    return tz.getDisplayName().replaceAll("\\s+", "_").replaceAll("-", "_");
  }

  private static String displayTimeZone(TimeZone tz) {

    long hours = TimeUnit.MILLISECONDS.toHours(tz.getRawOffset());

    String result = "";
    if (hours > 0) {
      // result = String.format("(GMT+%d:%02d) %s", hours, minutes, tz.getID());
      // result = String.format("GMT+%d -> %s %s", hours, tz.getID(),
      // tz.getDisplayName().replaceAll("\\s+","_"));
      //            result = String.format("%s  (\"%s\", \"GMT+%d\") ,",
      //                    tz.getDisplayName().replaceAll("\\s+","_").replaceAll("-",
      // "_").replaceAll("&", "_"),
      //                    tz.getID(),
      //                    hours);
      result =
          String.format(
              "%s  (\"%s\", \"GMT+%d\") ,",
              tz.getID()
                  .replaceAll("/", "_")
                  .replaceAll("-", "_")
                  .replaceAll("&", "_")
                  .toUpperCase(),
              tz.getID(),
              hours);

    } else {
      // result = String.format("(GMT%d:%02d) %s", hours, minutes, tz.getID());
      // result = String.format("GMT+%d -> %s %s", hours, tz.getID(),
      // tz.getDisplayName().replaceAll("\\s+","_"));
      //            result = String.format("%s  (\"%s\", \"GMT+%d\") ,",
      //                    tz.getDisplayName().replaceAll("\\s+","_").replaceAll("-",
      // "_").replaceAll("&", "_"),
      //                    tz.getID(),
      //                    hours);
      result =
          String.format(
              "%s  (\"%s\", \"GMT+%d\") ,",
              tz.getID()
                  .replaceAll("/", "_")
                  .replaceAll("-", "_")
                  .replaceAll("&", "_")
                  .toUpperCase(),
              tz.getID(),
              hours);
    }

    // NOTE : fix "UTC+-3" to "UTC-3"
    return result.replaceAll("\\+-", "-");
  }
}
