package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadpropertyFile {

	public static Properties configProperty(){

		FileReader fr = null;
		String filepath="C:\\Users\\subas\\eclipse-workspace\\BankApplication_Automation\\configFiles\\config.properties";

		try {
			fr = new FileReader(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Properties p = new Properties();
		try {
			p.load(fr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
  
	}
	
	public static Properties cusDetailProperty(){

		FileReader fr = null;
		String filepath="C:\\Users\\subas\\eclipse-workspace\\BankApplication_Automation\\configFiles\\coustomerdetails.properties";

		try {
			fr = new FileReader(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Properties p = new Properties();
		try {
			p.load(fr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
  
	}

}
