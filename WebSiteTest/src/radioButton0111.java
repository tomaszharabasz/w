// Zaznaca wszystkie checboxy i radio buttony na nein


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class radioButton0111 {
	public radioButton0111(WebDriver driver) {
	
		//List<WebElement> radioButtons = driver.findElements(By.xpath("//input[contains(@id, 'qa-4')]"));
		WebElement radioButton1 = driver.findElement(By.xpath("//input[contains(@id, 'qa-[1]-no')]"));
		WebElement radioButton2 = driver.findElement(By.xpath("//input[contains(@id, 'qa-[2]-yes')]"));
		WebElement radioButton3 = driver.findElement(By.xpath("//input[contains(@id, 'qa-[3]-yes')]"));
		WebElement radioButton4 = driver.findElement(By.xpath("//input[contains(@id, 'qa-[4]-yes')]"));

		List<WebElement> yes = new ArrayList<WebElement>();
		List<WebElement> no = new ArrayList<WebElement>();
		
		no.add(radioButton1);
		yes.add(radioButton2);
		yes.add(radioButton3);
		yes.add(radioButton4);
		
		for (WebElement button : no) {
			if(button.getAttribute("value").equals("0")) {
				button.click();
			}
		}
		
		for (WebElement button : yes) {
			if(button.getAttribute("value").equals("1")) {
				button.click();
			}
		}
}
}
