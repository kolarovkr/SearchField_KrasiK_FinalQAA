import org.krasi.qa.pages.Header;
import org.krasi.qa.pages.LoginPage;
import org.krasi.qa.pages.UserPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestSearchField extends TestObject{
    @DataProvider(name = "getUsers")
    public Object[][] getUsers(){
        return new Object[][]{{"krasik@gmail.com", "224339K", "Startup2019"}, //login with username
                {"testAdmin@gmail.com", "Admin1.User1", "MARIELKATA"}, //login with admin user
                {"manager@gmail.com", "Manager1.Use1", "gerov"} //login with manager user
        };
    }

    @Test(dataProvider = "getUsers")
    public void testIsSearchBarVisibleAfterLogin(String username, String password, String user){

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.logIn(username, password);
        Header header = new Header(getDriver());
        Assert.assertTrue(header.isSearchBarVisible());
    }

    @Test(dataProvider = "getUsers")
    public void testFindUser(String username, String password, String user) {

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.logIn(username, password);
        Header header = new Header(getDriver());
        header.selectUser(user);
        UserPage userPage = new UserPage(getDriver());
        Assert.assertTrue(userPage.isUrlLoaded());
        Assert.assertEquals(userPage.getUsername(),user);
    }


}
