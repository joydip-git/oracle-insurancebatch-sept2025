var x = 10;
var name = "Joydip";
var isManager = true;
var marks = 23.45;
var anilObj = {
  id: 1,
  name: "anil",
  salary: 1000,
  show: function () {
    return this.id + " " + this.name + " " + this.salary;
  },
};

console.log(anilObj.name);
console.log(anilObj["salary"]);
console.log(anilObj.show());
//console.log(anilObj['show']());

console.log(x, typeof x);
console.log(name, typeof name);
console.log(isManager, typeof isManager);
console.log(marks, typeof marks);
console.log(anilObj, typeof anilObj);

//undefined
var y;
console.log(y, typeof y);
//truthy or falsy expression
//if (y !== undefined) {
if (y) {
  console.log("value of y: " + y);
} else {
  console.log("no value");
}

//NaN
var z = x + y;
console.log(z, typeof z);

//NULL
var ref = null;
console.log(ref, typeof ref);

//Infinity
var res = x / 0;
console.log(res, typeof res);

var choice = 1;
switch (choice) {
  case 1:
    break;

  default:
    break;
}

while (x > 0) {
  console.log(x);
  x--;
}
do {
  console.log(x);
  x--;
} while (x > 0);

for (var i = 0; i < 2; i++) {
  console.log(i);
}

//var numbers = new Array(1, 2, 3, 4);
var numbers = [10, 20, 30, 40];

//for..in loop (helps you to iterate through a collection, including object and returns the keys/properties/index positions from that collection or object or array)
console.log("elements from array using for..in loop");
for (var index in numbers) {
  console.log("value from index: " + index + " is: " + numbers[index]);
}
//for..of loop (helps you to iterate through a collection, including object and returns the values/elements from that collection or object or array)
console.log("elements from array using for..of loop");
for (var element of numbers) {
  console.log("value: " + element);
}
