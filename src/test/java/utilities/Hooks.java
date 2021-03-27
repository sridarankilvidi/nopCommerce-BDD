package utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
@Before
    public void beforeScenario(){
        System.out.println("This will run before the every Scenario");
    } 
 @Before
    public void beforeScenarioStart(){
        System.out.println("-----------------Start of Scenario-----------------");
    } 
 @After
    public void afterScenarioFinish(){
        System.out.println("-----------------End of Scenario-----------------");
    } 
 @After
    public void afterScenario(){
        System.out.println("This will run after the every Scenario");
    } 

}
