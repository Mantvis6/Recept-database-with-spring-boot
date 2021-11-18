window.onload= function(){
    var mygtukas = document.getElementById("mygtukas");
    var nurodymuLaukelis = document.getElementById("nurodymuLaukelis");
    var ingridientuLaukelis = document.getElementById("ingridientuLaukelis");
    var pavadinimoLaukelis = document.getElementById("pavadinimoLaukelis");
    var antraste = document.getElementById("antraste");
    var pastraipa = document.getElementById("pastraipa");
    var kiekKartu= [];

    mygtukas.addEventListener("click", function(){
        ivestasPavadinimas= gautiPavadinima(pavadinimoLaukelis);
        ivestasIngridientas= gautiIngridienta(ingridientuLaukelis);
        ivestasNurodymas = gautiNurodyma(nurodymuLaukelis);

        tikrintiArLaukeliaiUzpildyti(ivestasPavadinimas, ivestasIngridientas, ivestasNurodymas);
        pakeistiPavadinimasSpalva(pavadinimoLaukelis);
        skaiciuotiKiekARaidziuYraNurodyme(ivestasNurodymas, kiekKartu);
    })
    antraste.addEventListener("click", function(){
        pasleptiPastraipa(pastraipa);
    })
}
function gautiPavadinima(pavadinimoLaukelis){
    var ivestasPavadinimas = pavadinimoLaukelis.value;
    return ivestasPavadinimas
}
function gautiIngridienta(ingridientuLaukelis){
    var ivestasIngridientas = ingridientuLaukelis.value;
    return ivestasIngridientas
}
function gautiNurodyma(nurodymuLaukelis){
    var ivestasNurodymas = nurodymuLaukelis.value;
    return ivestasNurodymas
}
function tikrintiArLaukeliaiUzpildyti(ivestasPavadinimas, ivestasIngridientas, ivestasNurodymas){
    if(ivestasPavadinimas == ""){
        alert("Neivedete Pavadinimo");
    }
    else{
        if(ivestasIngridientas == ""){
            alert("Neivedete Ingridiento");
        }
        else{
            if(ivestasNurodymas == ""){
                alert("Neivedete Nurodymo");
            }
        }
    }   
}
function pakeistiPavadinimasSpalva(pavadinimoLaukelis){
    pavadinimoLaukelis.style.color= "green";
}
function skaiciuotiKiekARaidziuYraNurodyme(ivestasNurodymas, kiekKartu){
    for(let i=0; i<ivestasNurodymas.length; i++){
        if(ivestasNurodymas.charAt(i) == "a"){
            kiekKartu.push("a");
        }
    }
    console.log("Kiekis A raidziu tekste = " + kiekKartu.length);
}
function pasleptiPastraipa(pastraipa){
    if(pastraipa.style.display== "none"){
        pastraipa.style.display= "block";
    }
    else{
        pastraipa.style.display= "none";
    }
}