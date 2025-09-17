const obj = {
  id: 1,
  name: "anil",
  friends: ["sunil", "joydip"],
};

//... -> spread operator (makes shallow copy every property and its value from another object)
const copy = {
  ...obj,
  salary: 1000,
  name: "anil kumar",
};

console.log(obj);
console.log(copy);

const printUtility = {
  print: function () {
    console.log("print");
  },
};

const showUtility = {
  show: function () {
    console.log("show");
  },
};

const utility = {
  ...printUtility,
  ...showUtility,
};

console.log(utility);

const first = [1, 2, 3, 4];
const second = [6, 7, 8, 9];

const numbers = [...first, 5, ...second, 0];
console.log(numbers);
