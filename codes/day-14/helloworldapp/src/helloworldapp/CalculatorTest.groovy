class CalculatorTest extends GroovyTestCase{
    void testadd(){
        def result  = new Calculator().add(12,3)
        assertEquals(15,result)
    }
}