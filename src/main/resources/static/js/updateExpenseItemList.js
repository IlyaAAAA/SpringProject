"use strict";

// function updateItemList(expenseItemList) {
//     if (expenseItemList != null) {
//         let tbody = document.querySelector("#tableBody");
//
//         for (let i = 0; i < expenseItemList.length; i++) {
//             let tr = "<tr>";
//             let th = '<th scope="row">' + expenseItemList[i].id + '</th>';
//             let td = '<td>' + expenseItemList[i].name + '</td>'
//             tr += th;
//             tr += td;
//             tr += '</tr>'
//
//             tbody.innerHTML += tr;
//         }
//     }
// }

// function getListQuery() {
//     let xhr = new XMLHttpRequest();
//
//     xhr.open("GET", "/expenseItems/getAll", true);
//     xhr.send();
//     xhr.onload = () => {
//         if (xhr.status === 200) {
//
//             try {
//                 let expenseItemList = JSON.parse(xhr.response);
//                 updateItemList(expenseItemList)
//             }
//             catch (err) {
//                 console.log("error");
//             }
//         }
//         else {
//             alert("FAIL");
//         }
//     }
// }

//getListQuery()

function add() {

    let expenseItemInput = document.querySelector("#expenseItemNameIdAdd").value;
    postQuery(expenseItemInput, () => getListQuery());
}

function update() {
    let idInput = document.querySelector("#expenseItemIDId").value;
    let nameInput = document.querySelector("#expenseItemNameIdUpdate").value;

    let expenseItem = {
        name: nameInput
    }

    let json = JSON.stringify(expenseItem);

    putQuery(idInput, json);
}

function remove() {
    let deleteIdInput = document.querySelector("#expenseItemNameIdDelete").value;
    delQuery(deleteIdInput);
}



function putQuery(id, json) {

    let xhr = new XMLHttpRequest();
    xhr.open("PUT", '/expenseItems/' + id, true);
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhr.send(json);
}

function delQuery(deleteIdInput) {
    let xhr = new XMLHttpRequest();
    xhr.open("DELETE", '/expenseItems/' + deleteIdInput, true);
    xhr.send();
}

function postQuery(name, callback) {

    let json = JSON.stringify(name);
    let xhr = new XMLHttpRequest();
    xhr.open("POST", '/expenseItems/create', true);
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhr.send(json);

    xhr.onload = () => {
        if (xhr.status === 200) {
            alert("success");
            callback();
            alert("success");
        }
    }
}