const add_button = document.querySelector('.add-btn')
const delete_buttons = document.querySelectorAll('.task-style')

add_button.addEventListener("click", () => {
    const items_list = document.querySelector('.tasks')

    const list_item = document.createElement('li')
    list_item.className = "task_line"

    const item_span = document.createElement('span')
    item_span.className = "todo-text"
      let isLineThrough = false;
        item_span.addEventListener('click', () => {
          if (isLineThrough) {
            item_span.style.textDecoration = 'none';
          } else {
            item_span.style.textDecoration = 'line-through';
          }

          isLineThrough = !isLineThrough;
        });

    const input_text = document.querySelector('.task-input')
    item_span.textContent = input_text.value

    const item_div = document.createElement('div')
    item_div.className = 'button-group'

    const edit_button = document.createElement('button')
    const delete_button = document.createElement('button')

    edit_button.className = "btn btn-primary"
    edit_button.innerHTML = '<i class="bi bi-pen"></i>'

    delete_button.className = "btn btn-danger"
    delete_button.innerHTML = '<i class="bi bi-trash"></i>'


    item_div.append(edit_button)
    edit_button.addEventListener('click', edit_event)
    item_div.append(delete_button)
    delete_button.addEventListener('click', delete_event)

    list_item.append(item_span)
    list_item.append(item_div)
    items_list.append(list_item)

    input_text.value = ''

})

function delete_event() {
    const item = event.target.closest('.task_line')
    item.remove()
}

function edit_event() {
    this.classList.toggle('hide')
    const item = event.target.closest('.task_line')
    const input_correct = document.createElement('input')
    const span_item = item.querySelector('.todo-text')
    input_correct.value = span_item.textContent
    item.replaceChild(input_correct, span_item)
    const submit_button = document.createElement('button')
    submit_button.className = 'btn btn-success'
    submit_button.innerHTML = '<i class="bi bi-check"></i>'
    const button_div = item.querySelector('.button-group')
    button_div.append(submit_button)

    submit_button.addEventListener('click', () => {
        span_item.textContent = input_correct.value
        item.prepend(span_item)
        input_correct.remove()
        submit_button.remove()
        this.classList.toggle('hide')
    })
}

