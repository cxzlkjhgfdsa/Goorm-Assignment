// Init Github
const github = new Github();

const ui = new UI();

// Search input
const searchUser = document.querySelector("#searchUser");

searchUser.addEventListener("keyup", (e) => {
    const userText = e.target.value;
    showSpinner();

    if (userText !== "" && e.keyCode == 13) {
        github.getUser(userText).then((data) => {
            console.log(data);
            if (data.profile.message === "Not Found") {
                ui.showAlert("User not found", "alert alert-danger");
            } else {
                ui.showProfile(data.profile);
                ui.showRepos(data.repos);
            }
        });
        hideSpinner();
    } else {
        ui.clearProfile();
    }
});

function showSpinner() {
    document.getElementById("spinner").style.display = "block";
}

function hideSpinner() {
    document.getElementById("spinner").style.display = "none";
}
