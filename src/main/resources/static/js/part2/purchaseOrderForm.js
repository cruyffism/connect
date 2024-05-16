//js를 통해 리스트와 아작스를 연결
$(document).ready(function () { // 페이지가 로딩되는 순간 바로 실행
    console.log("ready!");
    document.getElementById('startDate').value = new Date().toISOString().substring(0, 10); //현재 날짜로 세팅
    document.getElementById('endDate').value = new Date().toISOString().substring(0, 10); //현재 날짜로 세팅
    procurementPlanListAjax(1); // 들어가서 바로 1페이지가 보임, 아래 펑션의 이름
    orderChoiceAjax(0, 0);
    document.getElementById('orderDate').textContent = new Date().toISOString().substring(0, 10);
});

function procurementPlanListAjax(page) { // 위에서 보낸 매개변수 1을 받아 준다!
    const innerHtml = $("#procurementPlanList"); // innerHtml의 위치를 선정해줌 (html의 아이디값과 일치 시킴!)
    const f = document.getElementById("form1"); //part1_insert_company.html의 form1과연결
    f.page.value = page;

    $.ajax({
        url: "/part2/procurementPlanListAjax", //백엔드 경로
        type: 'GET',
        cache: false,
        data: $('#form1').serialize(),
        dataType: "html",
        async: false,
        //성공 시에 part1_insert_company.html의 form태그 위치에 백엔드 경로(part1_insert_company_ajax)에 연결 된 리턴 값인 프론트 cartListAjax.html을 넣어서 보여줌
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

function orderChoiceAjax(planNum, index) {
    const innerHtml = $("#orderRegister");
    const f = document.getElementById("form1");
    f.planNum.value = planNum;

    $.ajax({
        url: "/part2/orderChoiceAjax", //백엔드 경로
        type: 'GET',
        cache: false,
        data: $('#form1').serialize(),
        dataType: "html",
        async: false,
        success: function (data) {
            $(innerHtml).html(data); // 발주폼 뿌리기
            $("table tr").not(this).removeClass('table-info'); // 배경색 스타일 준 class 전체 제거
            if (index > 0) {
                document.getElementById('index' + index).className += "table-info";// 배경색 스타일 선택 누른부분만 class 추가
            }
            document.getElementById('orderDate').textContent = new Date().toISOString().substring(0, 10); // 발주일 셋팅
            updateTotalPrice(); // 가격계산 메소드 실행
            setTimeout(function () {
            }, 1000)
        },
        error: function (e) {
            $(innerHtml).html("")
        }
    })
}

function caldate() {
    var startDate = document.getElementById("startDate").value;
    var endDate = document.getElementById("endDate").value;

    if (startDate <= endDate) {
        procurementPlanListAjax(1);
    } else if (startDate > endDate) {
        alert("종료날짜를 시작날짜보다 크게 입력하세요");
        $("#endDate").focus();
    } else {
        alert("날짜를 입력하세요");
        $("#startDate").focus();
    }
}


// function show(orderPart) {
//
//     if (document.getElementById(orderPart).style.display == "none") {
//
//         document.getElementById(orderPart).style.display = "block"; //표시하게 하기
//     } else {
//         document.getElementById(orderPart).style.display = "none"; //안보이게 하기
//
//     }
//
// }

//가격 계산
function updateTotalPrice() {
    // 단가가격
    const onePrice = document.getElementById('onePrice').value;
    // 수량
    const amount = document.getElementById('orderCount').value;

    // 단가 * 수량 계산 및 합계/공급가격 금액 형식 추가
    document.getElementById('totalPrice1').textContent = (onePrice * amount).toLocaleString("ko-KR") + '원';
    document.getElementById('totalPrice2').textContent = (onePrice * amount).toLocaleString("ko-KR") + '원';
    // 단가 금액 형식 추가
    document.getElementById('orderPrice').textContent = (onePrice * 1).toLocaleString("ko-KR") + '원';
}