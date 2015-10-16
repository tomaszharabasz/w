// Zaznacza qa1 na check
// i radio button qa 1 na nein

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Selectqa1 {
	public Selectqa1(WebDriver driver) {
	
		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[contains(@id, 'qa-1')]"));

		for (WebElement button : radioButtons) {
			button.click();
		}
}
}
