package HomeWork2;

import java.time.LocalDate;

public class DateUtility {
    public static void main(String[] args) {
        getDate();
    }

    public static String getDate(){
        String month = LocalDate.now().getMonth().name();
        System.out.println(month);

        int day = LocalDate.now().getDayOfMonth();
        int year = LocalDate.now().getYear();

        String date = month+":"+day+":"+year;
        return date;
    }
}
