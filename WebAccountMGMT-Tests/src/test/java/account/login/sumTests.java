package account.login;

import dblayer.UserService.UsersProvider;
import dblayer.UserService.model.User;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.testng.Assert;
import org.testng.annotations.Test;


public class sumTests {

    String username="antonio";
    @Test
    public void sumAPlusB(){

        User dbUser = UsersProvider.getUser(username);

        Assert.assertEquals(dbUser.getUsername(),username);


       /* int a =0;
        double b=1.00f;
        double expectedValue = 1.00f;

        Assert.assertEquals(a+b,expectedValue);*/

    }
    @Ignore
    public void sumAPlusBWhitDouble(){
        int a =0;
        double b=1.00f;
        double expectedValue = a+b;

        Assert.assertEquals(a+b,expectedValue);

    }
}
