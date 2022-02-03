package sn.ept.git.dic2.hello.config;

public class ApiEndpoint {
    private ApiEndpoint(){};
    public static String BASE = "http://185.98.128.121";
    public static ApiService getApiClient(){
        return ApiClientInstance.getClient(BASE).create(ApiService.class);
    }
}
