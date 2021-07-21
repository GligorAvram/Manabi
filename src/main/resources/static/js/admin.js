let i = 0;
let addPostBtn = document.getElementById('addPostButton');
let changePwBtn = document.getElementById('changePwButton');
let editPostBtn = document.getElementById('editPostBtn');
let addWord = document.getElementById('add-field');
 let addPostDiv = document.getElementById('add-post');
  let showChangePw = document.getElementById('change-password');
  let showEditPost = document.getElementById('edit-post');


addWord.addEventListener('click', () => {
  let addFieldSpace = document.getElementById('word-space');
  let fieldWordDiv = document.createElement("div");
  fieldWordDiv.classList.add("form-word");
  let fieldName = document.createTextNode("Word");  
  let wordField = document.createElement("INPUT");
  wordField.setAttribute("type", "text"); 
  wordField.name = "wordList[]";
  wordField.setAttribute("form", "blog-form") ;
  fieldWordDiv.appendChild(fieldName);
  fieldWordDiv.appendChild(wordField);
  addFieldSpace.appendChild(fieldWordDiv);
})

addPostBtn.addEventListener('click', () => {
 addPostDiv.style.display = "block";
showChangePw.style.display = "none";
showEditPost.style.display = "none";
})

changePwBtn.addEventListener('click', ()=> {
 addPostDiv.style.display = "none";
showChangePw.style.display = "block";
showEditPost.style.display = "none";
})

editPostBtn.addEventListener('click', () =>{
 addPostDiv.style.display = "none";
showChangePw.style.display = "none";
showEditPost.style.display = "block";
})