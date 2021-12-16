package starter;

import starter.Login.Login;
import starter.Product.GetProduct;
import starter.Product.PostProduct;
import starter.Signup.Signup;

public class BaseTest {
    public Login login = new Login();
    public Signup signup = new Signup();
    public PostProduct postproducts = new PostProduct();
    public GetProduct getproduct = new GetProduct();
}
