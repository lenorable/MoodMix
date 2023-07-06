export default class QueService {
    async updateQue(bestandNaam){
        let resp = await fetch("/restservices/settings/que", {
            method: "POST",
            headers: {
                "Authorization": window.localStorage.getItem("myToken"),
                'Content-Type': 'application/json'
            },
            body: bestandNaam
        })

        if (resp.status == 200){
            alert("added to que")
            return await resp.json();
        } else {
            console.error("something when wrong, code: " + resp.status);
        }
    }
    
    async getQue(){
        let resp = await fetch("/restservices/settings/que", {
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

    // async nextQueItem(){
    //     let resp = await fetch("/restservices/settings/que/next", {
    //         method: "PUT",
    //         headers: {
    //             "Authorization": window.localStorage.getItem("myToken"),
    //             'Content-Type': 'application/json'
    //         }
    //     })

    //     if (resp.status == 200){
    //         // alert("que reseted")
    //         return await resp.json();
    //     } else {
    //         console.error("something when wrong, code: " + resp.status);
    //     }
    // }

    async resetQue(){
        let resp = await fetch("/restservices/settings/que", {
            method: "PUT",
            headers: {
                "Authorization": window.localStorage.getItem("myToken"),
                'Content-Type': 'application/json'
            }
        })

        if (resp.status == 200){
            alert("que reseted")
            return await resp.json();
        } else {
            console.error("something when wrong, code: " + resp.status);
        }
    }

    async pomodoro(work, shortP, longP){
        let data = {
            "work" : work,
            "shortP" : shortP, 
            "longP" : longP
        }

        let resp = await fetch("/restservices/settings/pomoset", {
            method: "POST",
            headers: {
                "Authorization": window.localStorage.getItem("myToken"),
                'Content-Type': 'application/json'
            },
            body : JSON.stringify(data)
        })

        if (resp.status == 200){
            return await resp.json();
        } else {
            console.error("something when wrong, code: " + resp.status);
        }
    }

    async pomodoroGetTiming(){
        let resp = await fetch("/restservices/settings/pomoset", {
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

    async startPomodoro(){
        let resp = await fetch("/restservices/settings/que/pomo", {
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