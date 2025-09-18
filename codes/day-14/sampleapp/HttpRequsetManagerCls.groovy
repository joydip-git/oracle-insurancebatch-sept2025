import groovy.json.JsonSlurper
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class HttpRequestManagerCls{
    void sendGetRequest(){
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(new URI("https://jsonplaceholder.typicode.com/posts/1"))
                .GET()
                .build();

        HttpClient client = HttpClient.newBuilder().build();
                
        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
        println(response.statusCode());
        println(response.body());

        JsonSlurper jsonSlurper = new JsonSlurper();
        println jsonSlurper.parseText(response.body());
    }
}