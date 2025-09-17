//use ... with marks
//here this ... is know as rest operator
//here 'marks' is an array which can accept any number of parameters or all the remaining parameters after the name
//hence 'marks' is an rest array, means, remaining or the rest of the parameters after the fixed parameter, name, will be stored in that array
//only one such array can be declared as part of the function's arguments list and that should be the last argument
//the rest operator can be used to declare ONLY an array as part of the function argument, which can accept/store any number of data. it can be used to declare array as local variable
function calculateAverage(name, id, ...marks) {
  let sum = 0;
  let avg = 0;
  if (marks.length > 0) {
    for (let index = 0; index < marks.length; index++) {
      const element = marks[index];
      sum += element;
    }
    avg = sum / marks.length;
    return `${name}, with id: ${id}, got average score of ${avg} in ${marks.length} exams`;
  } else
    return `${name}, with id: ${id}, did not appear in any exam and the average score is ${avg}`;
}

console.log(calculateAverage("anil", 100, 10, 20, 30));
console.log(calculateAverage("sunil", 101, 40, 50, 60, 70, 80));
console.log(calculateAverage("joydip", 102, 75, 85));
console.log(calculateAverage("mahesh", 102));

//const arr = ...marks;
