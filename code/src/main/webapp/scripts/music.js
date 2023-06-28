import MusicService from "../services/music-service.js";

let musicService = new MusicService();

window.getMusic = async function getMusic(){
    console.log(await musicService.findNewMusic());
}