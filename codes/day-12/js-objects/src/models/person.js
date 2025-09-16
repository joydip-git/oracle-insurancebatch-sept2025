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
