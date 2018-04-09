import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
public class ContactInfo {
	
	//Variables
	private String Doc;
	private String name;
	private String pNumber;
	private String email;
	//A list of common job words found in job titles and company names
	private String[] taboo = {"therapist", "asisstant", "administrative", "manager", "regional", "project", "representative", "sales", "account", 
							  "developer", "senior", "junior", "analyst", "customer", "software", "engineer", "analytic", "co.", "ltd", "inc.",
							  "technologies", "corporation", "group", "company", "corp", "partners"};
	
	public ContactInfo() {
		
	}

	public ContactInfo(String Document) throws FileNotFoundException {
		Doc = "";
		
		//Opens the text document and parses through, adding each line to the Doc variable.
		Scanner inFile = new Scanner(new FileReader(Document));
		while(inFile.hasNextLine()) {
			Doc = Doc + "\n" + inFile.nextLine();
		}
		inFile.close();
		name = getName();
		pNumber = getPhoneNumber();
		email = getEmailAddress();
	}
	
	
	
	/*
	 * getName
	 * Takes the given document and parses through finding a line that 
	 * is a name. Checks for a first and last name,  and makes sure that no common job titles or company names are a part of it.
	 * 
	 * input: None
	 * Output: Phone Number
	 * 
	*/
	public String getName() {
		String Name = "Failed";
		String[] lines = Doc.split("\n");						//Splits at every new line
		for (String info : lines) {			
			String[] words = info.split("\\s");					//Splits each line into its individual words
			if(words.length == 2) {								//Checks for two names
																//Searches the array of common words to make sure all possible names are indeed names.
				if(!Arrays.asList(taboo).contains(words[0].toLowerCase()) && !Arrays.asList(taboo).contains(words[1].toLowerCase())) {
					Name = info;
					break;
				}
			}
		}
		
		
		
		return Name;
	}
	
	/*
	 * getPhoneNumber
	 * Takes the given document and parses through finding a line that 
	 * matches the pattern of a phone number
	 * 
	 * input: None
	 * Output: Phone Number
	 * 
	*/
	public String getPhoneNumber() {
		String number = "Failed";
		String[] lines = Doc.split("\n");											// split document by line
		String pattern = "(.*)(\\d{3})(.*)(\\d{3})(.*?)(\\d{4}$)"; 					//Checks for any set of 10 numbers formated and seperated in any way. where the number ends the line
		String pattern2 = "(.*?)(1)(.*)(\\d{3})(.*)(\\d{3})(.*)(\\d{4})";			// checks for phone numbers that have a +1 at the beginning
		for (String info : lines) {													//Search all lines of the business card to match for the correct 
			if(!info.contains("Fax:")) {											//patterns. Sets the variable if found.
				if (info.matches(pattern2)) {										//Check to max sure it is not matching with a fax number
					number = info.replaceAll(pattern, "1$2$4$6");
				}
				else if (info.matches(pattern)){
					number = info.replaceAll(pattern, "$2$4$6");
				}
			}
		}
		return number;
	}
	
	/*
	 * getEmailAddress 
	 * Takes the given document and parses through finding a line that 
	 * matches the pattern of an email address
	 * 
	 * input: None
	 * Output: email
	 * 
	*/
	public String getEmailAddress() {
		String Email = "Failed";
		String[] lines = Doc.split("\n");									// split document by line
		String pattern = "(\\s*)(.+)(@)(\\w+)(.+$)";				//checks for @ symbol and also the 
		for (String info : lines) {											//indicating an email address while 
			if(info.matches(pattern)) {										//accounting for possible Email header
				Email = info.replaceAll(pattern, "$2$3$4$5");					//i.e. "Email: jed2@umbc.edu"
			}
		}
		return Email;
	}
	
	/*
	 * showContactInfo
	 * Takes the obtained information and formats into the desired output.
	 * 
	 * input: None
	 * Output: None
	 * 
	*/
	public void showContactInfo() {
		System.out.println("Name: " + name);
		System.out.println("Phone: " + pNumber);
		System.out.println("Email: " + email);
	}
	
}
