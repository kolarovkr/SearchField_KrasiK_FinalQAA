import org.KrasiAQA.Header;
import org.KrasiAQA.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearcFieldTest extends BaseTestPage {

    @DataProvider(name = "getUsers")
    public Object[][] getUsers(){
        return new Object[][]{{"krasiko", "224339K"}, //login with username
        };
    }

@Test(dataProvider = "getUsers")
public void SearchFieldIsVisibleAfterLogin(String username, String password){

        LoginPage loginPage = new LoginPage(getDriver());
    loginPage.logIn(username, password);
    Header header = new Header(getDriver());
    Assert.assertTrue(header.isSearchBarVisible());
        }

    @Test(dataProvider = "getUsers")
    public void FindUser(String username, String password) {

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.logIn(username, password);
        Header header = new Header(getDriver());
        header.findUser();

    }

}
