/*
   This program uses a public class ValidatePasswordFinal to get user input via the
   scanner class. The ValidatePasswordDraft calls the validatePass method that checks to see if the entered
   password is valid. The requirements for a valid password are as follows:
   		1) Password must be at least 8 characters long.
   		2) Password must contain one letter
   		3) Password must contain one number

   If the password is valid the result will display "The password is accepted." If not the result will
   display an appropriate error message.
   
   NOTES:
   The scanner class is being used rather than the regex due to the requirement of iteration 4 (multiple special characters).
   I am much less familiar with regex and am uncertain as to how to increase the required cspecial characters from 1 to 3.
   Drafts of all iterations are being created offline so that only complete iterations are uploaded to the GitHub repository.
   
   Running Requirements:
   All source code is self-contained within the one file.
   Classes used: 
    - ValidatePasswordFinal (source contained)
    - Scanner (imported within source code - standard library generally preinstalled)
    
    Running the Code:
    When running the source file user will be prompted to enter password, result will be returned and code will reinitialize for additional tests.
    All iteration tests have completed as expected.
    
   Author: Brandt H
*/

import java.util.Scanner;								// Import Scanner class
public class ValidatePasswordFinal {

	public static void main (String [] args) {

		String inputPassword;							// Declare Password variable

		Scanner input = new Scanner (System.in);				// Define Scanner

		System.out.print("Enter Your Password: ");						// Prompt for entry
		inputPassword = input.next();						// Read user input

		System.out.println(validatePass(inputPassword));				// Calls the PassCheck Method on the password entered by the user and prints result to screen
		System.out.println("");

		main(args);								// re-runs the program (Allows for multiple tests)

	}

	public static String validatePass (String Password) {

		String result = "Password is accepted";			// Sets the initial result as valid
		int length = 0;						// Variable to count the number characters in the password
		int numCount = 0;					// Variable to count numbers in the password
		int letterCount = 0;					// Variable to count capital letters in the password
		int minLength = 8;					// Variable to define minimum character length
		int minNum = 1;						// Variable to define minimum numbers in password
		int minLetter = 1;						// Variable to define minimum capital letters in password


		for (int x =0; x < Password.length(); x++) {
			if ((Password.charAt(x) >= 47 && Password.charAt(x) <= 58) || (Password.charAt(x) >= 64 && Password.charAt(x) <= 91) ||
				(Password.charAt(x) >= 97 && Password.charAt(x) <= 122)) {
					//Keep the Password
				} else {
					result = "Password is not accepted";		//Checks that password contains only letters and numbers
				}

			if ((Password.charAt(x) >= 47 && Password.charAt(x) <= 58)) {			// Counts the number of numbers
				numCount ++;
			}

			if ((Password.charAt(x) >= 64 && Password.charAt(x) <= 91) | (Password.charAt(x) >= 97 && Password.charAt(x) <= 122)) {			// Counts the number of capital letters
				letterCount ++;
			}

			length = (x + 1);								// Counts the password length

		} // Ends the for loop

		if (numCount < minNum){									// Validates quantity of numbers in password
			result = "Password is not accepted";
		}

		if (letterCount < minLetter) {									// Validates quantity of letters in password
			result = "Password is not accepted";
		}

		if (length < minLength){									// Validates quantity of characters password
			result = "Password is not accepted";
		}

			return (result);								// Returns the value of "result"

	} // Ends the PassCheck method
} // Ends the ValidatePassword class