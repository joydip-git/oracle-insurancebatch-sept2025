import groovy.json.JsonSlurper

public class JsonParserCls{
    void parseJsonData(){
        def jsonSlurper = new JsonSlurper()
        def jsonStringifiedData = '{ "name":"anil", "id":1, "salary":1000}'
        def groovyObj = jsonSlurper.parseText(jsonStringifiedData)

        println groovyObj
        println groovyObj.name      
        println groovyObj.id  

        def data = '''[
            {"name":"anil","id":1},
            {"name":"sunil","id":2}
        ]'''
        def parsedData = jsonSlurper.parseText(data)    
        println parsedData

    }
}