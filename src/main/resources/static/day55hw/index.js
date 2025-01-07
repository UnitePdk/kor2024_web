// 할일 작성
const add = () => {
  const contentInput = document.querySelector(".contentInput");
  const content_ = contentInput.value;
  const todo = { content: content_ };
  const option = {
    method: "POST",
    headers: { "Content-type": "application/json" },
    body: JSON.stringify(todo),
  };
  fetch("/add", option)
    .then((response) => response.json())
    .then((data) => console.log(data))
    .catch((e) => console.log(e));

  alert("할일 등록되었습니다");
  contentInput.value = "";
  getAll();
};

const getAll = () => {
  console.log("getAll loaded");
  const result = fetch("/getall")
    .then((response) => response.json())
    .then((data) => console.log(data))
    .catch((error) => console.log(error));
  console.log(result);
  let html = "";
  result.map((v, i) => {
    html += `<div class="contentBox ${todo.status ? "success" : ""}">
          <div class="content">${todo.content}</div>
          <div class="contentButton">
            <button onclick="update()" class="updateButton button">수정</button>
            <button onclick="delete_(${
              todo.index
            })" class="deleteButton button">삭제</button>
          </div>
        </div>`;
  });
};

// const print = () => {
//   const todoBottom = document.querySelector(".todoBottom");
//   let html = "";
//   for (let i = 0; i < todoList.length; i++) {
//     const todo = todoList[i];
//     html += `<div class="contentBox ${todo.status ? "success" : ""}">
//           <div class="content">${todo.content}</div>
//           <div class="contentButton">
//             <button onclick="update()" class="updateButton button">수정</button>
//             <button onclick="delete_(${
//               todo.index
//             })" class="deleteButton button">삭제</button>
//           </div>
//         </div>`;
//   }
//   todoBottom.innerHTML = html;
// };

// const update = () => {};

// const delete_ = (index) => {
//   for (let i = 0; i < todoList.length; i++) {
//     if (todoList[index].index == index) {
//       todoList.splice(index, 1);
//       break;
//     }
//   }
//   print();
// };
