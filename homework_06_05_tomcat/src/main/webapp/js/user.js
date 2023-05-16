const modal = document.getElementById('modal')
const add_button = document.getElementById('add-btn')
const close_span = document.getElementById('modal-close')

const edit_modal = document.getElementById('edit-modal')
const edit_close_span = document.getElementById('edit-modal-close')


add_button.onclick = function () {
    modal.style.display = "flex"
}

close_span.onclick = function () {
    modal.style.display = "none";
}

edit_close_span.onclick = function () {
    edit_modal.style.display = "none";
}

function openEditModal(id, username, firstname, lastname, email, phonenumber, date, address){
    edit_modal.style.display = "flex"
    const edit_id = document.getElementById('edit-id')
    const edit_username = document.getElementById('edit-username')
    const edit_firstname = document.getElementById('edit-firstname')
    const edit_lastname = document.getElementById('edit-lastname')
    const edit_email = document.getElementById('edit-email')
    const edit_phonenumber = document.getElementById('edit-phonenumber')
    const edit_birthdate = document.getElementById('edit-birthdate')
    const edit_address = document.getElementById('edit-address')

    edit_id.value = id
    edit_username.value = username
    edit_firstname.value = firstname
    edit_lastname.value = lastname
    edit_email.value = email
    edit_phonenumber.value = phonenumber
    edit_birthdate.value = date
    edit_address.value = address

}


