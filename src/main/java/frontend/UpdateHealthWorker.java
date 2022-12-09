package frontend;
import java.util.HashMap;
import java.util.Scanner;

import backend.HealthWorkerUpdateController;
import backend.IHealthWorkerUpdateController;
import backend.IUserRegistrationController;
import backend.IUserQuery;
import backend.User;
import backend.UserDatabaseColumns;
import backend.UserQuery;
import backend.UserRegistrationController;
import database.DatabaseConnection;
import database.IDatabaseConnection;

public class UpdateHealthWorker {
	private final IDatabaseConnection databaseConnection;
	private final Scanner scanner;
	private final IUserQuery  healthWorkerQuery;

	public UpdateHealthWorker(final Scanner scanner) {
		this.scanner = scanner;
		databaseConnection = DatabaseConnection.instance();
		healthWorkerQuery=UserQuery.instance();
	}

	public final void update() {
		try {			  
			System.out.println("Enter First name ");
			final String firstName = scanner.nextLine().trim().toLowerCase();
			System.out.println("Enter Last name ");
			final String lastName = scanner.nextLine().trim().toLowerCase();
			System.out.println("Enter email ID ");
			final String emailId = scanner.nextLine().trim();
			
			final IHealthWorkerUpdateController healthWorkerUpdateController =
			        new HealthWorkerUpdateController(
			            databaseConnection,
			            healthWorkerQuery);
			
			User healthWorker=healthWorkerUpdateController.getHealthWorker(firstName,lastName,emailId);
			
			if(healthWorker==null) {
				System.out.println("User doesn't Exist.Enter proper Details.");
			}
			else {
				HashMap<String,String> columnValueUpdate=this.getAllUpdateKeyValues();
				if(columnValueUpdate.size()==0) {
					System.out.println("No Details to update");
				}
				else {
					boolean HealthWorkerUpdated=healthWorkerUpdateController.updateHealthWorkerDetails(healthWorker,columnValueUpdate);
					if(HealthWorkerUpdated) {
						System.out.println("Health Worker Updated");
					}
					else {
						System.out.println("Health Worker Not Updated");
					}
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			databaseConnection.stopDatabaseConnection();
		}
	}
	
	public final HashMap<String,String> getAllUpdateKeyValues() {
		HashMap<String,String> columnValue=new HashMap<String,String>();
		boolean breakLoop=true;
		String value=new String();
		while(breakLoop) {
			System.out.println("Enter Required Field and Value");
			System.out.println("PRESS 10 TO UPDATE ALL VALUES AFTER ENTERING THE FIELD AND VALUE");
			System.out.println("Enter choice");
			System.out.println("1. Update First Name\n"
					+ "2. Update Last Name\n"
					+ "3. Update Gender\n"
					+ "4. Update Mobile\n"
					+ "5. Update Email\n"
					+ "6. Update DOB\n"
					+ "7. Update Address\n"
					+ "8. Update City\n"
					+ "9. Update Area Code\n"
					+ "10. UPDATE ALL ENTERED VALUE\n");
			String input=scanner.nextLine();
			switch(input) {
			case "1":
				value=this.setValue(scanner);
				columnValue.put(UserDatabaseColumns.user_first_name, value);
				break;
			case "2":
				value=this.setValue(scanner);
				columnValue.put(UserDatabaseColumns.user_last_name, value);
				break;
			case "3":
				value=this.setValue(scanner);
				columnValue.put(UserDatabaseColumns.user_gender, value.toUpperCase());
				break;
			case "4":
				value=this.setValue(scanner);
				columnValue.put(UserDatabaseColumns.user_mobile, value);
				break;
			case "5":
				value=this.setValue(scanner);
				columnValue.put(UserDatabaseColumns.user_email, value);
				break;
			case "6":
				value=this.setValue(scanner);
				columnValue.put(UserDatabaseColumns.user_dob, value);
				break;
			case "7":
				value=this.setValue(scanner);
				columnValue.put(UserDatabaseColumns.user_address, value);
				break;
			case "8":
				value=this.setValue(scanner);
				columnValue.put(UserDatabaseColumns.user_city, value);
				break;
			case "9":
				value=this.setValue(scanner);
				columnValue.put(UserDatabaseColumns.user_zip, value);
				break;
			case "10":
				System.out.println("Updation in process");
				breakLoop=false;
				break;
			default: 
				System.out.println("Enter the correct option");
				break;
			}
		}
		return columnValue;
	}
	
	public final String setValue(Scanner scanner) {
		System.out.println("Enter value");
		String value=scanner.nextLine().trim();
		return value;
	}
}
