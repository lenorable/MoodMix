import PlaylistService from "../services/playlist-service.js";
import MusicService from "../services/music-service.js";

let musicService = new MusicService
let playlistService = new PlaylistService

let bestandNaam = null;

window.createSongs = async function createSongs(){
    console.log(await musicService.createMusic());
}

window.setBestandsNaam = function setBestandsNaam(naam){
    bestandNaam = naam;
}


window.cancelDialog = function cancelDialog() {
    // document.getElementById("PlaylistDialog").style.display = 'none';
}

document.addEventListener('DOMContentLoaded', () => {
    document.querySelector('.newPlaylist').addEventListener('submit', (thiss => {
        makeNewPlaylist(thiss)
    }));
});

async function makeNewPlaylist(ev) {
    ev.preventDefault();

    let name = document.getElementById('playlistName').value;
    let sum = document.getElementById('summary').value;

    console.log(await playlistService.makePlaylist(name, sum))

    addToPlaylist(name);

    alert("playlist created!")

    document.getElementById('playlistName').value = "";
    document.getElementById('summary').value = "";
    document.getElementById("PlaylistDialog").style.display = 'none';
}

window.newPlaylistDialog = function newPlaylistDialog(){
    document.getElementById('listPlaylist').style.display = "none";
    document.getElementById("newPlaylist").style.display = "flex";
}

window.getAllPlaylists = async function getAllPlaylists(){
    document.getElementById("PlaylistDialog").style.display = "block";

    let serviceAwns = await playlistService.getPlaylists();
    let playlists = serviceAwns.msg;

    let overlay = document.getElementById('listPlaylist');

    overlay.style.display = 'flex';
    overlay.innerHTML = '<button class="playlist" onclick="newPlaylistDialog()"><h2> NEW PLAYLIST</h2></button>';

    playlists.forEach(playlist => {
        overlay.innerHTML += '<button class="playlist" onclick="addToPlaylist(' + "'" + playlist + "'" + ')"><h2>' + playlist + '</h2></button>'
    });
}

window.addToPlaylist = async function addToPlaylist(playlistName){
    console.log(await playlistService.addToPlaylist(bestandNaam, playlistName));
    document.getElementById("PlaylistDialog").style.display = "none";
}