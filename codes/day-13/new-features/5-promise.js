const divide = (a, b) => {
  const p = new Promise(
    //executor function
    function (resolveFn, rejectFn) {
      const res = a / b;
      if (res == Infinity) {
        const err = new Error("divisor should not be 0");
        rejectFn(err.message);
      }
      resolveFn(res);
    }
  );
  return p;
};

const add = (a, b) => a + b;

const divPromise = divide(12, 3);
//then method is executed when promise is "resolved"
//pass a method to then method as an argument, which will be called by promise as soon as it's state property is updated to "resolved"
//catch method is executed when promise is "rejected"
//pass a method to catch method as an argument, which will be called by promise as soon as it's state property is updated to "rejected"
//finally method is executed anyway
//pass a method to finally method as an argument, which will be called by promise in any case (success/failure) even if there is error
divPromise
  .then(function (divResult) {
    console.log(divResult);
  })
  .catch(function (err) {
    console.log(err);
  })
  .finally(function () {
    console.log("clean up");
  });

const addRes = add(12, 3);
console.log(addRes);
