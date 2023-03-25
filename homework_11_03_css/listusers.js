const  edit_buttons = document.querySelectorAll('.edit-btn')
const delete_buttons =document.querySelectorAll('.delete-btn')
const add_button =document.getElementById('add-btn')

console.log(edit_buttons)
console.log(delete_buttons)
console.log(add_button)

add_button.addEventListener("click", ()=>{
    window.alert('Clicked add')
})

edit_buttons.forEach(button => {button.addEventListener("click", () => {
    window.alert('Clicked delete')
})
})

delete_buttons.forEach(button => {
    button.addEventListener("click", ()=> {
        const  item =event.target.closest('.table-list-item'); //посмотреть что єто за класс у препода
        item.remove();
    })
})