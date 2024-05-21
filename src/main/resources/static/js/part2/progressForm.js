//js를 통해 리스트와 아작스를 연결
$(document).ready(function () { // 페이지가 로딩되는 순간 바로 실행
    console.log("ready!");
    progressScheduleListAjax(1);
    progressChoiceAjax(0, 0);
    progressListAjax();
    document.getElementById('progressDate').textContent = new Date().toISOString().substring(0, 10);
});


//검수 예정 품목 아작스
function progressScheduleListAjax(page) { // 위에서 보낸 매개변수 1을 받아 준다!
    const innerHtml = $("#progressScheduleList"); // innerHtml의 위치를 선정해줌 (html의 아이디값과 일치 시킴!)
    const f = document.getElementById("form1");
    f.page.value = page;

    $.ajax({
        url: "/part2/progressScheduleAjax", //백엔드 경로
        type: 'GET',
        cache: false,
        data: $('#form1').serialize(),
        dataType: "html",
        async: false,

        success: function (data) {
            $(innerHtml).html(data)

            setTimeout(function () {
            }, 1000)
        },
        error: function (e) {
            $(innerHtml).html("")
        }
    })
}


function progressChoiceAjax(orderNum, index) { // 위에서 보낸 매개변수 1을 받아 준다!
    const innerHtml = $("#progressChoice"); // innerHtml의 위치를 선정해줌 (html의 아이디값과 일치 시킴!)
    const f = document.getElementById("form1");
    f.orderNum.value = orderNum;

    $.ajax({
        url: "/part2/progressChoiceAjax", //백엔드 경로
        type: 'GET',
        cache: false,
        data: $('#form1').serialize(),
        dataType: "html",
        async: false,

        success: function (data) {
            $(innerHtml).html(data)
            $("table tr").not(this).removeClass('table-info'); // 배경색 스타일 준 class 전체 제거
            if (index > 0) {
                document.getElementById('index' + index).className += "table-info";// 배경색 스타일 선택 누른부분만 class 추가
            }
            document.getElementById('progressDate').textContent = new Date().toISOString().substring(0, 10);
            setTimeout(function () {
            }, 1000)
        },
        error: function (e) {
            $(innerHtml).html("")
        }
    })
}

function saveProgress() {
    const innerHtml = $("#progressChoice");
    document.getElementById('orderDate').value = new Date().toISOString().substring(0, 10);
    const f = document.getElementById("form2");
    $.ajax({
        url: "/part2/saveProgress", //백엔드 경로
        type: 'POST',
        cache: false,
        data: $('#form2').serialize(),
        dataType: "html",
        async: false,
        success: function (data) {
            $(innerHtml).html(data); // 발주폼 뿌리기
            document.getElementById('orderDate').textContent = new Date().toISOString().substring(0, 10); // 발주일 셋팅
            document.getElementById('receiveDueDate').value = new Date().toISOString().substring(0, 10);
            progressListAjax();
            setTimeout(function () {
            }, 1000)
        },
        error: function (e) {
            $(innerHtml).html("")
        }
    })
}

function progressListAjax() {
    const innerHtml = $("#progressList");
    const f = document.getElementById("form3");
    $.ajax({
        url: "/part2/progressListAjax", //백엔드 경로
        type: 'GET',
        cache: false,
        data: $('#form2').serialize(),
        dataType: "html",
        async: false,
        success: function (data) {
            $(innerHtml).html(data); // 발주폼 뿌리기

            setTimeout(function () {
            }, 1000)
        },
        error: function (e) {
            $(innerHtml).html("")
        }
    })
}



//날짜 계산
function caldate() {
    var startDate = document.getElementById("startDate").value;
    var endDate = document.getElementById("endDate").value;

    if (startDate <= endDate) {
        progressScheduleListAjax(1);
    } else if (startDate > endDate) {
        alert("종료날짜를 시작날짜보다 크게 입력하세요");
        $("#endDate").focus();
    } else {
        alert("날짜를 입력하세요");
        $("#startDate").focus();
    }
}
