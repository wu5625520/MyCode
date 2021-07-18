package testnewcode;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * @author wxy
 * @title: TestDate
 * @description: TODO
 * @date 2021/7/149:32
 */

public class TestDate {
    public static void main(String[] args){
//        Date date = new Date();
//        System.out.println(date);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
//        String format = simpleDateFormat.format(date);
//        System.out.println(format);

//        Calendar instance = Calendar.getInstance();
//
//        int i = instance.get(Calendar.DAY_OF_MONTH);
//        System.out.println(i);

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
    }
}
