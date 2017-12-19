package scripts;

import framework.setup.Setup;
import org.testng.TestNG;
import org.testng.collections.Lists;

import java.util.List;

public class RunAllTests extends Setup {

    public static void main(String[] args) throws Exception{
        TestNG testNG = new TestNG();
        List<String> suites = Lists.newArrayList();
        suites.add("./../TestSuites");
        testNG.setTestSuites(suites);
        testNG.run();
    }
}
