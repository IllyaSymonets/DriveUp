function CorrectOrder(){
  window.parent.document.getElementById('disable-all').parentNode.querySelector('#disable-all').style.display = "none";
  window.parent.document.getElementById('modal').parentNode.querySelector('#modal').style.display = "none";  
}
function SearchDriver(){
  CorrectOrder();
}