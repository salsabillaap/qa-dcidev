package starter;

import starter.Login.Login;
import starter.Product.DeleteProduct;
import starter.Product.GetProduct;
import starter.Product.PostProduct;
import starter.Product.PutProduct;
import starter.Signup.Signup;
import starter.Users.DeleteUsers;
import starter.Users.GetUsers;

public class BaseTest {
    public Login login = new Login();
    public Signup signup = new Signup();
    public PostProduct postproducts = new PostProduct();
    public GetProduct getproduct = new GetProduct();
    public PutProduct putproduct = new PutProduct();
    public DeleteProduct deleteproduct = new DeleteProduct();
    public GetUsers getusers = new GetUsers();
    public DeleteUsers deleteUser = new DeleteUsers();
}
