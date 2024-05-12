function updateUnitSelectedOption() {
    var selectedValue = document.getElementById('unitSelect').value;
    document.querySelectorAll('#unitSelect option').forEach(function(option) {
        if (option.value === selectedValue) {
            option.setAttribute('selected', 'selected');
        } else {
            option.removeAttribute('selected');
        }
    });
}

function updateAssySelectedOption() {
    var selectedValue = document.getElementById('assySelect').value;
    document.querySelectorAll('#assySelect option').forEach(function(option) {
        if (option.value === selectedValue) {
            option.setAttribute('selected', 'selected');
        } else {
            option.removeAttribute('selected');
        }
    });
}

function updatePartSelectedOption() {
    var selectedValue = document.getElementById('partSelect').value;
    document.querySelectorAll('#partSelect option').forEach(function(option) {
        if (option.value === selectedValue) {
            option.setAttribute('selected', 'selected');
        } else {
            option.removeAttribute('selected');
        }
    });
}