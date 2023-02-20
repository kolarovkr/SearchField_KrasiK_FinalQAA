import org.KrasiAQA.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearcFieldTest extends BaseTestPage {

    @DataProvider(name = "getUsers")
    public Object[][] getUsers(){
        return new Object[][]{{"DimitarTarkalanov", "Dimitar1.Tarkalanov1", "DimitarTarkalanov"}, //login with username
                {"testMail1@gmail.com", "Dimitar1.Tarkalanov1", "DimitarTarkalanov"}, //login with email
                {"testAdmin@gmail.com", "Admin1.User1", "AdminUser"}, //login with admin user
                {"manager@gmail.com", "Manager1.Use1", "ManagerUser"} //login with manager user;
        };
    }

@Test(dataProvider = "getUsers")
public void SearchFieldIsVisibleAfterLogin(String username, String password){

        LoginPage loginPage = new LoginPage(getDriver());
    loginPage.logIn(username, password);

        }

}
