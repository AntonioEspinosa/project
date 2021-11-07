package reports;

import org.h2.store.fs.FileUtils;
import org.testng.*;
import org.testng.xml.XmlSuite;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.*;


import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ThymeLeafReports implements IReporter {

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {



        try {
            Context thContext = new Context();
            thContext.setVariable("suites", suites);

            ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
            templateResolver.setTemplateMode(TemplateMode.HTML);
            templateResolver.setSuffix(".html");
            templateResolver.setPrefix("/templates/");

            TemplateEngine templateEngine = new TemplateEngine();
            templateEngine.setTemplateResolver(templateResolver);

            FileWriter flw = new FileWriter(outputDirectory + ".html");
            templateEngine.process("SuiteReport", thContext, flw);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void extracted(List<ISuite> suites) {
        Iterator<ISuite> it = suites.iterator();

        while (it.hasNext()) {

            ISuite suite = it.next();
            for (Map.Entry<String, ISuiteResult> suiteResult : suite.getResults().entrySet()) {
                ISuiteResult testResult = suiteResult.getValue();
                IResultMap passedTests = testResult.getTestContext().getPassedTests();
                extracted(testResult.getTestContext().getPassedTests());
                extracted(testResult.getTestContext().getFailedTests());
                extracted(testResult.getTestContext().getSkippedTests());
            }


        }
    }

    private void copyFiesToSomePlace(){
        String outputDirectory=null;
        try {
            FileWriter flw = new FileWriter(outputDirectory + ".html");

            InputStream f = this.getClass().getResourceAsStream("/util.js");
            URL path = this.getClass().getResource("/util.js");

            File aFile = new File(path.toURI().toString());



        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private void extracted(IResultMap passedTests) {
        for (ITestResult test : passedTests.getAllResults()) {
            System.out.println(test.getName());
            System.out.println(test.getStatus());
        }
    }

}



