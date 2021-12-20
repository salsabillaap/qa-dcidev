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
}
