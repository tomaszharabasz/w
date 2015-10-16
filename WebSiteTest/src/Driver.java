import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {
	private final static String WEBSITE = "http://temp-mail.org/";
	private final static String GOOD = "Frage wurde korrekt beantwortet";

	public Driver(String s) {
		String line;
		WebDriver driver = new FirefoxDriver();
		driver.get(WEBSITE);
		
		WebElement emailFinder= driver.findElement(By.id("mail"));
		String emailName = emailFinder.getAttribute("value");
		
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		driver.get("http://www.uds-beratung.de/quiz/action/directload/type/full/id/1/");
		
		//Register
		WebElement Register = driver.findElement(By.linkText("Hier können Sie sich registrieren"));
		Register.click();
		WebElement Name = driver.findElement(By.name("username"));
		Name.sendKeys(emailName);
		WebElement Firma = driver.findElement(By.name("usercompany"));
		Firma.sendKeys(emailName);
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys(emailName);
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys(emailName);
		WebElement button = driver.findElement(By.className("btn"));
		button.click();
		driver.get("http://www.uds-beratung.de/quiz/action/quiz/type/1/");
		
		//back to mail
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_DOWN);
		
		try {
			Thread.sleep(10000);
			driver.findElement(By.partialLinkText("Quiz"));
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_DOWN);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//Odpowiadacz
		trajal(s, driver);
		/*
		try {
		whileFunction(s, driver);
		} catch (UnhandledAlertException e) {
			try {
				new Selectqa1(driver); 
				driver.findElement(By.xpath("//input[contains(@value, 'weiter')]")).click();
				whileFunction(s, driver);
				} catch (Exception ez) {
				System.out.print("nonext");
			};
		}*/
		
		// Close test
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL,Keys.F4);
		try {
			Thread.sleep(15000);
			/*WebDriverWait wait = new WebDriverWait(driver, 10000);
			wait.until(ExpectedConditions.visibilityOfElementLocated((By.linkText("Auswertung des Quiz von u"))));
			*/
			WebElement a = driver.findElement(By.linkText("Auswertung des Quiz von u"));
			a.click();
			Thread.sleep(2000);
	
		} catch (NoSuchElementException e1) {
			System.out.print("!=quiz");
			closer(driver);
			return;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String address = driver.getCurrentUrl();

        File file = new File("/home/tomasz/Dokumenty/witek/example.html");
        try {
    		URL url = new URL(address);
    		InputStream is = url.openStream();          // throws an IOException
    		BufferedReader br = new BufferedReader(new InputStreamReader(is));

			file.createNewFile();
	        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

    		
			while ((line = br.readLine()) != null) {
				writer.write(line);
			}
	        
			writer.flush();
	        writer.close();
	        new Jerihotest(file, s);

			closer(driver);
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

	}
	
	private static void closer(WebDriver driver) {
        driver.close();
	}
	
	private static void whileFunction(String s, WebDriver driver) {
		
		while ((driver.findElements(By.id("nextbtn")).size()) != 0){
			if (s.equals("1100")) {
				if (driver.findElements(By.xpath("//input[contains(@type,'checkbox')]")).size()!=0) {
					new Selectqa1(driver); 
					driver.findElement(By.id("nextbtn")).click();
				} else {
					new radioButton1100(driver);
					driver.findElement(By.id("nextbtn")).click();
				}
			} else if (s.equals("1011")) {
				if (driver.findElements(By.xpath("//input[contains(@type,'checkbox')]")).size()!=0) {
					new Selectqa2(driver); 
					driver.findElement(By.id("nextbtn")).click();
				} else {
					new radioButton1011(driver);
					driver.findElement(By.id("nextbtn")).click();
				}
			} else if (s.equals("1010")) {
				if (driver.findElements(By.xpath("//input[contains(@type,'checkbox')]")).size()!=0) {
					try {
					new Selectqa3(driver); } catch (UnhandledAlertException e) {new Selectqa1(driver); } 
					driver.findElement(By.id("nextbtn")).click();
				} else {
					new radioButton1010(driver);
					driver.findElement(By.id("nextbtn")).click();
				}
			}
			else if (s.equals("1001")) {
				if (driver.findElements(By.xpath("//input[contains(@type,'checkbox')]")).size()!=0) {
					try {
					new Selectqa4(driver); } catch (UnhandledAlertException e) {new Selectqa1(driver); } 
					driver.findElement(By.id("nextbtn")).click();
				} else {
					new radioButton1001(driver);
					driver.findElement(By.id("nextbtn")).click();
				}
			}  
			
			else if (s.equals("1000")) {
				if (driver.findElements(By.xpath("//input[contains(@type,'checkbox')]")).size()!=0) {
					new Selectqa1(driver); 
					driver.findElement(By.id("nextbtn")).click();
				} else {
					new radioButton1000(driver);
					driver.findElement(By.id("nextbtn")).click();
				}
			} else if (s.equals("0111")) {
				if (driver.findElements(By.xpath("//input[contains(@type,'checkbox')]")).size()!=0) {
					new Selectqa2(driver); 
					driver.findElement(By.id("nextbtn")).click();
				} else {
					new radioButton0111(driver);
					driver.findElement(By.id("nextbtn")).click();
				}
			} else if (s.equals("0110")) {
				if (driver.findElements(By.xpath("//input[contains(@type,'checkbox')]")).size()!=0) {
						try {
						new Selectqa3(driver); } catch (UnhandledAlertException e) {new Selectqa1(driver); } 
						driver.findElement(By.id("nextbtn")).click();
					} else {
						new radioButton0110(driver);
						driver.findElement(By.id("nextbtn")).click();
					}
			} else if (s.equals("0101")) {
						if (driver.findElements(By.xpath("//input[contains(@type,'checkbox')]")).size()!=0) {
							try {
							new Selectqa4(driver); } catch (UnhandledAlertException e) {new Selectqa1(driver); } 
							driver.findElement(By.id("nextbtn")).click();
						} else {
							new radioButton0101(driver);
							driver.findElement(By.id("nextbtn")).click();
						}
			} else if (s.equals("0100")) {
				if (driver.findElements(By.xpath("//input[contains(@type,'checkbox')]")).size()!=0) {
					new Selectqa1(driver); 
					driver.findElement(By.id("nextbtn")).click();
				} else {
					new radioButton0100(driver);
					driver.findElement(By.id("nextbtn")).click();
				}
			} else if (s.equals("0011")) {
				if (driver.findElements(By.xpath("//input[contains(@type,'checkbox')]")).size()!=0) {
					new Selectqa2(driver); 
					driver.findElement(By.id("nextbtn")).click();
				} else {
					new radioButton0011(driver);
					driver.findElement(By.id("nextbtn")).click();
				}
			} else if (s.equals("0010")) {
				if (driver.findElements(By.xpath("//input[contains(@type,'checkbox')]")).size()!=0) {
					try {
					new Selectqa3(driver); } catch (UnhandledAlertException e) {new Selectqa1(driver); } 
					driver.findElement(By.id("nextbtn")).click();
				} else {
					new radioButton0010(driver);
					driver.findElement(By.id("nextbtn")).click();
				}
			} else if (s.equals("0001")) {
				if (driver.findElements(By.xpath("//input[contains(@type,'checkbox')]")).size()!=0) {
					try {
					new Selectqa4(driver); } catch (UnhandledAlertException e) {new Selectqa1(driver); } 
					driver.findElement(By.id("nextbtn")).click();
				} else {
					new radioButton0001(driver);
					driver.findElement(By.id("nextbtn")).click();
				}
			}else if (s.equals("1101")) {
				if (driver.findElements(By.xpath("//input[contains(@type,'checkbox')]")).size()!=0) {
					try {
					new Selectqa4(driver); } catch (UnhandledAlertException e) {new Selectqa1(driver); } 
					driver.findElement(By.id("nextbtn")).click();
				} else {
					new radioButton1101(driver);
					driver.findElement(By.id("nextbtn")).click();
				}
			}
					
			
		}
	}


	private static void trajal(String s, WebDriver driver) {
		try {
			whileFunction(s, driver);
		} catch(UnhandledAlertException e){
			System.out.println("wyjatek, kliknij q1 i water");
			new Selectqa1(driver); 
			driver.findElement(By.xpath("//input[contains(@value, 'weiter')]")).click();
			trajal(s,driver);
		}
	}
}

