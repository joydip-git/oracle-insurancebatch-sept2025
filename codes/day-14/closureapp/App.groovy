//closure
Closure ano = { num -> println num}
ano(10)

Closure<Integer> add = { def a, def b -> a+b}
println add(12,13)

Closure<Boolean> isEven = { num -> num%2 == 0 }
println isEven.call(23)

def greeting = { name -> "hello, "+name}
//def greeting = { "hello, ${name}!"}
println greeting('khushi')

show(greeting,'ribha')

void show(lambda, value){
   println lambda.call(value)
}