"use strict";

function add() {

    let expenseItemName = document.querySelector("#expenseItemNameIdAdd").value;

    let expenseItem = {
        name: expenseItemName
    }

    let json = JSON.stringify(expenseItem);
    postQuery("/expenseItems/create", json);
}

function update() {
    let expenseItemId = document.querySelector("#expenseItemIDId").value;
    let expenseItemName = document.querySelector("#expenseItemNameIdUpdate").value;

    let expenseItem = {
        name: expenseItemName
    }

    let json = JSON.stringify(expenseItem);

    getExpenseItem("/expenseItems/" + expenseItemId, expenseItemId, () => {
        putQuery("/expenseItems/" + expenseItemId, json);
    });
}

function remove() {
    let expenseItemId = document.querySelector("#expenseItemNameIdDelete").value;

    getExpenseItem("/expenseItems/" + expenseItemId, expenseItemId, () => {
        delQuery("/expenseItems/" + expenseItemId);
    });
}

function getExpenseItem(url, expenseItem, callback) {

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
            alert("Failed to find expense item with id: " + expenseItem)
        }
    }
}