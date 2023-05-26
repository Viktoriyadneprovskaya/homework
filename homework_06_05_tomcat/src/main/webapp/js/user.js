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

function openEditModal(id, username, firstname, lastname, email, phonenumber, date, address) {
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

function usernameValidation() {
    const error = document.getElementById('error-username')
    const input_value = document.getElementById('username-input').value
    const pattern = /[a-zA-Z0-9]{4,}/
    if (!pattern.test(input_value)) {
        error.style.display = "flex"
        document.getElementById('username-input').style.border = "2px solid red"
        document.getElementById('username-input').style.boxShadow = "inset red 0 0 5px 0"
    } else {
        error.style.display = "none"
        document.getElementById('username-input').style.border = "2px solid green"
        document.getElementById('username-input').style.boxShadow = "inset green 0 0 5px 0"
    }
}

function passwordValidation() {
    const error = document.getElementById('error-password')
    const input_value = document.getElementById('password-input').value
    const pattern = /(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9@#$%]).{4,}/
    if (!pattern.test(input_value)) {
        error.style.display = "flex"
        document.getElementById('password-input').style.border = "2px solid red"
        document.getElementById('password-input').style.boxShadow = "inset red 0 0 5px 0"
    } else {
        error.style.display = "none"
        document.getElementById('password-input').style.border = "2px solid green"
        document.getElementById('password-input').style.boxShadow = "inset green 0 0 5px 0"
    }
}

function firstNameValidation() {
    const error = document.getElementById('error-firstname')
    const input_value = document.getElementById('first-input').value
    const pattern = /[a-zA-Z]{2,}/
    if (!pattern.test(input_value)) {
        error.style.display = "flex"
        document.getElementById('firstname-input').style.border = "2px solid red"
        document.getElementById('firstname-input').style.boxShadow = "inset red 0 0 5px 0"
    } else {
        error.style.display = "none"
        document.getElementById('firstname-input').style.border = "2px solid green"
        document.getElementById('firstname-input').style.boxShadow = "inset green 0 0 5px 0"
    }
}

function lastNameValidation() {
    const error = document.getElementById('error-lastname')
    const input_value = document.getElementById('lastname-input').value
    const pattern = /[a-zA-Z]{2,}/
    if (!pattern.test(input_value)) {
        error.style.display = "flex"
        document.getElementById('lastname-input').style.border = "2px solid red"
        document.getElementById('lastname-input').style.boxShadow = "inset red 0 0 5px 0"
    } else {
        error.style.display = "none"
        document.getElementById('lastname-input').style.border = "2px solid green"
        document.getElementById('lastname-input').style.boxShadow = "inset green 0 0 5px 0"
    }
}

function emailValidation() {
    const error = document.getElementById('error-email')
    const input_value = document.getElementById('email-input').value
    const pattern = /\w+@[a-zA-Z]+\.[a-zA-Z]+/
    if (!pattern.test(input_value)) {
        error.style.display = "flex"
        document.getElementById('email-input').style.border = "2px solid red"
        document.getElementById('email-input').style.boxShadow = "inset red 0 0 5px 0"
    } else {
        error.style.display = "none"
        document.getElementById('email-input').style.border = "2px solid green"
        document.getElementById('email-input').style.boxShadow = "inset green 0 0 5px 0"
    }
}

function addressValidation() {
    const error = document.getElementById('error-address')
    const input_value = document.getElementById('address-input').value
    const pattern = /[a-zA-Z0-9]{8,}/
    if (!pattern.test(input_value)) {
        error.style.display = "flex"
        document.getElementById('address-input').style.border = "2px solid red"
        document.getElementById('address-input').style.boxShadow = "inset red 0 0 5px 0"
    } else {
        error.style.display = "none"
        document.getElementById('address-input').style.border = "2px solid green"
        document.getElementById('address-input').style.boxShadow = "inset green 0 0 5px 0"
    }
}

function phoneValidation() {
    const error = document.getElementById('error-phone')
    error.style.display = "flex"
    const input_value = document.getElementById('phone-input').value
    const pattern = /^[+][0-9]{12}/
    if (!pattern.test(input_value)) {
        error.style.display = "flex"
        document.getElementById('phone-input').style.border = "2px solid red"
        document.getElementById('phone-input').style.boxShadow = "inset red 0 0 5px 0"
    } else {
        error.style.display = "none"
        document.getElementById('phone-input').style.border = "2px solid green"
        document.getElementById('phone-input').style.boxShadow = "inset green 0 0 5px 0"
    }
}

function birthdayValidation() {//don't work
    const error = document.getElementById('error-birthday')
    const input_value = document.getElementById('birthday-input').value

    if (input_value !== "") {
        const today = new Date();
        const birthday = new Date(input_value);
        const error_year = new Date(1900, 1, 1);

        if(error_year<birthday<=today){
            error.style.display = "none"
            document.getElementById('birthday-input').style.border = "2px solid green"
            document.getElementById('birthday-input').style.boxShadow = "inset green 0 0 5px 0"
        }else
        error.style.display = "flex"
        document.getElementById('birthday-input').style.border = "2px solid red"
        document.getElementById('birthday-input').style.boxShadow = "inset red 0 0 5px 0"
    } else {
        error.style.display = "flex"
        document.getElementById('birthday-input').style.border = "2px solid red"
        document.getElementById('birthday-input').style.boxShadow = "inset red 0 0 5px 0"
    }
}




