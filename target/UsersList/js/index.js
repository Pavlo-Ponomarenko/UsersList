var host = window.location.origin;

function logOut() {
    $.post(host + '/UsersList/logout');
    document.location = host + '/UsersList/';
}
