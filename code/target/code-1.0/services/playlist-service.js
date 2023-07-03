export default class PlaylistService {

    async makePlaylist(playlistName, summary){
        let data = {
            "playlistName" : playlistName,
            "summary" : summary
        }

        let resp = await fetch("/restservices/playlist/make", {
            method: "POST",
            headers: {
                "Authorization": window.localStorage.getItem("myToken"),
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })

        if (resp.status == 200){
            return await resp.json();
        } else {
            console.error("something when wrong, code: " + resp.status);
        }
    }

    async getPlaylists(){
        let resp = await fetch("/restservices/playlist", {
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

    async addToPlaylist(songName, playlistName){
        let data = {
            "bestandNaam" : songName,
            "playlistName" : playlistName
        }

        let resp = await fetch("/restservices/playlist/add", {
            method: "POST",
            headers: {
                "Authorization": window.localStorage.getItem("myToken"),
                'Content-Type': 'application/json'
            },
            body : JSON.stringify(data)
        })

        if (resp.status == 200){
            alert("song added")
            return await resp.json();
        } else {
            console.error("something when wrong, code: " + resp.status);
        }
    }
}