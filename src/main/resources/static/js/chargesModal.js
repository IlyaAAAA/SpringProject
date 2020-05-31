"use strict";

function getModal(id) {

    let expenseItem = {
        id: id
    }

    getExpenseItem("/expenseItems/" + expenseItem.id, expenseItem);
}


function getExpenseItem(url, expenseItem) {

    let xhr = new XMLHttpRequest();

    xhr.open("GET", url, true);
    xhr.send();
    xhr.onload = () => {
        if (xhr.status === 200) {

            try {

                expenseItem = JSON.parse(xhr.response);
                document.querySelector("#expenseItemNameIdAdd").value = expenseItem.name;
            }
            catch (err) {
                alert("Failed to find expense item with id " + expenseItem.id);
            }
        }
        else {
            alert("FAIL");
        }
    }
}
