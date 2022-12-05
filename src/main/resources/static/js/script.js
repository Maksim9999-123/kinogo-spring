$(window).on('load', function () {
    listenRateButtons();
});

function listenRateButtons() {
    var rateButtons = $(".rate-button");
    rateButtons.on('click', function (e) {
        let rateVal = $(e.currentTarget).attr('rate-val');
        $("#rate").val(rateVal);
        $("#rateForm").submit();
    });
}