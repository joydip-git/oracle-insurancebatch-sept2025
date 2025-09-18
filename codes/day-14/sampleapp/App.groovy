class App {
    static void main(args) {
        /*
        println 'hello world' 
        def list = [1, 2, 3, 4]

        def calculator = new Calculator()
        def res = calculator.add(12,3)
        println res  
               */

        JsonParserCls cls = new JsonParserCls();
        cls.parseJsonData(); 
 
        HttpRequestManagerCls manager = new HttpRequestManagerCls();
        manager.sendGetRequest();
    }
}
