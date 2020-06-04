"use strict";


function add() {

    let warehouseName = document.querySelector("#warehousesIdName").value;
    let warehouseQuantity = document.querySelector("#warehousesIdQuantity").value;
    let warehouseAmount = document.querySelector("#warehousesIdAmount").value;

    let warehouse = {
        name : warehouseName,
        quantity: warehouseQuantity,
        amount: warehouseAmount
    }
    let json = JSON.stringify(warehouse);
    postQuery("/warehouses/create", json);
}

function update() {
    let warehouseId = document.querySelector("#warehousesIdUpdate").value;
    let warehouseName = document.querySelector("#warehousesNameUpdate").value;
    let warehouseQuantity = document.querySelector("#warehousesQuantityUpdate").value;
    let warehouseAmount = document.querySelector("#warehousesAmountUpdate").value;



    let warehouse = {
        name: warehouseName,
        quantity: warehouseQuantity,
        amount: warehouseAmount
    }



    let json = JSON.stringify(warehouse);

    getWarehouse("/warehouses/" + warehouseId, warehouseId, () => {
    putQuery("/warehouses/" + warehouseId, json);
    });
}

function remove() {
    let warehouseId = document.querySelector("#warehousesIdDelete").value;

    getWarehouse("/warehouses/" + warehouseId, warehouseId, () => {
        delQuery("/warehouses/" + warehouseId);
    });
}

function getWarehouse(url, warehouse, callback) {

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
            alert("Failed to find warehouse with id: " + warehouse)
        }
    }
}
