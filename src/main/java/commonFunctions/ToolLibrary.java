package commonFunctions;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.BaseClass;

public class ToolLibrary extends BaseClass {

    public ToolLibrary(String url) {
        super(url);
    }

    public void highlight(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) super.getDriver();
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }
}
