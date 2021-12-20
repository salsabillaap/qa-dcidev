package starter.BaseEndpoint;

public class BaseEndpoint {
    public String BASEURL = "https://barengin.site";
    public String Login = BASEURL+"/login";
    public String Signup = BASEURL+"/signup";
    public String Product = BASEURL+"/jwt/products";
    public String GetAllProduct = BASEURL+"/products";
    public String GetProductID = BASEURL+"/products/";
    public String PutProduct = BASEURL+"/jwt/products/";
    public String DeleteProduct = BASEURL+"/jwt/products/";
    public String GetAllUsers = BASEURL+"/jwt/users";
    public String GetUsersID = BASEURL+"/jwt/users/";
    public String DeleteUser = BASEURL+"/jwt/users/";
    public String PutUsers = BASEURL+"/jwt/users/";
    public String PostGroupProduct = BASEURL+"/jwt/products/group/";
    public String GetGroupAllProduct = BASEURL+"/products/group";
    public String GetGroupAllProductIDGroup = BASEURL+"/products/group/";
    public String GetGroupAllProductIDProduct = BASEURL+"/products/group/products/";
    public String GetGroupProductStatus = BASEURL+"/products/group/status/";
    public String PostOrders = BASEURL+"/jwt/orders/"; //post order
    public String GetOrderByIDOrders = BASEURL+"/jwt/orders//"; //get order by id order
    public String GetAllOrdersByIDGroup = BASEURL+"/jwt/orders/group/"; //get all orders by id group for admin only
    public String GetAllOrdersByIDUsers = BASEURL+"/jwt/orders/users/"; //get all orders by id user
    public String PutOrdersByIDOrders = BASEURL+"/jwt/orders/update/"; //update order by  id order for admin only
}
