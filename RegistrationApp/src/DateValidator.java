import java.util.Arrays;

public class DateValidator {
    String date;
    int day;
    int month;
    int year;

    DateValidator(String date) {
        day = Integer.parseInt(date.substring(1, 2));
        month = Integer.parseInt(date.substring(4, 2));
        year = Integer.parseInt(date.substring(6, 4));
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
                        // Выcokocный гoд
                        return day <= 29;
                    }
                    // Нeвыcokocный гoд
                    return day <= 28;
                }

            }
        }
        return true;
    }
}
