import LoginService from "../services/login-service.js";

let loginService = new LoginService();

window.makeacc = function makeacc(event) {
    let button = event.target;

    button.blur();

    if (button.innerHTML == "new acc") {
        button.innerHTML = "cancel"
        document.getElementById("emailid").style = "height: 10%; padding: 4px; margin:5px";
        document.getElementById("emailid").tabIndex = "0";
        document.getElementById("emailid").required = true;
    } else if (button.innerHTML == "cancel") {
        button.innerHTML = "new acc"
        document.getElementById("emailid").style = "height: 0px; padding: 0px; margin:0px";
        document.getElementById("emailid").tabIndex = "-1";
        document.getElementById("emailid").required = false;
    }
}

try {
    document.forms.form.addEventListener('submit', event => {
        event.submitter.blur();
        event.preventDefault();
    
        if (document.getElementById("emailid").required) {
            loginService.newlogin();
        } else {
            loginService.login();
        }
    })
} catch {
    console.log("cant find form");
}

window.logout = function logout() {
    localStorage.removeItem("myToken");
    window.location.href = "/login.html"
}

window.isLoggedIn = function isLoggedIn() {
    if (localStorage.getItem("myToken") != null) {
        return true;
    } else {
        return false;
    }
}

window.checkLogin = async function checkLogin() {
    let resp = await loginService.validate();
    if (resp.msg == "true") {
        if (window.location.href.endsWith("login.html")){
            alert("you're already logged in.");
            window.location.href = "/quiz.html";
        }
    } else {
        if (window.location.href.endsWith("login.html") == false){
            window.location.href = "/login.html";
        }
    }
}

//to check login status
window.addEventListener("load", checkLogin());