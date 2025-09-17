import { Employee } from "./employee.js";

export class Developer extends Employee {
  constructor(id, name, basic, da, hra, incentive) {
    super(id, name, basic, da, hra);
    this.incentivePayment = incentive;
  }
  calculateSalary() {
    super.calculateSalary();
    this.totalPayment += this.incentivePayment;
  }
}
