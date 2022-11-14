package Utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;



public class DateTimeUtils {
    public static boolean compareDates(String CreatedDate, String UpdatedDate) throws ParseException {
        boolean flag = false;
        DateFormat df = new SimpleDateFormat("hh:mm:ss" );
        Date createDate = df.parse(CreatedDate);
        Date updateDate = df.parse(UpdatedDate);
        System.out.println("created date: "+createDate+" | updated date: "+updateDate);
        System.out.println(updateDate.compareTo(createDate));
        if(updateDate.compareTo(createDate) > 0)/*new DateTime(updateDate).getValue() > new DateTime(createDate).getValue())*/
            flag = true;
        return flag;
    }
    public static boolean verifyDateFormat(String date) throws ParseException {
        boolean flag = false;
        System.out.println(date);
        String datePattern = "^(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])-((19|2\\d)\\d\\d)\\s(0\\d|1\\d|2[0-3]):([0-5]\\d):([0-5]\\d)$";
        if(Pattern.matches(datePattern,date))
            flag = true;
        return flag;
    }

}