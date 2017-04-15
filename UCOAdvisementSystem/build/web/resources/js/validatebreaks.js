/* 
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */

$(document).ready(function () {
    loadCalendar();
    loadTabs();
    loadCheckBox();
});

function loadCalendar() {
    $('.customdate').calendar({
        type: 'date',
        monthFirst: false,
        formatter: {
            date: function (date, settings) {
                if (!date)
                    return '';
                var day = date.getDate();
                var month = date.getMonth() + 1;
                var year = date.getFullYear();
                return day + '/' + month + '/' + year;
            }
        }
    });
    $('.customtime').calendar({
        ampm: false,
        type: 'time'
    });
}
;

function loadTabs() {
    $('.menu .item').tab();
}
;

function loadCheckBox() {
    $('.ui.checkbox').checkbox({
        onChecked: function () {
            ($(this).parent().parent().siblings(".customhidediv").removeClass("customhidediv"));
            ($(this).parent().parent().siblings(".customdiv").addClass("customshowdiv"));
        },
        onUnchecked: function () {
            ($(this).parent().parent().siblings(".customshowdiv").removeClass("customshowdiv"));
            ($(this).parent().parent().siblings(".customdiv").addClass("customhidediv"));
        }
    });
}

function validateBreak() {
    var start = $("#breakform\\:breakfromtime");
    var end = $("#breakform\\:breaktotime");

    s = start.val().split(':');
    e = end.val().split(':');

    startsecs = s[0] * 60 * 60 + s[1] * 60;
    endsecs = e[0] * 60 * 60 + e[1] * 60;
    diff = endsecs - startsecs;
    if (diff <= 0) {
        start.val("");
        end.val("");
        return false;
    } else {
        return true;
    }

}
;


