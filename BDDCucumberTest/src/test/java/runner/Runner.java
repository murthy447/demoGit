package runner;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

@RunWith(Cucumber.class)


@CucumberOptions(
		features = "src/test/java/features"
		,glue = "stepDefinations"
		,monochrome = true
		,publish= true
		,tags = "@smoke or @regression"
//		,dryRun =true
				,plugin ={"pretty", "html:target/htmlReport/htmlreport.html"
						,"json:target/jsonReports/cucumberjsn.json"}
		)




public class Runner {
	@AfterClass
//	public static void afterClass(){
//		new MyThread();
//	}
	
	public static void generateReport(){
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		File cucumberReports=	new File("D:\\PracticeWorkspace\\BDDCucumberTest\\target\\jsonReports\\cucumberjsn.json");
		
		File cucumberReportsHistory=	new File("D:\\PracticeWorkspace\\BDDCucumberTest\\target\\jsonReports\\cucumberjsn_"+timestamp+".json");
		
		cucumberReports.renameTo(cucumberReportsHistory);
		File dir = new File("D:\\PracticeWorkspace\\BDDCucumberTest\\target\\jsonReports\\");
		
		File[] files= dir.listFiles((dir1, name) -> name.startsWith("cucumberjsn")&& name.endsWith(".json"));
		
		if(files!=null){
		Collection<File>	jsonFiles =Arrays.asList(files);
		List<String> jsonpaths = new ArrayList<>(jsonFiles.size());
		
		for(File file: jsonFiles){
			jsonpaths.add(file.getAbsolutePath());
		}
		
	
		
		Configuration config =new Configuration(new File("target"), "CucumberBDD");
		
		config.addClassifications(StringUtils.capitalize("PLATFORM"), "Windows");
		config.addClassifications(StringUtils.capitalize("BROWSER"), "Chrome");
		
			
		ReportBuilder reportbuilder = new ReportBuilder(jsonpaths, config);
		reportbuilder.generateReports();
		}
	}

}
