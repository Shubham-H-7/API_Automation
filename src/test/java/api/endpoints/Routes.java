package api.endpoints;

public class Routes {
    public static String baseUrl = "https://petstore.swagger.io/v2";

    //User module
    public  static  String post_url = baseUrl+"/user";
    public static  String get_user = baseUrl+"/user/{username}";
    public static  String update_user = baseUrl+"/user/{username}";
    public static  String delete_user = baseUrl+"/user/{username}";
}
