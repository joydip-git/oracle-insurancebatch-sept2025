package helloworldapp

//@CompileDynamic
//import java.util.*;

println 'hello groovy script'
println('hello grovvy script!!!')

int x = 10
//x='oracle' //no compilation error, but runtime error (since x is strictly typed)
println x

def name = 'Joydip'
name = 100 //no compilation error and runtime error (since name is optionally/dynamically typed)
println name

def first = 'hello'
def second = 'Hello'
def third = '''hello
    world
    again'''

println first
println second
println third
println second[2]
println second[0..2]

println first.length()

def numbers = 1..5
println '\n range of inclusive values \n'
for (def i in numbers){
    println i
}
println '\n'
println numbers.get(2)
println numbers.contains(20)

//open ended or exclusive
def values = 1..<5
println '\n range of exclusive values \n'
for (def i in values){
    println i
}

def chars = 'a'..'f'
println '\n range of chars \n'
for (def i in chars){
    println i
}

def descrange = 10..1
def revchars = 'f'..'a'

def marks = 78
switch (marks) {
    case 90..100:
        println 'Grade: A+'
        break

    case 80..<90:
        println 'Grade: A'
        break

    case [75, 76, 77, 78, 79]:
        println 'Grade: B'
        break

    case 30..<75:
        println 'Grade: C'
        break

    default:
        println 'invalid'
        break
}

def list = [1, 2, 3, 4, 5]
list.add(13)
println list.get(2)

def map = [:]
map.put(1,"oracle")
map.put(0,"Bellandur")
map.put(2,"Bangalore")

for(def keyvaluepir in map){
	println keyvaluepir
}
