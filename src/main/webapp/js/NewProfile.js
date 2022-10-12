var host = window.location.origin;

function createProfile() {
    var age = document.getElementById('age').value;
    var email = document.getElementById('email').value;
    var login = document.getElementById('login').value;
    var password = document.getElementById('password').value;
    var data = {
        age: age.trim(),
        email: email.trim(),
        login: login.trim(),
        password: password.trim()
    }
    $.post(host + '/UsersList/add_profile', data);
    document.location = host + '/UsersList/';
}
