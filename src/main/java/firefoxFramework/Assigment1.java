package firefoxFramework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assigment1 {
	public static void main(String[] args) throws InterruptedException {
		// Initializing FireFoxDriver
		WebDriver driver = new FirefoxDriver();

		// adding waits
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// navigating to the trello website
		driver.get("https://trello.com/");

		driver.findElement(By.linkText("Log in")).click();

		// adding the user details
		driver.findElement(By.id("user")).sendKeys("gurdamansingh2112@gmail.com");

		driver.findElement(By.id("login")).click();

		WebElement login = driver.findElement(By.id("login-submit"));

		Thread.sleep(1000);

		driver.findElement(By.name("password")).sendKeys("Gur2112@18");
		login.click();

		// after sucessfull login create a board
		driver.findElement(By.xpath("//*[text()='Create new board']")).click();

		String generatedString = randomString(10);
		driver.findElement(By.xpath("//*[text()=\"Board title\"]/following-sibling::input")).sendKeys(generatedString);

		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@data-testid='create-board-submit-button']")).click();

		// after board is created now create lists as mentioned
		driver.findElement(By.xpath("//*[@placeholder='Enter list title…']")).sendKeys("List A");

		driver.findElement(By.xpath("//*[@value='Add list']")).click();

		driver.findElement(By.xpath("//*[@placeholder='Enter list title…']")).sendKeys("List B");

		driver.findElement(By.xpath("//*[@value='Add list']")).click();

		// add a card in list A
		WebElement addcard = driver
				.findElement(By.xpath("//h2[text()='List A']/ ../following-sibling::div//*[text()='Add a card']"));

		addcard.click();

		driver.findElement(By.xpath("//*[@placeholder='Enter a title for this card…']")).sendKeys("card1");
		driver.findElement(By.xpath("//*[@value='Add card']")).click();

		Thread.sleep(1000);

		// this is for drag and drop
		Actions action = new Actions(driver);
		WebElement card1 = driver.findElement(By.xpath("//*[text()='card1']"));
		WebElement listB = driver.findElement(By.xpath("//h2[text()='List B']/ ../ .."));
		action.dragAndDrop(card1, listB).build().perform();
		card1 = driver.findElement(By.xpath("//*[text()='card1']"));

		// getting the co-ordinates of the card
		Point location = card1.getLocation();
		System.out.println("X, Y - coordinates : " + location);

		// performing logout(last step)
		driver.findElement(By.xpath("//*[@title='Gurdaman Singh (gurdamansingh2)']")).click();

		WebElement logoutButton = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-testid='account-menu-logout']")));

		logoutButton.click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-testid='logout-button']"))).click();

		driver.quit();
	}

	// this menthod is to generate random Sting for a given length
	public static String randomString(int l) {
		String Str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz";

		StringBuilder s = new StringBuilder(l);

		for (int i = 0; i < l; i++) {

			int ch = (int) (Str.length() * Math.random());

			s.append(Str.charAt(ch));

		}

		return s.toString();

	}
}
