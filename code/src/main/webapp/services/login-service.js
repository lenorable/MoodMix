export default class LoginService {

    async login() {
        let data = {
            "username": document.getElementById("usernameid").value,
            "password": document.getElementById("passwordid").value
        };

        let resp = await fetch("restservices/login", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })

        if (resp.status == 200){
            return await resp.json().then(jsonResp => {localStorage.setItem("myToken", jsonResp.token);  window.location.href = "./index.html";});
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

        let resp = await fetch("restservices/login/new", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })

        if (resp.status == 200){
            window.location.href = "./index.html"
        } else {
            console.error("something when wrong, code: " + resp.status);
        }
    }
}