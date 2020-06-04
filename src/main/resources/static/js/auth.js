function signIn() {

    let username = document.getElementById("loginInput").value
    let password = document.getElementById("passwordInput").value

    let user = {
        username: username,
        password: password,
        role: "role"
    };

    if (username.length != 0 && password.length != 0) {
        postQuery(user)
    }
    else {
        alert("Заполните поля!")
    }
}

function postQuery(user) {

    let json = JSON.stringify(user)
    let xhr = new XMLHttpRequest();

    xhr.open("POST", '/login/signIn', true)
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhr.send(json);
    xhr.onload = () => {
        if (xhr.status === 200) {

            try {
                window.location.reload();
            }
            catch (err) {
                alert("Failed to sign in!");
            }
        }
        else {
            alert("FAIL");
        }
    }
}