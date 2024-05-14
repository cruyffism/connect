//js를 통해 리스트와 아작스를 연결
$(document).ready(function () { // 페이지가 로딩되는 순간 바로 실행
    console.log("ready!");
    document.getElementById('startDate').value = new Date().toISOString().substring(0, 10);
    document.getElementById('endDate').value = new Date().toISOString().substring(0, 10);
    procurementPlanListAjax(1); // 들어가서 바로 1페이지가 보임, 아래 펑션의 이름
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

function caldate() {
    var startDate = document.getElementById("startDate").value;
    var endDate = document.getElementById("endDate").value;

    if (startDate <= endDate) {
    } else if (startDate > endDate) {
        alert("종료날짜를 시작날짜보다 크게 입력하세요");
    } else {
        alert("날짜를 입력하세요");
    }
}