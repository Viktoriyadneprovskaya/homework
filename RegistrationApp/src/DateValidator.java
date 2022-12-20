import java.util.Arrays;

public class DateValidator {
    String date;
    int day;
    int month;
    int year;

    DateValidator(String date) {
        day = Integer.parseInt(date.substring(0,2));
        month = Integer.parseInt(date.substring(3,5));
        year = Integer.parseInt(date.substring(6,10));
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public boolean validateMonth() {
        if (this.day == 31) {
            return Arrays.asList(new int[]{1, 3, 5, 7, 8, 10, 12}).contains(this.month);
        }
        return true;
    }

    public boolean validateYear() {
        if (this.month == 2) {
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    if (year % 400 == 0) {
                        // Виcokocный гoд
                        return (day <= 29);
                    }
                    // Нeвиcokocный гoд
                    return (day <= 28);
                }
                return (day <= 29);
            } else {
            // Нeвыcokocный гoд
            return (day <= 28);
            }
        }
        return true;
    }
}
