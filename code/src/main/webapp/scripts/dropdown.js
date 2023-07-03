document.addEventListener('DOMContentLoaded', () => {

    window.elLoaded = function whenElmentsLoaded() {
        document.getElementById("rightClickMenu").style.display = "none";
        document.getElementById("trigger").addEventListener("blur", function(){
            setTimeout(() => document.getElementById("rightClickMenu").style.display = "none", 200)
        });

        let elements = document.querySelectorAll(".songBox");

        elements.forEach(element => {
            element.addEventListener('contextmenu', (event) => {
                dropMenu(event);
            });
        });
    }

});

function dropMenu(ev) {
    ev.preventDefault();

    parent.setBestandsNaam(ev.srcElement.getAttribute('onclick').split('"')[1]);
    setBestandNaam(ev.srcElement.getAttribute('onclick').split('"')[1]);

    document.getElementById("rightClickMenu").style.display = "flex";

    let elInfo = ev.target.getBoundingClientRect()
    let yPos = elInfo.top + elInfo.height;
    let xPos = (elInfo.left + (elInfo.width / 2)) - ((window.innerWidth * 0.2)/2);

    // document.getElementById("rightClickMenu").style = "top : " + yPos + "px; left : " + xPos + "px;";
    document.getElementById("rightClickMenu").style.top = yPos + "px";
    document.getElementById("rightClickMenu").style.left = xPos + "px";

    document.getElementById("trigger").focus();
}

window.upperWindowGetAllPlaylists = function upperWindowGetAllPlaylists(){
    parent.getAllPlaylists();
}