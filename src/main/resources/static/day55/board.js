// 글쓰기 함수
const writeBoard = () => {
  console.log("write load");

  const sampleBoard = {
    title: "테스트제목",
    content: "테스트내용",
    writer: "유재석",
    password: "1234",
  };

  const option = {
    method: "POST",
    headers: { "Content-type": "application/json" },
    body: JSON.stringify(sampleBoard),
  };

  fetch("/write", option)
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
    })
    .catch((error) => {
      console.log(error);
    });
};

// 전체 글 출력 함수
const findAll = () => {
  console.log("findall load");
};

// 개별 글 출력 함수
const findOne = () => {
  console.log("findone load");
  const sampleIndex = 3;
  fetch(`/findone?id=${sampleIndex}`)
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
    })
    .catch((error) => {
      console.log(error);
    });
};

// 글 수정 함수
const updateBoard = () => {
  console.log("update load");

  const sampleBoard = {
    index: 3,
    title: "수정한 제목",
    content: "수정한 내용",
  };

  const option = {
    method: "PUT",
    headers: { "Content-type": "application/json" },
    body: JSON.stringify(sampleBoard),
  };

  fetch("/update", option)
    .then((r) => r.json())
    .then((d) => console.log(d))
    .catch((e) => console.log(e));
};

// 글 삭제 함수
const deleteBoard = () => {
  console.log("delete load");
  const sampleIndex = 4;
  fetch(`/delete?index=${sampleIndex}`, { method: "delete" })
    .then((r) => r.json())
    .then((d) => console.log(d))
    .catch((e) => console.log(e));
};
