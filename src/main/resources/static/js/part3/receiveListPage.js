//js를 통해 리스트와 아작스를 연결
$(document).ready(function () { // 페이지가 로딩되는 순간 바로 실행
    console.log("ready!");
    noReceiveListAjax(1); // 들어가서 바로 1페이지가 보임, 아래 펑션의 이름
    yesReceiveListAjax(1); // 들어가서 바로 1페이지가 보임, 아래 펑션의 이름
});

function noReceiveListAjax(page) {
    const innerHtml = $("#noReceiveList"); // innerHtml의 위치를 선정해줌 (html의 아이디값과 일치 시킴!)
    const f = document.getElementById("form1"); //part1_insert_company.html의 form1과연결
    f.page.value = page;

    $.ajax({
        url: "/part3/getNoReceiveListAjax", //백엔드 경로
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

function yesReceiveListAjax(page) {
    const innerHtml = $("#yesReceiveList"); // innerHtml의 위치를 선정해줌 (html의 아이디값과 일치 시킴!)
    const f = document.getElementById("form2"); //part1_insert_company.html의 form1과연결
    f.page.value = page;

    $.ajax({
        url: "/part3/getYesReceiveListAjax", //백엔드 경로
        type: 'GET',
        cache: false,
        data: $('#form2').serialize(),
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