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

    putQuery("/expenseItems/" + expenseItemId, json);
}

function remove() {
    let expenseItemId = document.querySelector("#expenseItemNameIdDelete").value;

    delQuery("/expenseItems/" + expenseItemId);
}