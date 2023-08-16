package firefoxFramework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assigment1 {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://trello.com/");

		driver.findElement(By.linkText("Log in")).click();

		driver.findElement(By.id("user")).sendKeys("gurdamansingh2112@gmail.com");

		driver.findElement(By.id("login")).click();

		WebElement login = driver.findElement(By.id("login-submit"));

		
			Thread.sleep(1000);
		
		driver.findElement(By.name("password")).sendKeys("Gur2112@18");
		login.click();
		
		driver.findElement(By.xpath("//*[text()='Create new board']")).click();
		
		 String generatedString = randomString(10);
		driver.findElement(By.xpath("//*[text()=\"Board title\"]/following-sibling::input")).sendKeys(generatedString);
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@data-testid='create-board-submit-button']")).click();
		
//		String boardXpath = "//div[@title='"+ generatedString +"']";
//
//		WebElement board = driver.findElement(By.xpath(boardXpath));
//		
//		wait.until(ExpectedConditions.elementToBeClickable(board));
//		board.click();
//

	//	driver.findElement(By.xpath("//*[text()='Add another list']")).click();
		
		
		driver.findElement(By.xpath("//*[@placeholder='Enter list title…']")).sendKeys("List A");

		driver.findElement(By.xpath("//*[@value='Add list']")).click();

		driver.findElement(By.xpath("//*[@placeholder='Enter list title…']")).sendKeys("List B");

		driver.findElement(By.xpath("//*[@value='Add list']")).click();

		WebElement addcard = driver
				.findElement(By.xpath("//h2[text()='List A']/ ../following-sibling::div//*[text()='Add a card']"));

		addcard.click();

		driver.findElement(By.xpath("//*[@placeholder='Enter a title for this card…']")).sendKeys("card1");
		driver.findElement(By.xpath("//*[@value='Add card']")).click();
		
		
		Thread.sleep(1000);
		
	  Actions action = new Actions(driver); 
	  WebElement card1 =	driver.findElement(By.xpath("//*[text()='card1']"));
	  WebElement listB =	driver.findElement(By.xpath("//h2[text()='List B']/ ../ .."));
	  action.dragAndDrop(card1, listB).build().perform();
	  card1 =	driver.findElement(By.xpath("//*[text()='card1']"));
	  
	  Point location = card1.getLocation();
      System.out.println("X, Y - coordinates : " + location);	
      
      driver.quit();
		

	}
	
	public static String randomString(int l) {
		 String Str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz";


				 StringBuilder s = new StringBuilder(l);

				 for (int i=0; i<l; i++) {

				   int ch = (int)(Str.length() * Math.random());

				   s.append(Str.charAt(ch));

				  }

				    return s.toString();
		
	} 
}
