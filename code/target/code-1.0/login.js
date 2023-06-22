import LoginService from "./services/login-service.js";

let loginService = new LoginService();

window.makeacc = function makeacc(event){
    let button = event.target;

    button.blur();

    if (button.innerHTML == "new acc"){
        button.innerHTML = "cancel"
        document.getElementById("emailid").style = "height: 10%; padding: 4px; margin:5px";
        document.getElementById("emailid").tabIndex = "0";
        document.getElementById("emailid").required = true;
    } else if (button.innerHTML == "cancel"){
        button.innerHTML = "new acc"
        document.getElementById("emailid").style = "height: 0px; padding: 0px; margin:0px";
        document.getElementById("emailid").tabIndex = "-1";
        document.getElementById("emailid").required = false;
    }
}

document.forms.form.addEventListener('submit', event => {
    event.submitter.blur();
    event.preventDefault();
    loginService.login()
})