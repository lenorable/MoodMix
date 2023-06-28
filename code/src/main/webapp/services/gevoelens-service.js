export default class GevoelensService {

    async saveGevoel(data) {
        let resp = await fetch("restservices/settings", {
            method: "POST",
            headers: {
                "Authorization": window.localStorage.getItem("myToken"),
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })

        if (resp.status == 200){
            return await resp.json().then(jsonResp => {window.location.href = "./recommended.html";});
        } else {
            console.error("something when wrong, code: " + resp.status); //dit heeft zo ver ik me nu kan bedenken geen nut
        }
    }
}