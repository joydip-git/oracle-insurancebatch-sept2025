class Trainer extends Person {
  constructor(idVal, nameVal, salaryVal, subjectVal) {
    super(idVal, nameVal, salaryVal);
    this.subject = subjectVal;
  }
  show() {
    return `${super.show()}, ${this.subject}`;
  }
}
