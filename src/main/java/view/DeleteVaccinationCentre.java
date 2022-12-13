package view;

import java.util.Scanner;

import controller.VaccinationCentreDetailsController;

public class DeleteVaccinationCentre {
	
	public void delete(Scanner scanner)
	{
		System.out.println("enter the centre code of the centre you want to delete");
		String centre_code=scanner.nextLine();
		VaccinationCentreDetailsController vaccinationCentreDetailsController=new VaccinationCentreDetailsController();
	    String deletionResult=vaccinationCentreDetailsController.deleteVaccinationCentreDetailsController(centre_code);
	    System.out.println(deletionResult);
	}
}
