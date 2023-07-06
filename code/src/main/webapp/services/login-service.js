export default class LoginService {

    async login() {
        let data = {
            "username": document.getElementById("usernameid").value,
            "password": document.getElementById("passwordid").value
        };

        let resp = await fetch("/restservices/login", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })

        if (resp.status == 200){
            return await resp.json().then(jsonResp => {localStorage.setItem("myToken", jsonResp.token);  window.location.href = "/quiz.html";});
        } else if (resp.status == 406){
            alert("uw gegevens zijn onjuist");
        } else {
            console.error("something when wrong, code: " + resp.status);
        }
    }

    async newlogin(){
        let data = {
            "username": document.getElementById("usernameid").value,
            "password": document.getElementById("passwordid").value,
            "email": document.getElementById("emailid").value
        };

        let resp = await fetch("/restservices/login/new", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })

        if (resp.status == 200){
            return await resp.json().then(jsonResp => {localStorage.setItem("myToken", jsonResp.token);  window.location.href = "/quiz.html";});
        } else if (resp.status == 409){
            alert("gebruikers naam niet beschrikbaar")
        } else {
            console.error("something when wrong, code: " + resp.status);
        }
    }

    async validate(){
        let resp = await fetch("/restservices/login/check", {
            method: "GET",
            headers: {
                "Authorization": window.localStorage.getItem("myToken"),
                'Content-Type': 'application/json'
            }
        })

        if (resp.status == 200){
            return await resp.json();
        } else {
            console.error("something when wrong, code: " + resp.status);
        }
    }
}