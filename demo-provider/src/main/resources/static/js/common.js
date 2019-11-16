/*<![CDATA[*/
$(document).ready(function(){
        $(".menu_img_ctl_left").click(function () {
            $(".sjz_menu").hide();
            $("._sjz_menu").next().css("width","100%");
            $(".menu_img_ctl_right").show();
            $(this).hide();
        });
        $(".menu_img_ctl_right").click(function () {
            $(".sjz_menu").show();
            $("._sjz_menu").next().css("width","84%");
            $(".menu_img_ctl_left").show();
            $(this).hide();
        });
});
/*]]>*/