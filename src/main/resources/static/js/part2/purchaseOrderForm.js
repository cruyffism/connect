//js를 통해 리스트와 아작스를 연결
$(document).ready(function () { // 페이지가 로딩되는 순간 바로 실행
    console.log("ready!");
    /*document.getElementById('startDate').value = new Date().toISOString().substring(0, 10); //현재 날짜로 세팅
    document.getElementById('endDate').value = new Date().toISOString().substring(0, 10); //현재 날짜로 세팅*/
    procurementPlanListAjax(1); // 들어가서 바로 1페이지가 보임, 아래 펑션의 이름
    orderChoiceAjax(0, 0);
    orderListAjax(1,0); // 들어가서 바로 1페이지가 보임, 아래 펑션의 이름
    document.getElementById('orderDate2').textContent = new Date().toISOString().substring(0, 10);

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
            document.getElementById('orderDate2').textContent = new Date().toISOString().substring(0, 10); // 발주일 셋팅
            document.getElementById('receiveDueDate').value = new Date().toISOString().substring(0, 10);
            updateTotalPrice(1); // 가격계산 메소드 실행
            orderListAjax(1,planNum);
            setTimeout(function () {
            }, 1000)
        },
        error: function (e) {
            $(innerHtml).html("")
        }
    })
}

function saveOrder() {
    const innerHtml = $("#orderRegister");
    document.getElementById('orderDate').value = new Date().toISOString().substring(0, 10);
    const f = document.getElementById("form2");
    $.ajax({
        url: "/part2/saveOrder", //백엔드 경로
        type: 'POST',
        cache: false,
        data: $('#form2').serialize(),
        dataType: "html",
        async: false,
        success: function (data) {
            $(innerHtml).html(data); // 발주폼 뿌리기
            document.getElementById('orderDate2').textContent = new Date().toISOString().substring(0, 10); // 발주일 셋팅
            document.getElementById('receiveDueDate').value = new Date().toISOString().substring(0, 10);
            updateTotalPrice(0); // 가격계산 메소드 실행/
            orderListAjax(1,f.planNum.value);
            setTimeout(function () {
            }, 1000)
        },
        error: function (e) {
            $(innerHtml).html("")
        }
    })
}

function orderListAjax(page,planNum) {
    const innerHtml = $("#orderListForm"); // innerHtml의 위치를 선정해줌 (html의 아이디값과 일치 시킴!)
    const f = document.getElementById("form3");
    f.page.value = page;
    if(planNum !== -1){ // -1이 아니면 매개변수로 보내준 planNum 으루 넘어가게 , -1이면 히든으로 채워진 planNum이 넘어가게
        f.planNum.value = planNum;
    }
    $.ajax({
        url: "/part2/orderListAjax",
        type: 'GET',
        cache: false,
        data: $('#form3').serialize(),
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

//마감 펑션
function orderDeadlineAjax(page,planNum,orderNum) {
    const innerHtml = $("#orderListForm"); // innerHtml의 위치를 선정해줌 (html의 아이디값과 일치 시킴!)
    const f = document.getElementById("form3");
    f.page.value = page;
    f.orderNum.value = orderNum;
    if(planNum !== -1){ // -1이 아니면 매개변수로 보내준 planNum 으루 넘어가게 , -1이면 히든으로 채워진 planNum이 넘어가게
        f.planNum.value = planNum;
    }
    $.ajax({
        url: "/part2/orderDeadlineAjax",
        type: 'POST',
        cache: false,
        data: $('#form3').serialize(),
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

//삭제 펑션
function deleteOrderAjax(page,planNum,orderNum) {
    const innerHtml = $("#orderListForm"); // innerHtml의 위치를 선정해줌 (html의 아이디값과 일치 시킴!)
    const f = document.getElementById("form3");
    f.page.value = page;
    f.orderNum.value = orderNum;
    if(planNum !== -1){ // -1이 아니면 매개변수로 보내준 planNum 으루 넘어가게 , -1이면 히든으로 채워진 planNum이 넘어가게
        f.planNum.value = planNum;
    }
    $.ajax({
        url: "/part2/deleteOrderAjax",
        type: 'POST',
        cache: false,
        data: $('#form3').serialize(),
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

//날짜 계산
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

//날짜 계산
function caldate2() {
    var startDate = document.getElementById("startDate3").value;
    var endDate = document.getElementById("endDate3").value;
    const f = document.getElementById("form3");
    if (startDate <= endDate) {
        orderListAjax(1,f.planNum.value)
    } else if (startDate > endDate) {
        alert("종료날짜를 시작날짜보다 크게 입력하세요");
        $("#endDate").focus();
    } else {
        alert("날짜를 입력하세요");
        $("#startDate").focus();
    }
}


//가격 계산
function updateTotalPrice(isCheck) {
    // 단가가격
    const onePrice = document.getElementById('onePrice').value;
    // 수량
    const amount = document.getElementById('orderCount').value;
    if (isCheck === 0) { //취소 버튼 눌렀을때 1개 가격으로 초기화
        document.getElementById('totalPrice1').textContent = (onePrice * 1).toLocaleString("ko-KR") + '원';
        document.getElementById('totalPrice2').textContent = (onePrice * 1).toLocaleString("ko-KR") + '원';

    } else { // 가격 계산 해주는 코드

        // 단가 * 수량 계산 및 합계/공급가격 금액 형식 추가
        document.getElementById('totalPrice1').textContent = (onePrice * amount).toLocaleString("ko-KR") + '원';
        document.getElementById('totalPrice2').textContent = (onePrice * amount).toLocaleString("ko-KR") + '원';
        // 단가 금액 형식 추가
        document.getElementById('orderPrice').textContent = (onePrice * 1).toLocaleString("ko-KR") + '원';
    }

}

// 모달 닫기
function closeModal() {
    document.getElementById('myModal').style.display = 'none';
}

// 모달 외부 클릭 시 닫기
window.onclick = function (event) {
    if (event.target == document.getElementById('myModal')) {
        closeModal();
    }
}

// PDF로 저장하기
function saveAsPDF() {
    var element = document.getElementById('myModal');

    html2canvas(element).then(canvas => {
        var imgData = canvas.toDataURL('image/png');
        var pdf = new jsPDF('p', 'mm', 'a4');
        var imgWidth = 210;
        var pageHeight = 295;
        var imgHeight = canvas.height * imgWidth / canvas.width;
        var heightLeft = imgHeight;

        var position = 0;

        pdf.addImage(imgData, 'PNG', 0, position, imgWidth, imgHeight);
        heightLeft -= pageHeight;

        while (heightLeft >= 0) {
            position = heightLeft - imgHeight;
            pdf.addPage();
            pdf.addImage(imgData, 'PNG', 0, position, imgWidth, imgHeight);
            heightLeft -= pageHeight;
        }

        pdf.save('document.pdf');
    });
}

function printForm() {

}