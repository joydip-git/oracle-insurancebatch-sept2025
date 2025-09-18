var greeting = (name) => "hello, " + name;
show(greeting, "ribha");

function show(lambda, value){
   console.log(lambda(value))
}