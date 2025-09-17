import { Developer } from "./models/developer.js";
import { Hr } from "./models/hr.js";
import { employees } from "./repository/employees.js";

//global scope code
let choice = 1;

//other methods
function createEmployee() {
  try {
    let employee;
    var id = parseInt(document.getElementById("txtId").value);
    var name = document.getElementById("txtName").value;
    var basic = parseFloat(document.getElementById("txtBasic").value);
    var da = Number(document.getElementById("txtDa").value);
    var hra = Number(document.getElementById("txtHra").value);
    var extra = Number(document.getElementById("txtExtra").value);

    switch (choice) {
      case 1:
        employee = new Developer(id, name, basic, da, hra, extra);
        break;

      case 2:
        employee = new Hr(id, name, basic, da, hra, extra);
        break;

      default:
        employee = null;
        break;
    }

    if (employee != null) employee.calculateSalary();

    return employee;
  } catch (error) {
    document.getElementById("msgSpan").innerText = error.message;
  }
}

function addRecord(employee) {
  try {
    let found = employees.find((e) => e.id === employee.id);
    if (found)
      throw new Error(`employee with id ` + found.id + " already exists");

    employees.push(employee);
    document.getElementById("msgSpan").innerText =
      "employee added successfully";
    console.log(employees);
  } catch (error) {
    document.getElementById("msgSpan").innerText = error.message;
  }
}

//global scope code
var extra = document.getElementById("lblExtra");
var btnAdd = document.getElementById("btnAdd");
var radioDev = document.getElementById("radioDev");
var radioHr = document.getElementById("radioHr");

lblExtra.innerText = "Incentive";
radioDev.checked = true;

radioDev.addEventListener("change", (e) => {
  if (e.target.checked) {
    choice = 1;
    extra.innerText = `Incentive`;
  }
});
radioHr.addEventListener("change", (e) => {
  if (e.target.checked) {
    choice = 2;
    extra.innerText = `Gratuity`;
  }
});

btnAdd.addEventListener("click", () => {
  var decision = window.confirm("would you like to add the record?");
  if (decision) {
    const employee = createEmployee();
    addRecord(employee);
  }
});
