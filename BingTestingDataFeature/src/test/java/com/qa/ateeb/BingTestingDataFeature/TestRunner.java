package com.qa.ateeb.BingTestingDataFeature;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = Constants.featureFileRoot)
public class TestRunner {
		
		//static public ExtentReports report = new ExtentReports(Constants.reportFileSave, true); //REPORTING

}
