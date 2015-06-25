package ds.project4task3;

import java.util.Calendar;
import java.util.Date;

/**
 * The AgeModel class contains and calculates age of a person.
 *
 * @author Karinya
 */
public class AgeModel {

    private int year;

    /**
     * Constructor of AgeModel class sets age in year from date of birth that
     * pass as argument.
     *
     * @param dateOfBirth
     */
    public AgeModel(Calendar dateOfBirth) {
        Calendar now = Calendar.getInstance();
        if (dateOfBirth.after(now)) {
            throw new IllegalArgumentException("Can't be born in the future");
        }
        //calculate age
        int year1 = now.get(Calendar.YEAR);
        int year2 = dateOfBirth.get(Calendar.YEAR);
        int age = year1 - year2;
        int month1 = now.get(Calendar.MONTH);
        int month2 = dateOfBirth.get(Calendar.MONTH);
        if (month2 > month1) {
            age--;
        } else if (month1 == month2) {
            int day1 = now.get(Calendar.DAY_OF_MONTH);
            int day2 = dateOfBirth.get(Calendar.DAY_OF_MONTH);
            if (day2 > day1) {
                age--;
            }
        }
        year = age;
    }

    /**
     * The method returns age value of a person.
     *
     * @return
     */
    public int getAge() {
        return year;
    }
}
