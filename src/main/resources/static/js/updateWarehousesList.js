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
    let warehouseID = document.querySelector("#warehousesIdUpdate").value;
    let warehouseName = document.querySelector("#warehousesNameUpdate").value;
    let warehouseQuantity = document.querySelector("#warehousesQuantityUpdate").value;
    let warehouseAmount = document.querySelector("#warehousesAmountUpdate").value;



    let warehouse = {
        name: warehouseName,
        quantity: warehouseQuantity,
        amount: warehouseAmount
    }



    let json = JSON.stringify(warehouse);

    putQuery("/warehouses/" + warehouseID, json);
}

function remove() {
    let warehouseId = document.querySelector("#warehousesIdDelete").value;
    delQuery("/warehouses/" + warehouseId);
}


