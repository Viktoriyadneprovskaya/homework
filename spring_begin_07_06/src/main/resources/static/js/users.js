const modal = document.getElementById('modal')
const add_button = document.getElementById('add-btn')
const add_close_span = document.getElementById('modal-close')

const edit_modal = document.getElementById('edit-modal')
const edit_close_span = document.getElementById('edit-modal-close')


add_button.onclick = function () {
    modal.style.visibility = "visible"
}

add_close_span.onclick = function () {
    modal.style.visibility = "hidden"
    const error_username = document.getElementById('error-username')
    error_username.classList.remove('s-visible')
    const error_firstname = document.getElementById('error-firstname')
    error_firstname.classList.remove('s-visible')
    const error_lastname = document.getElementById('error-lastname')
    error_lastname.classList.remove('s-visible')
    const error_email = document.getElementById('error-email')
    error_email.classList.remove('s-visible')
    const error_address = document.getElementById('error-address')
    error_address.classList.remove('s-visible')
    const error_phone = document.getElementById('error-phone')
    error_phone.classList.remove('s-visible')
    // and date
    // document.getElementById('username-input').value = ''
    // document.getElementById('firstname-input').value = ''
    // document.getElementById('lastname-input').value = ''
    // document.getElementById('email-input').value = ''
    // document.getElementById('address-input').value = ''
    // document.getElementById('phone-input').value = ''
    // //document.getElementById('birthday-input').value = ''
}

edit_close_span.onclick = function () {
    edit_modal.classList.remove('m-visible')
}

function openEditModal(id, username, firstname, lastname, email, phonenumber, date, address) {
    edit_modal.classList.add('m-visible')
    const edit_id = document.getElementById('edit-id')
    const edit_username = document.getElementById('username-edit-input')
    const edit_firstname = document.getElementById('firstname-edit-input')
    const edit_lastname = document.getElementById('lastname-edit-input')
    const edit_email = document.getElementById('email-edit-input')
    const edit_phonenumber = document.getElementById('phone-edit-input')
    const edit_birthdate = document.getElementById('birthday-edit-input')
    const edit_address = document.getElementById('address-edit-input')

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
        error.classList.add('s-visible')
        document.getElementById('username-input').style.border = "2px solid red"
        document.getElementById('username-input').style.boxShadow = "inset red 0 0 5px 0"
    } else {
        error.classList.remove('s-visible')
        document.getElementById('username-input').style.border = "2px solid green"
        document.getElementById('username-input').style.boxShadow = "inset green 0 0 5px 0"
    }
}

function passwordValidation() {
    const error = document.getElementById('error-password')
    const input_value = document.getElementById('password-input').value
    const pattern = /(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9@#$%]).{4,}/
    if (!pattern.test(input_value)) {
        error.classList.add('s-visible')
        document.getElementById('password-input').style.border = "2px solid red"
        document.getElementById('password-input').style.boxShadow = "inset red 0 0 5px 0"
    } else {
        error.classList.remove('s-visible')
        document.getElementById('password-input').style.border = "2px solid green"
        document.getElementById('password-input').style.boxShadow = "inset green 0 0 5px 0"
    }
}

function firstNameValidation() {
    const error = document.getElementById('error-firstname')
    const input_value = document.getElementById('firstname-input').value
    const pattern = /[a-zA-Z]+/
    if (!pattern.test(input_value)) {
        error.classList.add('s-visible')
        document.getElementById('firstname-input').style.border = "2px solid red"
        document.getElementById('firstname-input').style.boxShadow = "inset red 0 0 5px 0"
    } else {
        error.classList.remove('s-visible')
        document.getElementById('firstname-input').style.border = "2px solid green"
        document.getElementById('firstname-input').style.boxShadow = "inset green 0 0 5px 0"
    }
}

function lastNameValidation() {
    const error = document.getElementById('error-lastname')
    const input_value = document.getElementById('lastname-input').value
    const pattern = /[a-zA-Z]+/
    if (!pattern.test(input_value)) {
        error.classList.add('s-visible')
        document.getElementById('lastname-input').style.border = "2px solid red"
        document.getElementById('lastname-input').style.boxShadow = "inset red 0 0 5px 0"
    } else {
        error.classList.remove('s-visible')
        document.getElementById('lastname-input').style.border = "2px solid green"
        document.getElementById('lastname-input').style.boxShadow = "inset green 0 0 5px 0"
    }
}

function emailValidation() {
    const error = document.getElementById('error-email')
    const input_value = document.getElementById('email-input').value
    const pattern = /\w+@[a-zA-Z]+\.[a-zA-Z]+/
    if (!pattern.test(input_value)) {
        error.classList.add('s-visible')
        document.getElementById('email-input').style.border = "2px solid red"
        document.getElementById('email-input').style.boxShadow = "inset red 0 0 5px 0"
    } else {
        error.classList.remove('s-visible')
        document.getElementById('email-input').style.border = "2px solid green"
        document.getElementById('email-input').style.boxShadow = "inset green 0 0 5px 0"
    }
}

function addressValidation() {
    const error = document.getElementById('error-address')
    const input_value = document.getElementById('address-input').value
    const pattern = /[a-zA-Z0-9]+/
    if (!pattern.test(input_value)) {
        error.classList.add('s-visible')
        document.getElementById('address-input').style.border = "2px solid red"
        document.getElementById('address-input').style.boxShadow = "inset red 0 0 5px 0"
    } else {
        error.classList.remove('s-visible')
        document.getElementById('address-input').style.border = "2px solid green"
        document.getElementById('address-input').style.boxShadow = "inset green 0 0 5px 0"
    }
}

function phoneValidation() {
    const error = document.getElementById('error-phone')
    error.classList.add('s-visible')
    const input_value = document.getElementById('phone-input').value
    const pattern = /^[+][0-9]{12}/
    if (!pattern.test(input_value)) {
        error.classList.add('s-visible')
        document.getElementById('phone-input').style.border = "2px solid red"
        document.getElementById('phone-input').style.boxShadow = "inset red 0 0 5px 0"
    } else {
        error.classList.remove('s-visible')
        document.getElementById('phone-input').style.border = "2px solid green"
        document.getElementById('phone-input').style.boxShadow = "inset green 0 0 5px 0"
    }
}

function birthdayValidation() {
    const error = document.getElementById('error-birthday')
    const input_value = document.getElementById('birthday-input').value

    if (input_value !== "") {
        const today = new Date();
        const birthday = new Date(input_value);
        const error_year = new Date(1900, 1, 1);

        if (error_year < birthday < today) {
            error.classList.remove('s-visible')
            document.getElementById('birthday-input').style.border = "2px solid green"
            document.getElementById('birthday-input').style.boxShadow = "inset green 0 0 5px 0"
        } else {
            error.classList.add('s-visible')
            document.getElementById('birthday-input').style.border = "2px solid red"
            document.getElementById('birthday-input').style.boxShadow = "inset red 0 0 5px 0"
        }
    } else {
        error.classList.add('s-visible')
        document.getElementById('birthday-input').style.border = "2px solid red"
        document.getElementById('birthday-input').style.boxShadow = "inset red 0 0 5px 0"
    }
}




