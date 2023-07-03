import MusicService from "../../services/music-service.js";
import QueService from "../../services/que-service.js";

let musicService = new MusicService();
let queService = new QueService();

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

    window.elLoaded()
}

window.loadMusic = async function loadMusic(path){
    parent.document.querySelector(".playBar").contentWindow.loadMusic(path);
}

let bestandNaam = null;

window.setBestandNaam = function setBestandNaam(naam){
    console.log(naam);
    bestandNaam = naam;
}

window.addToQue = async function addToQue(){
    console.log(await queService.updateQue(bestandNaam));
}

window.addEventListener("click", (ev) => {console.log(ev.target)})