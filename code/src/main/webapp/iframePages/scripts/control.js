var globalSong = null;

import MusicService from "../../services/music-service.js";
import QueService from "../../services/que-service.js";

const musicService = new MusicService();
const queService = new QueService();

window.addEventListener("resize", sizeButton(document.querySelector("[name='controlSizeButton']")));

window.loadMusic = async function loadMusic(path) {

    if (globalSong != null && globalSong.play){ //zodat je niet 2 nummers door elkaar heen hoort
        globalSong.pause();
    }

    globalSong = new Audio(path); //setting the song to play now

    //voor het geval dat het op een andere manier wordt gepauzeert wil ik toch het knopje kunnen aanpassen
    globalSong.addEventListener("play", () => {let element = document.getElementById("togglePause"); element.innerHTML = "<i class='fa-solid fa-pause'></i>" });
    globalSong.addEventListener("pause", () => {let element = document.getElementById("togglePause"); element.innerHTML = "<i class='fa-solid fa-play'></i>" });

    globalSong.play()

    globalSong.addEventListener("ended", () => {nextQueItem()});
}

function sizeButton(element) {
    if (window.innerHeight <= 300) {
        element.innerHTML = "<i class='fa-solid fa-maximize'></i>";
    } else {
        element.innerHTML = "<i class='fa-solid fa-minimize'></i>";
    }
}

window.toggleSize = function toggleSize(element) {
    if (parent.window.location.href.endsWith("control.html")) {
        alert("cant preform this action here");
    } else {
        if (window.innerHeight <= 300) {
            parent.document.querySelector(".playBar").style.height = "100%";
        } else {
            parent.document.querySelector(".playBar").style.height = "17.66vh";
        }
    }

    setTimeout(function () { sizeButton(element) }, 500)
}

window.togglePause = function togglePause() {
    if (globalSong.paused) {
        globalSong.play();
    } else {
        globalSong.pause();
    }
}

window.loopSong = function loopSong(element) {
    if (globalSong.loop) {
        globalSong.loop = false;
        element.innerHTML = '<i class="fa-solid fa-arrow-right-arrow-left"></i>';
    } else {
        globalSong.loop = true;
        element.innerHTML = '<i class="fa-solid fa-repeat"></i>';
    }
}

window.songVolume = function songVolume(element) {
    var sound = element.value;
    sound = sound * 0.01;
    globalSong.volume = sound;
}

window.getQue = async function getQue() {
    console.log(await queService.getQue())
}

window.resetQue = async function resetQue() {
    localStorage.setItem("queItem", 0);
    console.log(queService.resetQue())
}

window.nextQueItem = async function nextQueItem() {
    localStorage.setItem("queItem", (parseInt(localStorage.getItem("queItem")) + 1));
    let index = localStorage.getItem("queItem");

    let que = await queService.getQue();
    loadMusic(que.msg[index])
}