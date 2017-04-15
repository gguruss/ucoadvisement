/* 
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */


$(document).ready(function () {
    var selectedDate = $('.selecteddate');
    var startDate = $('.startdate');
    var startDateMomentVal = convertUTCDateToLocalDate(new Date(startDate.val()));
    var endDate = $('.enddate');
    var endDateMomentVal = convertUTCDateToLocalDate(new Date(endDate.val()));

    // page is now ready, initialize the calendar...
    $('#calendar').fullCalendar({
        height: 450,
        weekends: false,
        defaultView: 'month',
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month'
        },
        dayClick: function (date, jsEvent, view) {
            if (date.format() < (moment().format('YYYY-MM-DD'))) {
                swal({
                    title: "Please select a different date",
                    text: "Advisor not available on this date!",
                    type: "error",
                    confirmButtonText: "Ok"
                });
            } else if (date.format() > (endDateMomentVal)) {
                swal({
                    title: "Please select a different date",
                    text: "Advisor not available on this date!",
                    type: "error",
                    confirmButtonText: "Ok"
                });
            } else {
                selectedDate.val(date.format());
                selectedDate.change();
            }
        }
    });

    function convertUTCDateToLocalDate(date) {
        var newDate = new Date(date.getTime() + date.getTimezoneOffset() * 60 * 1000);

        var offset = date.getTimezoneOffset() / 60;
        var hours = date.getHours();

        newDate.setHours(hours - offset);

        return newDate;
    }
}
);