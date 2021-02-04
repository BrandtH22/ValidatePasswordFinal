/*
 
 	Change Notes:
 	Iteration 3 requires that the account type first be validated (normal vs admin), 
 	the password requirements be based on the account type, and the changes for iteration 2
 	are retained. Added additional if statements for validating special characters.
 	Added if statement to output Password is valid rather than confirming properties of password.
 	 
 	Iteration 2 requires that invalid passwords return reasoning for being invalid, 
 	to achieve this the results listings within each validation have been updated.
 
   This program uses a public class ValidatePasswordFinal to get user input via the
   scanner class. The user type is first entered and this defines the validation method.
   The ValidatePasswordFinal calls the appropriate validatePass method that checks to see if the entered
   password is valid. The requirements for a valid password are as follows:
   
   		Normal Users Passwords
   		1) Password must be at least 8 characters long.
   		2) Password must contain one letter
   		3) Password must contain one number
   		
   		Admin Users Passwords
   		1) Password must be at least 13 characters long.
   		2) Password must contain one letter
   		3) Password must contain one number
   		4) Password must contain one special character

   If the password is valid the result will display "The password is accepted." If not the result will
   display an appropriate error message.
   
   NOTES:
   The scanner class is being used rather than the regex due to the requirement of iteration 4 (multiple special characters).
   I am much less familiar with regex and am uncertain as to how to increase the required special characters from 1 to 3.
   Drafts of all iterations are being created offline so that only complete iterations are uploaded to the GitHub repository.
   It is assumed that only noted characters are valid for the password 
   (i.e. iterations 1 and 2 cannot contain special characters and no iterations can contain spaces).
   Iteration 3 assumed to need validation of user type entry.
   
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
		
		String inputUserType;							// Declare user type variable
		String inputPassword;							// Declare Password variable

		Scanner input = new Scanner (System.in);				// Define Scanner

		System.out.print("Enter Your User Type (admin or normal): ");						// Prompt for entry
		inputUserType = input.next();						// Read user input
		
		

		if(inputUserType.equals("Admin") || inputUserType.equals("admin")){
		System.out.print("Enter Your Password: ");						// Prompt for entry
		inputPassword = input.next();						// Read user input
		System.out.println(validatePassAdmin(inputPassword));				// Calls the PassCheck Method on the password entered by the user and prints result to screen
		System.out.println("");
		} else if (inputUserType.equals("Normal") || inputUserType.equals("normal")) {
		
		System.out.print("Enter Your Password: ");						// Prompt for entry
		inputPassword = input.next();						// Read user input
		System.out.println(validatePassNormal(inputPassword));				// Calls the PassCheck Method on the password entered by the user and prints result to screen
		System.out.println("");
		} else {
			System.out.println("User type is invalid");
		}
		
		
		main(args);								// re-runs the program (Allows for multiple tests)

	}
	public static String validatePassAdmin (String Password) {

		String result = " ";				// Sets the initial result as valid
		int length = 0;						// Variable to count the number characters in the password
		int numCount = 0;					// Variable to count numbers in the password
		int letterCount = 0;				// Variable to count capital letters in the password
		int charCount = 0;					//Variable to count special characters
		int minLength = 13;					// Variable to define minimum character length
		int minNum = 1;						// Variable to define minimum numbers in password
		int minLetter = 1;					// Variable to define minimum capital letters in password
		int minChar = 1;					//Variable to define minimum special characters


		for (int x =0; x < Password.length(); x++) {
			if ((Password.charAt(x) >= 47 && Password.charAt(x) <= 58) || (Password.charAt(x) >= 64 && Password.charAt(x) <= 91) ||
				(Password.charAt(x) >= 97 && Password.charAt(x) <= 122) || (Password.contains("@") || Password.contains("#") || 
						Password.contains("!") || Password.contains("$") || Password.contains("%") || 
						Password.contains("^") || Password.contains("&") || Password.contains("*"))) {
					//Keep the Password
				} else {
					result = "Password contains invalid character";		//Checks that password contains only letters and numbers
				}

			if (Password.contains("@") || Password.contains("#") || 
					Password.contains("!") || Password.contains("$") || Password.contains("%") || 
					Password.contains("^") || Password.contains("&") || Password.contains("*")) {
				charCount ++;
			}
			
			if ((Password.charAt(x) >= 47 && Password.charAt(x) <= 58)) {			// Counts the number of numbers
				numCount ++;
			}

			if ((Password.charAt(x) >= 64 && Password.charAt(x) <= 91) || (Password.charAt(x) >= 97 && Password.charAt(x) <= 122)) {			// Counts the number of capital letters
				letterCount ++;
			}

			length = (x + 1);								// Counts the password length

		} // Ends the for loop

		if (numCount < minNum){									// Validates quantity of numbers in password
			result = result + " Password does not include a number";
		} else {
				result = result + " Password contains a number";
			}
		

		if (letterCount < minLetter) {									// Validates quantity of letters in password
			result = result + " Password does not contain a letter";
		} else {
				result = result + " Password contains a letter";
			}
		

		if (length < minLength){									// Validates quantity of characters password
			result = result + " Password does not meet length requirement";
		} else {
				result = result + " Password meets length requirements";
			}
		
		if (charCount < minChar){									// Validates quantity of characters password
			result = result + " Password does not contain a valid special character";
		} else {
				result = result + " Password contains a valid special character";
			}
		
		if (result.equals( "  Password contains a number Password contains a letter Password meets length requirements Password contains a valid special character")) {
			result = "Password is valid";
		} else {
		}
		
			return (result);								// Returns the value of "result"

	} // Ends the validatePassAdmin method
	public static String validatePassNormal (String Password) {

		String result = " ";			// Sets the initial result as valid
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
					result = "Password contains invalid character";		//Checks that password contains only letters and numbers
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
			result = result + " Password does not include a number";
		} else {
				result = result + " Password contains a number";
			}
		

		if (letterCount < minLetter) {									// Validates quantity of letters in password
			result = result + " Password does not contain a letter";
		} else {
				result = result + " Password contains a letter";
			}
		

		if (length < minLength){									// Validates quantity of characters password
			result = result + " Password does not meet length requirement";
		} else {
				result = result + " Password meets length requirements";
			}
		
		if (result.equals( "  Password contains a number Password contains a letter Password meets length requirements")) {
			result = "Password is valid";
		} else {
		}

			return (result);								// Returns the value of "result"

	} // Ends the validatePassNormal method
} // Ends the ValidatePassword class