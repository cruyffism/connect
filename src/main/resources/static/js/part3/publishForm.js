function publishInvoice() {
    // 거래명세서 작성 부분의 정보 가져오기
    var invoiceNumber = document.getElementById('invoiceNumber').textContent;
    var issueDate = document.getElementById('issueDate').textContent;
    var supplierInfo = {
        orderDate: document.getElementById('OrderDate').textContent,
        companyName: document.getElementById('comName').textContent,
        businessNumber: document.getElementById('businessId').textContent,
        address: document.getElementById('comAdd').textContent,
        responsiblePerson: document.getElementById('comManager').textContent
    };
    var recipientInfo = {
        orderDate: document.getElementById('recipientOrderDate').textContent,
        companyName: document.getElementById('recipientCompanyName').textContent,
        businessNumber: document.getElementById('recipientBusinessNumber').textContent,
        address: document.getElementById('recipientAddress').textContent,
        responsiblePerson: document.getElementById('recipientResponsiblePerson').textContent
    };

    // 새로운 행 추가
    var newRow = '<tr>' +
        '<td>' + invoiceNumber + '</td>' +
        '<td>' + issueDate + '</td>' +
        '<td>' + supplierInfo.orderDate + '</td>' +
        '<td>' + supplierInfo.comName + '</td>' +
        '<td>' + supplierInfo.businessId + '</td>' +
        '<td>' + supplierInfo.comAdd + '</td>' +
        '<td>' + supplierInfo.comManager + '</td>' +
        '<td>' + recipientInfo.orderDate + '</td>' +
        '<td>' + recipientInfo.companyName + '</td>' +
        '<td>' + recipientInfo.businessNumber + '</td>' +
        '<td>' + recipientInfo.address + '</td>' +
        '<td>' + recipientInfo.responsiblePerson + '</td>' +
        '</tr>';

    // 맨 아래 테이블에 행 추가
    var tableBody = document.getElementById('invoiceTableBody');
    tableBody.innerHTML += newRow;
}