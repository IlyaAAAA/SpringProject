"use strict";

function putQuery(url, json) {

    let xhr = new XMLHttpRequest();
    xhr.open("PUT", url, true);
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhr.send(json);
    xhr.onload = () => {
        if (xhr.status === 200) {
            window.location.reload();
        }
    }
}

function delQuery(url) {
    let xhr = new XMLHttpRequest();
    xhr.open("DELETE", url, true);
    xhr.send();
    xhr.onload = () => {
        if (xhr.status === 200) {
            window.location.reload();
        }
    }
}

function postQuery(url, json) {

    let xhr = new XMLHttpRequest();
    xhr.open("POST", url, true);
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhr.send(json);
    xhr.onload = () => {
        if (xhr.status === 200) {
            window.location.reload();
        }
    }
}