export default class MusicService {

    async findNewMusicQue() {
        let resp = await fetch("restservices/music", {
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

    async findNewMusic() {
        let resp = await fetch("restservices/music/recommend", {
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