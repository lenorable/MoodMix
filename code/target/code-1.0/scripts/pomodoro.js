import QueService from "../services/que-service.js";

let queService = new QueService();

document.querySelector("form").addEventListener('submit', (ev) => {start(ev)})

async function start(ev){
    ev.preventDefault();
    localStorage.setItem("queItem", 0);

    let work = document.getElementById("workTime").value;
    let shortP = document.getElementById("shortPauseTime").value;
    let longP = document.getElementById("longPauseTime").value;

    await queService.pomodoro(work, shortP, longP); //setting the timing
    console.log(await queService.pomodoroGetTiming()); //for checking timing

    await queService.startPomodoro(); //filling the que

    localStorage.setItem("inPomoSession", "true");
    window.location.href = "./iframePages/control.html";
}