//2. constructor function
// function person(idVal, nameVal, salaryVal) {
//   this.id = idVal;
//   this.name = nameVal;
//   this.salary = salaryVal;
//   this.show = function () {
//     return `${this.id}, ${this.name}, ${this.salary}`;
//   };
// }

//2015
class Person {
  constructor(idVal, nameVal, salaryVal) {
    this.id = idVal;
    this.name = nameVal;
    this.salary = salaryVal;
  }
  show() {
    return `${this.id}, ${this.name}, ${this.salary}`;
  }
}

class Trainer extends Person {
  constructor(idVal, nameVal, salaryVal, subjectVal) {
    super(idVal, nameVal, salaryVal);
    this.subject = subjectVal;
  }
  show() {
    return `${super.show()}, ${this.subject}`;
  }
}

const joydipTrainer = new Trainer(1, "joydip", 1000, "JavaScript");
//console.log(joydipTrainer.show());

const sunilTrainer = new Trainer(2, "sunil", 2000, "Java");
//console.log(sunilTrainer.show());

const people = [joydipTrainer, sunilTrainer];
// for (const person of people) {
//     console.log(person.show());
// }

// people.forEach(
//     function (p) {
//         console.log(p.show());
//     }
// )

console.log("all");
people
    .sort((p1, p2) => p2.name.localeCompare(p1.name))
    .forEach((p) => console.log(p.show()));

console.log("filtered");
const filteredPeople = people.filter((p) => p.salary > 1000);
filteredPeople.forEach((p) => console.log(p.show()));
