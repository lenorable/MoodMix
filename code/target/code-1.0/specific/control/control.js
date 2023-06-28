var globalSong = null;

import MusicService from "../../services/music-service.js";

const musicService = new MusicService();

window.addEventListener("load",  start());

async function start(){
    // let que = await musicService.findNewMusicQue();
    // que = que.urls
    // loadMusic(que[0])  
}

window.loadMusic = async function loadMusic(path){
    globalSong = new Audio(path); //setting the song to play now

    // await globalSong.play(); //waiting for it to start playing
    // pause = false; //setting the pause value to false bacause its playing 

    console.log(globalSong.duration) //getting the duration of the song
}

window.togglePause = function togglePause(element){
    if (globalSong.paused){
        globalSong.play();
        element.innerHTML = "<i class='fa-solid fa-pause'></i>";
    } else {
        globalSong.pause();
        element.innerHTML = "<i class='fa-solid fa-play'></i>";
    }

}

window.loopSong = function loopSong(element){
    if (globalSong.loop){
        globalSong.loop = false;
        element.innerHTML = '<i class="fa-solid fa-arrow-right-arrow-left"></i>';
    } else {
        globalSong.loop = true;
        element.innerHTML = '<i class="fa-solid fa-repeat"></i>';
    }
}

window.songVolume = function songVolume(element){
    var sound = element.value;
    sound = sound * 0.01;
    globalSong.volume = sound;
}