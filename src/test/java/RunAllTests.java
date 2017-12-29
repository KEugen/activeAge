//package site.scripts;

import framework.setup.Setup;
import org.testng.TestNG;
import org.testng.collections.Lists;

import java.util.List;

public class RunAllTests extends Setup {

    public static void main(String[] args) throws Exception{
        TestNG testNG = new TestNG();
        List<String> suites = Lists.newArrayList();
        //suites.add("./TestSuite.xml");
        suites.add("./AdminTestSuite.xml");
        testNG.setTestSuites(suites);
        testNG.run();
    }
}
