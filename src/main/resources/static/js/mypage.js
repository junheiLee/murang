 $(document).ready(function() {

const urlParams = new URLSearchParams(window.location.search);
const sendParam = urlParams.get('like');
if(sendParam == "1"){
   const likeProductItem = document.getElementById('likeProductItem');
   if (likeProductItem) {
       likeProductItem.classList.add('selected');
   }
            $.ajax({
                url: "/users/likeProduct",
                method: 'GET',
                success: function (response) {


                    $(".productlist").html("");
                var $productList = $('.productlist');

                for (var i = 0; i < response.length; i++) {
                    var item = response[i];
                    var $listItem = $('<li>').addClass('plist');
                    var $pimg = $('<div>').addClass('pimg');
                    var $img = $('<img>').attr('src', "/images"+item.imageSrc).attr('width', '100%').attr('height', '100%').attr('alt', '유저');
                    var $ptitle = $('<div>').addClass('ptitle').text(item);
                    var $pinfo = $('<div>').addClass('pinfo').text('가격: ' + item.price + ' 렌트기간: ' + item.rentalPeriod + ' 등록날짜: ' + item.registrationDate);

                    $pimg.append($img);
                    $listItem.append($pimg);
                    $listItem.append($ptitle);
                    $listItem.append($pinfo);

                    $productList.append($listItem);

            }
        },
                error: function (error) {
                    console.error('Error:', error);
                }
            });
        }





const menuItems = document.querySelectorAll('.mymenu li');
menuItems.forEach(item => {
  item.addEventListener('click', function() {
    // 모든 li 요소의 클래스를 초기화합니다.
    menuItems.forEach(item => {
      item.classList.remove('selected');
    });
    // 클릭한 li 요소에만 선택 클래스를 추가합니다.
    this.classList.add('selected');
  });
});

///////


        $('.mymenu li').on('click', function () {
            var url = $(this).data('url');
            console.log(url);
            $.ajax({
                url: "/users/"+url,
                method: 'GET',
                success: function (response) {

            // 받아온 데이터가 배열인 경우
            if (Array.isArray(response)) {
                    $(".productlist").html("");
                var $productList = $('.productlist');

                for (var i = 0; i < response.length; i++) {
                    var item = response[i];
                    var $listItem = $('<li>').addClass('plist');
                    var $pimg = $('<div>').addClass('pimg');
                    var $img = $('<img>').attr('src', item.imageSrc).attr('width', '100%').attr('height', '100%').attr('alt', '유저');
                    var $ptitle = $('<div>').addClass('ptitle').text(item);
                    var $pinfo = $('<div>').addClass('pinfo').text('가격: ' + item.price + ' 렌트기간: ' + item.rentalPeriod + ' 등록날짜: ' + item.registrationDate);

                    $pimg.append($img);
                    $listItem.append($pimg);
                    $listItem.append($ptitle);
                    $listItem.append($pinfo);

                    $productList.append($listItem);
                }
            }
        },
                error: function (error) {
                    console.error('Error:', error);
                }
            });
        });



$(".editbtn").click(() => {
    $(".profile").html("");

    // left-profile 추가
    var leftProfile = `<div class="left-profile">
        <div class="profile-photo">
            <img src="/image/ajfod.png" width="100%" height="100%" alt="이미지공간">
            <a href="#" id="changephoto">사진변경</a>
        </div>
    </div>`;

    // right-profile 추가
    var rightProfile = `<div class="right-profile">
        <div><input type="text" value="1234" required minlength="4" maxlength="20"/></div>
        <div>지역입력하는곳</div>
    </div>`;

    // 수정, 취소, 삭제 버튼 추가
    var buttons = `<span class="deletebtn">회원탈퇴</span>
        <span class="canclebtn">취소하기</span>
        <span class="commitbtn">수정완료</span>`;

    // 프로필에 추가
    $(".profile").append(leftProfile);
    $(".profile").append(rightProfile);
    $(".profile").append(buttons);
});


$(".canclebtn").click(()=>{
$(".profile").html("");
$(".profile").append(
`<div class="left-profile">
<div class="profile-photo">
<img src="/image/ajfod.png" width="100%" height="100%" alt="이미지공간">
</div>
</div>
 <div class="right-profile">
 <div  th:text="|안녕하세요 ${user.id}님|">아이디</div>
<div  th:text="|신뢰등급: ${user.grade}|">신뢰등급</div>
</div>
 <span class="editbtn">정보수정</span>`);
});

});