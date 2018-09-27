package com.qa.ateeb.TeaTestingCucReport;

import org.junit.runner.RunWith;

import com.relevantcodes.extentreports.ExtentReports;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = Constants.featureFileRoot)
public class TeaRunner {
		
		static public ExtentReports report = new ExtentReports(Constants.reportFileSave, true); //REPORTING

}
