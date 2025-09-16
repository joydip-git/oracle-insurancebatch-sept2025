const id = Number(window.prompt("enter id: ", 0));
console.log(id);

const joydipTrainer = new Trainer(id, "joydip", 1000, "JavaScript");

const sunilTrainer = new Trainer(2, "sunil", 2000, "Java");

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
