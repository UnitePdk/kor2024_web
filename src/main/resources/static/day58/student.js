// 학생 등록
const register = () => {
  console.log("register loaded");

  // 입력한 값 받아오기
  const register_name = document.querySelector("#register_name");
  const register_kor = document.querySelector("#register_kor");
  const register_math = document.querySelector("#register_math");
  const register_eng = document.querySelector("#register_eng");

  const name_ = register_name.value;
  const kor_ = register_kor.value;
  const math_ = register_math.value;
  const eng_ = register_eng.value;

  // 입력값으로 오브젝트 생성
  const student = { name: name_, kor: kor_, math: math_, eng: eng_ };

  // fetch
  const option = {
    method: "POST",
    headers: { "Content-type": "application/json" },
    body: JSON.stringify(student),
  };

  fetch("/register.do", option)
    .then((response) => response.json())
    .then((data) => {
      // 중복 이름이면 false가 반환됨
      alert(data === true ? "학생 점수 등록되었습니다" : "등록에 실패했습니다");
      console.log(data);
    })
    .catch((e) => console.log(e));

  // input 비우기
  register_name.value = "";
  register_kor.value = "";
  register_math.value = "";
  register_eng.value = "";
};

// 전체 학생 점수 조회
const list = async () => {
  console.log("list loaded");

  // 초기 html
  let html = `<tr>
          <th>번호</th>
          <th>이름</th>
          <th>국어점수</th>
          <th>수학점수</th>
          <th>영어점수</th>
        </tr>`;

  // 동기식으로 fetch
  const response = await fetch("/list.do");
  const data = await response.json();

  // 받아온 리스트 html에 저장
  data.map((student, i) => {
    html += `<tr>
          <td>${i + 1}</td>
          <td>${student.name}</td>
          <td>${student.kor}</td>
          <td>${student.math}</td>
          <td>${student.eng}</td>
          <td><button onclick="remove(${student.index})">삭제</button></td>
        </tr>`;
  });

  // html 출력
  const student_table = document.querySelector("#student_table");
  student_table.innerHTML = html;
};

// 학생 점수 수정
const edit = () => {
  console.log("edit loaded");

  // 입력한 값 받아오기
  const edit_name = document.querySelector("#edit_name");
  const edit_kor = document.querySelector("#edit_kor");
  const edit_math = document.querySelector("#edit_math");
  const edit_eng = document.querySelector("#edit_eng");

  const name_ = edit_name.value;
  const kor_ = edit_kor.value;
  const math_ = edit_math.value;
  const eng_ = edit_eng.value;

  // 입력값으로 오브젝트 생성
  const student = { name: name_, kor: kor_, math: math_, eng: eng_ };

  // fetch
  const option = {
    method: "PUT",
    headers: { "Content-type": "application/json" },
    body: JSON.stringify(student),
  };

  fetch("/edit.do", option)
    .then((response) => response.json())
    .then((data) => {
      alert(data === true ? "수정 완료" : "수정 실패");
      console.log(data);
    })
    .catch((e) => console.log(e));

  // input 비우기
  edit_name.value = "";
  edit_kor.value = "";
  edit_math.value = "";
  edit_eng.value = "";
};

// 학생 정보 삭제
const remove = (index) => {
  console.log("remove loaded");

  // fetch
  fetch(`/delete.do?index=${index}`, { method: "DELETE" }).then(() => list());

  alert("학생 정보가 삭제되었습니다");
};
