package starter;

import starter.GroupProduct.DeleteGroupProduct;
import starter.GroupProduct.GetGroupProduct;
import starter.GroupProduct.PostGroupProduct;
import starter.Login.Login;
import starter.Orders.DeleteOrders;
import starter.Orders.GetOrders;
import starter.Orders.PostOrders;
import starter.Orders.PutOrders;
import starter.Product.DeleteProduct;
import starter.Product.GetProduct;
import starter.Product.PostProduct;
import starter.Product.PutProduct;
import starter.Signup.Signup;
import starter.Users.DeleteUsers;
import starter.Users.GetUsers;
import starter.Users.PutUsers;

public class BaseTest {
    public Login login = new Login();
    public Signup signup = new Signup();
    public PostProduct postproducts = new PostProduct();
    public GetProduct getproduct = new GetProduct();
    public PutProduct putproduct = new PutProduct();
    public DeleteProduct deleteproduct = new DeleteProduct();
    public GetUsers getusers = new GetUsers();
    public DeleteUsers deleteUser = new DeleteUsers();
    public PutUsers putusers = new PutUsers();
    public PostGroupProduct postgroupproduct = new PostGroupProduct();
    public GetGroupProduct getgroupproduct = new GetGroupProduct();
    public PostOrders postorders = new PostOrders();
    public GetOrders getorders = new GetOrders();
    public PutOrders putorders = new PutOrders();
    public DeleteGroupProduct deletegroupproduct = new DeleteGroupProduct();
    public DeleteOrders deleteorders = new DeleteOrders();
}
//comment
