"use strict";

window.addEventListener('DOMContentLoaded', (event) => {
    getQuery();
});

function getQuery() {
    let xhr = new XMLHttpRequest();

    xhr.open("GET", "/login/userInfo", true);
    xhr.send();
    xhr.onload = () => {
        if (xhr.status === 200) {

            try {
                let user = JSON.parse(xhr.response);
                document.querySelector("#userId").hidden = false;
                document.querySelector("#userId").text = user.username;
                setLogOut();
            }
            catch (err) {
                // document.querySelector("#userId").hidden = true;
                setLogIn();
            }
        }
        else {
            alert("FAIL");
        }
    }
}

function setLogIn() {
    document.querySelector("#authId").text = "Log in";
    document.querySelector("#authId").href = "/login";
}

function setLogOut() {
    document.querySelector("#authId").text = "Log out";
    document.querySelector("#authId").href = "/logout";
}