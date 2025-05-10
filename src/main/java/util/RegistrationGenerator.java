package util;

import java.util.Random;
import java.time.Year;


public class RegistrationGenerator {
    public static int createRegistration() {
        int year = Year.now().getValue();
        int randomNumber = new Random().nextInt(100_000);
        return Integer.parseInt(year + String.format("%05d", randomNumber));
    }
}
