let todoList = [];

let idx = 1;

const addList = () => {
  const contentInput = document.querySelector(".contentInput");
  const content = contentInput.value;
  const todo = { index: idx, content: content, status: false };
  todoList.push(todo);
  idx++;
  alert("할일 등록되었습니다");
  contentInput.value = "";
  print();
};

const print = () => {
  const todoBottom = document.querySelector(".todoBottom");
  let html = "";
  for (let i = 0; i < todoList.length; i++) {
    const todo = todoList[i];
    html += `<div class="contentBox ${todo.status ? "success" : ""}">
          <div class="content">${todo.content}</div>
          <div class="contentButton">
            <button onclick="update()" class="updateButton button">수정</button>
            <button onclick="delete_(${
              todo.index
            })" class="deleteButton button">삭제</button>
          </div>
        </div>`;
  }
  todoBottom.innerHTML = html;
};

const update = () => {};

const delete_ = (index) => {
  for (let i = 0; i < todoList.length; i++) {
    if (todoList[index].index == index) {
      todoList.splice(index, 1);
      break;
    }
  }
  print();
};
