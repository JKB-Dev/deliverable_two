import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Date_Difference {

	public static void main(String[] args) {
		System.out.println("Enter a date in YYYY-MM-DD format:");
		Scanner scnr = new Scanner(System.in);
		//get first date from user
		CharSequence inputDate1 = scnr.nextLine();
		//send user input to parseDate method
		parseDate(inputDate1);
		//store parsed date as a LocalDate
		LocalDate input1 = LocalDate.parse(inputDate1);
		System.out.println("Enter another date in YYYY-MM-DD format:");
		//get second date from user
		CharSequence inputDate2 = scnr.nextLine();
		//send user input to parseDate method (tried to avoid this repetition!)
		parseDate(inputDate2);
		//store parsed date as a LocalDate
		LocalDate input2 = LocalDate.parse(inputDate2);
		scnr.close();
		//send both parsed dates to the calculateDifference method
		calculateDifference(input1, input2);
	}

	public static void parseDate(CharSequence inputDate) {
		try {
			//verify that user input is a date in the required format
			LocalDate.parse(inputDate);
		} catch (DateTimeParseException exp) {
			//terminate program if either input is not in the required format
			System.out.println("You entered an invalid date, try again.");
			System.exit(0);
		}
	}

	public static Period calculateDifference(LocalDate input1, LocalDate input2) {
		//user Period object to determine the difference between input dates
		Period inBetween = Period.between(input1, input2);
		System.out.println("The difference between " + input1 + " and " + input2 + " is " + inBetween.getYears()
				+ " years, " + inBetween.getMonths() + " months, and " + inBetween.getDays() + " days.");
		return inBetween;
	}
}