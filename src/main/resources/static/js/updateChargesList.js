"use strict";

function add() {

    let chargeAmount = document.querySelector("#chargesIdAmount").value;
    let chargeChargeData = document.querySelector("#chargesIdChargeData").value;
    let chargeExpenseItemId = document.querySelector("#chargesIdExpenseItem").value;

    let expenseItem = {
        id: chargeExpenseItemId
    }

    let charge = {
        amount: chargeAmount,
        chargeDate: chargeChargeData,
        expenseItem: expenseItem
    }
    console.log();
    getExpenseItemQuery("/expenseItems/" + expenseItem.id, expenseItem, charge,  (expenseItem, charge) => {
        charge.expenseItem = expenseItem;
        let json = JSON.stringify(charge);
        postQuery("/charges/create", json);
    });
}

function update() {
    let chargesId = document.querySelector("#chargesIdUpdate").value;
    let chargeAmount = document.querySelector("#chargesAmountUpdate").value;
    let chargeChargeDate = document.querySelector("#chargesChargeDataUpdate").value;
    let chargeExpenseItemId = document.querySelector("#chargesExpenseItemUpdate").value;



    let expenseItem = {
        id: chargeExpenseItemId
    }

    let charge = {
        amount: chargeAmount,
        chargeDate: chargeChargeDate,
        expenseItem: expenseItem
    }

    getExpenseItemQuery("/expenseItems/" + expenseItem.id, expenseItem, charge, (expenseItem, charge) => {
        charge.expenseItem = expenseItem;
        let json = JSON.stringify(charge);

        getCharge("/charges/" + chargesId, chargesId, () => {
            putQuery("/charges/" + chargesId, json);
        });
    });
}

function remove() {
    let chargesId = document.querySelector("#chargesIdDelete").value;

    getCharge("/charges/" + chargesId, chargesId, () => {
        delQuery("/charges/" + chargesId);
    })
}

function getExpenseItemQuery(url, expenseItem, charge, callback) {

    let xhr = new XMLHttpRequest();

    xhr.open("GET", url, true);
    xhr.send();
    xhr.onload = () => {
        if (xhr.status === 200) {

            try {

                expenseItem = JSON.parse(xhr.response);
                callback(expenseItem, charge);
            }
            catch (err) {
            }
        }
        else {
            alert("Failed to find expense item with id " + expenseItem.id);
        }
    }
}

function getCharge(url, charge, callback) {

    let xhr = new XMLHttpRequest();

    xhr.open("GET", url, true);
    xhr.send();
    xhr.onload = () => {
        if (xhr.status === 200) {

            try {
                callback();
            } catch (err) {
            }
        } else {
            alert("Failed to find charge with id: " + charge);
        }
    }
}
