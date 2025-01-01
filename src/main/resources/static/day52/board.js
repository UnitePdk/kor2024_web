// 글쓰기 함수
const write_ = () => {
  const titleInput = document.querySelector("#titleInput").value;
  const contentInput = document.querySelector("#contentInput").value;
  const passwordInput = document.querySelector("#passwordInput").value;

  const board = {
    title: titleInput,
    content: contentInput,
    password: passwordInput,
  };

  const option_write = {
    method: "POST",
    Headers: { "Content-Type": "application/json" },
    body: JSON.stringify(board),
  };

  fetch("/day52/write", option_write)
    .then((response) => response.json())
    .then((data) => {
      if (data == true) {
        alert("등록 성공");
      } else {
        alert("등록 실패");
      }
    })
    .catch((e) => {
      console.log(e);
    });
};

// 출력 함수
const findAll = () => {
  fetch("/day52/findall")
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
    });
};
