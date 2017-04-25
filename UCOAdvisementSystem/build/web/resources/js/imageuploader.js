/* 
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */

$(function () {
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#imagepreview').attr('src', e.target.result);
            };

            reader.readAsDataURL(input.files[0]);
        }
    }

    $(".customupload").change(function () {
        readURL(this);
    });

});
