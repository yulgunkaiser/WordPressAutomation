package wordPressRegression;

import constants.CommonConstants;
import org.testng.annotations.Test;
import pages.LandingPage;

public class UIRegression {

    @Test
    public void landingPageHome(){
        LandingPage landingPage = new LandingPage(CommonConstants.WORDPRESS_DEMO_LANDING_URL);
    }


}
