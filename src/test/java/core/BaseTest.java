package core;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.Browser;

public abstract class BaseTest {

    @BeforeClass
    public static  void setupBrowser(){
        Browser.setup();
    }
//    @AfterClass
//    public  static  void quitBrowser(){
//        Browser.tearDown();
//    }

}
