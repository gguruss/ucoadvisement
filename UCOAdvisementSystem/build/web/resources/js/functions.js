/* 
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */


$(document).ready(function () {
    var selectedDate = $('.selecteddate');
    var startDate = $('.startdate');
//    var startDateMomentVal = convertUTCDateToLocalDate(new Date(startDate.val()));
    var endDate = $('.enddate');
    var endDateMomentVal = formatDate(new Date(endDate.val()));
    var bookbutton = $('.bookbutton');
    var bookingDiv = $('#bookingdiv');
    var calendarDiv = $('#calendardiv');


    function formatDate(d)
    {
        date = new Date(d);
        var dd = date.getDate();
        var mm = date.getMonth() + 1;
        var yyyy = date.getFullYear();
        if (dd < 10) {
            dd = '0' + dd;
        }
        if (mm < 10) {
            mm = '0' + mm;
        }
        ;
        return d = yyyy + "-" + mm + "-" + dd;
    }



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

  

}
);