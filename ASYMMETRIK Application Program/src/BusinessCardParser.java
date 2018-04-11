import java.io.FileNotFoundException;
import java.util.Scanner;
public class BusinessCardParser{

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		String document = "";
		System.out.println("Please Enter The File Name That Contains The Business Card Information:");
		document = in.nextLine();
		in.close();
		ContactInfo getContactInfo = new ContactInfo(document);		//Creates new ContactInfo class	
		getContactInfo.showContactInfo();							//Output information
	
	}
	
}
