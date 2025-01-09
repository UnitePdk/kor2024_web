const signup = () => {
  console.log("signup loaded");

  const input_id = document.querySelector("#signup_id");
  const input_password = document.querySelector("#signup_password");
  const input_name = document.querySelector("#signup_name");
  const input_phone = document.querySelector("#signup_phone");

  const id = input_id.value;
  const password = input_password.value;
  const name = input_name.value;
  const phone = input_phone.value;

  const info = { id: id, password: password, name: name, phone: phone };

  const option = {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(info),
  };

  fetch("/signup.do", option)
    .then((response) => response.json())
    .then((data) => {
      // data: true or false
      if (data) {
        alert("회원가입 성공");
        location.href = "/login";
      } else {
        alert("회원가입 실패");
      }
    })
    .catch((e) => console.log(e));
};

const login = () => {
  console.log("login loaded");

  const input_id = document.querySelector("#login_id");
  const input_password = document.querySelector("#login_password");

  const id = input_id.value;
  const password = input_password.value;

  fetch(`/login.do?id=${id}&password=${password}`)
    .then((response) => response.json())
    .then((data) => {
      // data: true or false
      if (data) {
        alert("로그인 성공");
        location.href = "/";
      } else {
        alert("로그인 실패");
      }
    })
    .catch((e) => console.log(e));
};
