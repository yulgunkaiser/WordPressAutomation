package listener;

import lombok.extern.log4j.Log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


@Log4j2
public class TestCaseListener implements ITestListener {

    private final Logger log = (Logger) LogManager.getLogger(TestCaseListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        log.info("{}....{}' STARTED", result.getTestClass(), result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        log.info("{}....{}' PASSED", result.getTestClass(), result.getName());
    }

    public void onTestFailure(ITestResult result) {
        log.info("{}....{}' FAILED", result.getTestClass(), result.getName(), result.getThrowable());
    }

    public void onTestSkipped(ITestResult result) {
        log.info("{}....{}' SKIPPED", result.getTestClass(), result.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
    }

    public void onFinish(ITestContext context) {
    }
}
