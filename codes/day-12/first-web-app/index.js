//declaration style
function add(a, b) {
  return a + b;
}

console.log(add(10, 20));
console.log(add("anil", "gupta"));

//expression style
var subtract = function (a, b) {
  return a - b;
};

console.log(subtract(12, 3));

//arrow function for expression style
var multiply = (a, b) => a * b;
console.log(multiply(12, 2));

//console.log("value of multipliaction is " + multiply(12, 3));
//templated string or string interpolation
console.log(`value of multiplication is ${multiply(12, 3)}`);
