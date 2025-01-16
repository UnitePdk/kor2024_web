// 할일 작성
const add = () => {
  console.log("add loaded");
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

// 목록 가져와서 출력
const getAll = () => {
  console.log("getAll loaded");
  let html = "";
  fetch("/getall")
    .then((response) => response.json())
    .then((data) => {
      data.map((v) => {
        html += `<div class="contentBox ${v.status ? "success" : ""}">
            <div class="content">${v.content}</div>
            <div class="contentButton">
              <button onclick="edit(${v.index}
        )" class="editButton button">완료</button>
              <button onclick="delete_(${
                v.index
              })" class="deleteButton button">삭제</button>
            </div>
          </div>`;
      });
      const todoBottom = document.querySelector(".todoBottom");
      todoBottom.innerHTML = html;
    })
    .catch((error) => console.log(error));
};

//수정
const edit = (index) => {
  console.log("edit loaded");

  const option = {
    method: "PUT",
    headers: { "Content-type": "application/json" },
  };

  fetch(`/edit?index=${index}`, option).then(() => getAll());
};

// 삭제
const delete_ = (index) => {
  console.log("delete loaded");
  fetch(`/delete?index=${index}`, { method: "DELETE" }).then(() => getAll());
};

// 최초 목록 출력
getAll();
