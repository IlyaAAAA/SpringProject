"use strict";


function add() {

    let saleAmount = document.querySelector("#salesIdAmount").value;
    let saleQuantity = document.querySelector("#salesIdQuantity").value;
    let saleSaleDate = document.querySelector("#salesIdSaleDate").value;
    let saleWarehouseId = document.querySelector("#salesIdWarehouse").value;

    let warehouse = {
        id: saleWarehouseId
    }

    let sale = {
        amount: saleAmount,
        quantity: saleQuantity,
        saleDate: saleSaleDate,
        warehouse: warehouse
    }

    getWarehouseQuery("/warehouses/" + warehouse.id, warehouse, sale, (warehouse, sale) => {
        sale.warehouse = warehouse;
        let json = JSON.stringify(sale);
        postQuery("/sales/create", json);

    });
}

function update() {
    let saleId = document.querySelector("#salesIdUpdate").value;
    let saleAmount = document.querySelector("#salesAmountUpdate").value;
    let saleQuantity = document.querySelector("#salesQuantityUpdate").value;
    let saleSaleDate = document.querySelector("#salesSaleDateUpdate").value;
    let saleWarehouseId = document.querySelector("#salesWarehouseUpdate").value;



    let warehouse = {
        id: saleWarehouseId
    }

    let sale = {
        amount: saleAmount,
        quantity: saleQuantity,
        saleDate: saleSaleDate,
        warehouse: warehouse
    }

    getWarehouseQuery("/warehouses/" + warehouse.id, warehouse, sale, (warehouse, sale) => {
        sale.warehouse = warehouse;
        let json = JSON.stringify(sale);

        getSale("/sales/" + saleId, saleId, () => {
            putQuery("/sales/" + saleId, json);
        });
    });
}

function remove() {
    let saleId = document.querySelector("#salesIdDelete").value;

    getSale("/sales/" + saleId, saleId, () => {
        delQuery("/sales/" + saleId);
    });
}

function getWarehouseQuery(url, warehouse, sale, callback) {

    let xhr = new XMLHttpRequest();

    xhr.open("GET", url, true);
    xhr.send();
    xhr.onload = () => {
        if (xhr.status === 200) {

            try {

                warehouse = JSON.parse(xhr.response);
                callback(warehouse, sale);
            }
            catch (err) {
            }
        }
        else {
            alert("Failed to find expense item with id " + warehouse.id);
        }
    }
}

function getSale(url, sale, callback) {

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
            alert("Failed to find sale with id: " + sale);
        }
    }
}


