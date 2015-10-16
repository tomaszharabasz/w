// Zaznaca wszystkie checboxy i radio buttony na nein


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CheckBoxOneAllowed {
	public CheckBoxOneAllowed(WebDriver driver) {
	
		//List<WebElement> radioButtons = driver.findElements(By.xpath("//input[contains(@id, 'qa-4')]"));
		WebElement radioButton1 = driver.findElement(By.xpath("//input[contains(@id, 'qa-[1]-yes')]"));
		WebElement radioButton2 = driver.findElement(By.xpath("//input[contains(@id, 'qa-[2]-yes')]"));
		WebElement radioButton3 = driver.findElement(By.xpath("//input[contains(@id, 'qa-[3]-yes')]"));
		WebElement radioButton4 = driver.findElement(By.xpath("//input[contains(@id, 'qa-[4]-no')]"));

		List<WebElement> radioButtons = new ArrayList<WebElement>();
		radioButtons.add(radioButton1);
		radioButtons.add(radioButton2);
		radioButtons.add(radioButton3);
		
		if (radioButton4.getAttribute("value").equals("0"))
			{radioButton4.click();}
		
		for (WebElement button : radioButtons) {
			if(button.getAttribute("value").equals("1")) {
				button.click();
			}
		}
}
}
