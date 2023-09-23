$(document).ready(function() {






//

// 800사이즈 이하에서 menubar를 클릭할시 메뉴를 slidedown

    $("#clickmenu").click(()=>{
        $(".header-menu").slideToggle();
    });

// END


// 검색 돋보기에 submit 부여하기

$('.fa-magnifying-glass').click(()=>{
   $("#searchform").submit(); // 폼 제출
});

// END


// 로그인 누르면 loginbgout이 나오게 하는 효과
$('#loginbtn').click(function(){
    $('.loginbgout').addClass("show");
  });
  
  
// 검은화면 누르면 꺼지게 하는 효과 
  $('.loginbgout').click(function(e){
    if(e.target == document.querySelector('.loginbgout')){
    $('.loginbgout').removeClass("show");
    }
  });

























});