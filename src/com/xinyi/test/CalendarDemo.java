package com.xinyi.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author guxinxin
 */
public class CalendarDemo {


    public static void main(String[] args) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar endCalendar = Calendar.getInstance();
        String cycleEndTime= "2022-5-26";

        try {endCalendar.setTime(df.parse(cycleEndTime));

            System.out.println(endCalendar.get(Calendar.MONTH));
            System.out.println(endCalendar.get(Calendar.MONTH) % 4);
            if (endCalendar.get(Calendar.MONTH) % 4 == 0) {
                System.out.println(cycleEndTime);

            }

        }catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
