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
            right: 'month,agendaDay'
        },
        dayClick: function (date, jsEvent, view) {

//            if (view.name === 'month' || view.name === 'agendaWeek') {
//                $('#calendar').fullCalendar('changeView', 'agendaDay');
//                $('#calendar').fullCalendar('gotoDate', date);
//            }
            $(".fc-state-highlight").removeClass("fc-state-highlight");
            $(jsEvent.target).addClass("fc-state-highlight");
            if (date < (startDateMomentVal)) {
                swal({
                    title: "Please select a different date",
                    text: "Advisor not available on this date!",
                    type: "error",
                    confirmButtonText: "Ok"
                });
            } else if (date > (endDateMomentVal)) {
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
        },
        dayRender: function (date, cell) {

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