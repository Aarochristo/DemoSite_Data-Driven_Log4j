package mainProgram;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class providrerclass {
	
	
	//
	// DataProvider alwayys gives return type as String[][] -- which mean 2 dimensional array 

	
	
	
	
	@DataProvider

	public String[][] exeldata() throws IOException

	{

		String[][] secinddta = first.main();
		
		
		
		//first class 
		// main method it should be always Static method

		return secinddta;

	}

}
