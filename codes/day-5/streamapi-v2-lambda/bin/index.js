function add(a, b) {
  return a + b;
}

function invoker(fnRef, a, b) {
  console.log(fnRef(a, b));
}

invoker(add, 12, 13);
