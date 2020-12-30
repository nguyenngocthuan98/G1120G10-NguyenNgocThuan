
function displayEMainMenu() {
    document.getElementById("mainEMenu").style.display = "block";
    document.getElementById("mainMenu").style.display = "none";
    document.getElementById("btnShowEMenu").style.display = "none";
    document.getElementById("btnShowMenu").style.display="none";
}
function exitMainEMenu() {
    document.getElementById("mainEMenu").style.display = "none";
    document.getElementById("display").style.display = "none";
    document.getElementById("btnShowMenu").style.display = "block";
    document.getElementById("btnShowEMenu").style.display="block";
}

