import PlaylistService from "../../services/playlist-service.js"

let fillEl = document.getElementById("playlistsBox");
let songBox = document.getElementById("songBox");
let trigger = document.getElementById("trigger");
const playlistService = new PlaylistService;

window.addEventListener("DOMContentLoaded", start());

async function start(){ //voor het weergeven van alle afspeellijsten van de gebruiker
    fillEl.innerHTML = "";

    let resp = await playlistService.getAllPlaylists();
    let info = resp.msg;

    info.forEach(element => {
        fillEl.innerHTML += '<button class="playlistBox" onclick="showSongs(this)"><div class="playlistBoxTitle">' + element.naam + '</div><div class="playlistBoxSum">' + element.sum + '</div></button>';
    });
}

window.showSongs = async function showSongs(el){
    let playlistName = el.children[0].innerHTML;

    songBox.innerHTML = '<button onclick="closeBox()">-cancel-</button>';

    // trigger = document.getElementById("idk");
    // trigger.addEventListener("blur", () => {songBox.style.display = 'none';})

    let resp = await playlistService.getSongsPlaylist(playlistName)
    let info = resp.msg;

    info.forEach(element => {
        songBox.innerHTML += "<button onclick='loadMusic(" + '"' + element.url + '"' + ")'>" + element.naam + "</button>" 
    });

    songBox.style.display = "flex";
    // trigger.focus();
}

window.loadMusic = function loadMusic(song){
    parent.document.querySelector(".playBar").contentWindow.loadMusic(song);
}

window.closeBox = function closeBox(){
    songBox.style.display = "none";
}