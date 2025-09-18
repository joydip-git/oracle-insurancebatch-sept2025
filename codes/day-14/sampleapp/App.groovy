import groovy.json.JsonSlurper
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class App {
    static void main(args) {
        /*
        println 'hello world' 
        def list = [1, 2, 3, 4]

        def calculator = new Calculator()
        def res = calculator.add(12,3)
        println res  
              

        JsonParserCls cls = new JsonParserCls();
        cls.parseJsonData(); 
         */

         //sendGetRequestForAPost()
         sendGetRequestForPosts()
 
    }
    static void sendGetRequestForAPost(){
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

    static void sendGetRequestForPosts(){
         HttpRequest request = HttpRequest
                .newBuilder()
                .uri(new URI("https://jsonplaceholder.typicode.com/posts"))
                .GET()
                .build();

        HttpClient client = HttpClient.newBuilder().build();
                
        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
        println(response.statusCode());
        //println(response.body());

        JsonSlurper jsonSlurper = new JsonSlurper();
        def posts = jsonSlurper.parseText(response.body());
        for (def post in posts) {
            println post
        }
    }
}
