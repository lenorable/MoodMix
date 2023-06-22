var globalSong = null;

window.addEventListener("load",  getResource({"reqGevoel" : localStorage.getItem("feeling")}));

function getResource(data){
    fetch("restservices/music", { //verstuur data om url terug te kijrgen pls
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => {
            if (response.status === 200) {
                response.json().then(myjson => {
                    globalSong = new Audio(myjson.url);
                })
            }
        })
}

async function loadMusic(path){
    globalSong = new Audio(path); //setting the song to play now

    await globalSong.play(); //waiting for it to start playing
    pause = false; //setting the pause value to false bacause its playing 

    console.log(globalSong.duration) //getting the duration of the song
}

function togglePause(element){
    if (globalSong.paused){
        globalSong.play();
        element.innerHTML = "<i class='fa-solid fa-pause'></i>";
    } else {
        globalSong.pause();
        element.innerHTML = "<i class='fa-solid fa-play'></i>";
    }

}

function loopSong(element){
    if (globalSong.loop){
        globalSong.loop = false;
        element.innerHTML = '<i class="fa-solid fa-arrow-right-arrow-left"></i>';
    } else {
        globalSong.loop = true;
        element.innerHTML = '<i class="fa-solid fa-repeat"></i>';
    }
}

function songVolume(element){
    var sound = element.value;
    sound = sound * 0.01;
    globalSong.volume = sound;
}