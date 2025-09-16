const numberValues = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

function generateOptions(select) {
  numberValues.forEach((num) => {
    const option = document.createElement("option");
    option.value = num;
    option.text = num;
    select.appendChild(option);
  });
}
function changeHeading() {
  var refToHeader = window.document.getElementById("mainHeader");

  refToHeader.innerText =
    "Find Nth Fibonacci of a value selected from drop-down";

  const select = document.getElementById("ddlNumbers");

  select.addEventListener("change", () => {
    const options = select.options;
    const selectedOption = options[select.selectedIndex];
    window.alert(`selected text: ${selectedOption.text}`);
  });
    
  generateOptions(select);
}

//attaching an event handler or listener for an event
window.addEventListener("DOMContentLoaded", changeHeading);
