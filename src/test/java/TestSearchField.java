import org.krasi.qa.pages.Header;
import org.krasi.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestSearchField extends TestObject{


    @DataProvider(name = "getUsers")
    public Object[][] getUsers(){
        return new Object[][]{{"krasiko", "224339K"}, //login with username
        };
    }

    @Test(dataProvider = "getUsers")
    public void testSearchFieldIsVisibleAfterLogin(String username, String password){

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.logIn(username, password);
        Header header = new Header(getDriver());
        Assert.assertTrue(header.isSearchBarVisible());
    }

    @Test(dataProvider = "getUsers")
    public void testFindUser(String username, String password) {

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.logIn(username, password);
        Header header = new Header(getDriver());
        header.findUser();

    }

}
