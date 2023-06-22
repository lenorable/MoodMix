function checkBeckEndCon(){
    fetch("restservices/music", {
        method: "GET",
        headers: {"Authorization" : localStorage.getItem("myToken")}
    })
        .then(response => console.log(response["ok"]))
}

function quizResult(){ //proty type. weet nog niet of ik dit zo ga houden
    var energy = document.getElementById("EnergyRangeId").value;
    var consentration = document.getElementById("ConsentrationRangeId").value;
    var happiness = document.getElementById("HappinessRangeId").value;
    var intensity = document.getElementById("IntensityRangeId").value;

    var outcome = {
        "happy" : 0,
        "sad" : 0,
        "relaxed" : 0,
        "inspired" : 0,
        "romantic" : 0,
        "focues" : 0,
        "euphoric" : 0
    };

    if (energy > 60){
        outcome.happy += 1;
        outcome.euphoric += 1;
    } else if (energy < 40){
        outcome.relaxed += 1;
        outcome.romantic += 1;
        outcome.focues += 1;
        outcome.sad += 1
    }

    if (consentration > 60){
        outcome.inspired += 1;
        outcome.focues += 1;
    } else if (consentration < 40){
        outcome.romantic += 1;
        outcome.sad += 1;
    }

    if (happiness > 60){
        outcome.happy += 1;
        outcome.inspired += 1;
        outcome.romantic += 1;
        outcome.euphoric += 1;
    } else if (happiness < 40){
        outcome.sad += 1;
    }

    if (intensity > 60){
        outcome.euphoric += 1;
    } else if (intensity < 40){
        outcome.relaxed += 1;
    }

    var values = Object.values(outcome);
    var maxValue = Math.max.apply(null, values);
    var product = []

    var index = 0;
    values.forEach(element => {
        if (element == maxValue){
            product.push(Object.keys(outcome)[index]);
        }
        index += 1;
    });

    localStorage.setItem("feeling", product); //nu nog voor eeuwig?

    return product;
}