var host = window.location.origin;

function verify() {
    cleanForm();
    var login = document.getElementById('login').value;
    var user_password = document.getElementById('password').value;
    var user = {
        login: login,
        password: user_password
    };
    var result = $.ajax({
        url: host + '/UsersList/verify',
        type: 'GET',
        data: user,
        dataType: 'text',
        async: false
    });
    if (result.responseText == 'OK') {
        document.location = host + '/UsersList/';
    } else {
        document.getElementById('loginErr').textContent = result.responseText;
    }
}

function cleanForm() {
    document.getElementById('loginErr').textContent = '';
}
