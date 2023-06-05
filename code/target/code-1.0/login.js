function login() {
    var naamin = document.getElementById("usernameid").value;
    var passin = document.getElementById("passwordid").value;

    let data = { // moet "shoppinglist" tussen haaljes?
        "username": naamin,
        "password": passin
    };

    fetch("restservices/login", {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => {
            if (response.status === 200) {
                response.json().then(myjson => {
                    console.log(myjson.token)
                    localStorage.setItem("myToken", myjson.token); //gaat niet leeg na het sluiten van browser
                })
            }
        })
}