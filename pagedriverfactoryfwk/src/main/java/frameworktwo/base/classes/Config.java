package frameworktwo.base.classes;

public class Config {
	
	
	// local config
	
	public static String browser = System.getProperty("browser", "chrome");
	public static String env = System.getProperty("env", "local");
	public static String validUserName = System.getProperty("validUserName", "standard_user");
	public static String ValidPassword = System.getProperty("ValidPassword", "secret_sauce");
	public static String inValidPassword = System.getProperty("inValidPassword", "wrongPassword");
	public static String url = "https://www.saucedemo.com/";

}
