//1. object-literal syntax
const anilObj = {
  id: 1,
  nane: "anil",
  salary: 1000,
  show: function () {
    return `${this.id}, ${this.name}, ${this.salary}`;
  },
};

//2. constructor function
function person(idVal, nameVal, salaryVal) {
  this.id = idVal;
  this.name = nameVal;
  this.salary = salaryVal;
  this.show = function () {
    return `${this.id}, ${this.name}, ${this.salary}`;
  };
}

const anilPerson = new person(1, "anil", 1000);
const sunilPerson = new person(2, "sunil", 2000);

console.log(anilPerson.show());
console.log(sunilPerson.show());
