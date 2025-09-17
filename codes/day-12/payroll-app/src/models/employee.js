export class Employee {
  constructor(id, name, basic, da, hra) {
    this.id = id;
    this.name = name;
    this.basicPayment = basic;
    this.daPayment = da;
    this.hraPayment = hra;
    this.totalPayment = 0;
  }
  calculateSalary() {
    this.totalPayment = this.basicPayment + this.daPayment + this.hraPayment;
  }
}
