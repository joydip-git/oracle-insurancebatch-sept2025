import { Employee } from "./employee.js";

export class Hr extends Employee {
  constructor(id, name, basic, da, hra, gratuity) {
    super(id, name, basic, da, hra);
    this.gratuityPayment = gratuity;
  }
  calculateSalary() {
    super.calculateSalary();
    this.totalPayment += this.gratuityPayment;
  }
}
