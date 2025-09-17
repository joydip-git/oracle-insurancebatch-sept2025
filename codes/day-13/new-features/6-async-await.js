const divide = async (a, b) => {
  const res = a / b;
  if (res == Infinity) {
    const err = new Error("divisor should not be 0");
    throw err;
  }
  return res;
};

const add = (a, b) => a + b;

//waits for the divide method promise to be "resolved"
//and blocks the code written after that
//means the codes written after the line with await will be executed when the divide method promise is resolved
//await keyword can be used inside a method declared with async keyword
//global function/scope is not asynchronous hence write await code inside a separate async method
async function callDivide() {
  try {
    const divRes = await divide(12, 3);
    console.log(divRes);
  } catch (error) {
    console.log(error);
  } finally {
    console.log("other task");
  }
}
callDivide();

const addRes = add(12, 3);
console.log(addRes);
