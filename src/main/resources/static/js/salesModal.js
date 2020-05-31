"use strict";

function getModal(id) {

    let warehouse = {
        id: id
    }
    getWarehouse("/warehouses/" + warehouse.id, warehouse);
}


function getWarehouse(url, warehouse) {

    let xhr = new XMLHttpRequest();

    xhr.open("GET", url, true);
    xhr.send();
    xhr.onload = () => {
        if (xhr.status === 200) {

            try {

                warehouse = JSON.parse(xhr.response);
                document.querySelector("#amountId").value = warehouse.name;
                document.querySelector("#quantityId").value = warehouse.quantity;
                document.querySelector("#saleDateId").value = warehouse.amount;
            }
            catch (err) {
                alert("Failed to find expense item with id " + warehouse.id);
            }
        }
        else {
            alert("FAIL");
        }
    }
}