package sampleGitTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SampleGitTest {

	@Test
	public void loginTest() throws IOException{
		System.setProperty("webdriver.chrome.driver", ".\\Browser\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
	wd.manage().window().maximize();
	wd.get("https://www.google.com/");
	
	File f = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(f, new File("D:\\SeleniumWorkspace\\sampleGit\\Screenshot\\image.jpeg"));
	}
}
