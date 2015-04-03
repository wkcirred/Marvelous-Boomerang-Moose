package marvelousboomerangmoose.shoppingwithfriends;

import junit.framework.TestCase;

public class LoginActivityTest extends TestCase {
    LoginActivity la;
    public void setUp() throws Exception {
        super.setUp();
        la = new LoginActivity();

    }

    public void testValidPassword() throws Exception {
        String pw = "AAAAAAA";
        assertTrue(la.isPasswordValid(pw));
        
    }
    public void testInvalidPassword() throws Exception {
        String pw = "";
        assertFalse(la.isPasswordValid(pw));
    }
}