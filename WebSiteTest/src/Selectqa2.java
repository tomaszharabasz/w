// Zaznaca wszystkie checboxy i radio buttony na nein


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Selectqa2 {
	public Selectqa2(WebDriver driver) {
	
		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[contains(@id, 'qa-2')]"));

		for (WebElement button : radioButtons) {
			button.click();
		}
}
}
