package top.viewv.test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class DateTest {
    public static void main(String args[]){
        java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
        String x = currentDate.toString();
        System.out.println(x);

        Calendar calendar =new GregorianCalendar();
        calendar.setTime(currentDate);
        calendar.add(calendar.DATE, -7);
        java.util.Date utilDate = calendar.getTime();
        System.out.println(utilDate);
        Date newDate = new java.sql.Date(utilDate.getTime());
        System.out.println(newDate);

    }
}
