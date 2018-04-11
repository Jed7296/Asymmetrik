# Asymmetrik Application Program

This project is my solution to Asymmetrik's Business Card OCR Problem. The program will parse through a business card's information and pull out the name, phone number and e-mail address.

The solution makes use of multiple regular expressions to pick out patterns that are used for phone numbers and email addresses. To find the name, I made use of an array of keywords commonly found in job titles and company names to differentiates names from everything else.
It is possible that there can be a job title or company name that is both two words and does not include any of the keywords in my array.

# Build Instructions:

Console Instructions: 
Copy the src file.
Open the command prompt and move the the src folder.
Once inside the folder run the command "javac BusinessCardParser.java ContactInfo.java"

IDE instructions:
Copy the repository to your workspace.
Open the project, and compile/run.

# Running and Testing Instructions

The program prompts the user for the file name or the path to the file that contains the information.
To test, either create a txt file or use the included templates in the repository based on the given examples.

