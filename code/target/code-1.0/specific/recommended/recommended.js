import MusicService from "../../services/music-service.js";

let musicService = new MusicService();

window.addEventListener("load", start());

function start(){
    getRecommendedMusic();
}

async function getRecommendedMusic(){
    const urls = await musicService.findNewMusic();
    const fillEl = document.getElementById("fillNew");

    urls["urls"].forEach(element => {
        fillEl.innerHTML += "<button class='songBox' onclick='loadMusic(" + '"' +  element.url + '"' + ")'><h1>" + element.naam + "</h1></button>";
    });
}

window.loadMusic = async function loadMusic(path){
    document.querySelector("iframe").contentWindow.loadMusic(path);
}