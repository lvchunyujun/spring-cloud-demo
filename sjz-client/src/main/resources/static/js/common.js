/*<![CDATA[*/
$(document).ready(function(){
        $(".menu_img_ctl_left").click(function () {
            $(".sjz_menu").hide({duration: 50,easing:'linear'});
            $("._sjz_menu").next().css("width","100%");
            $(".menu_img_ctl_right").show();
            $(this).hide();
        });
        $(".menu_img_ctl_right").click(function () {
            $(".sjz_menu").show({duration: 50});
            $("._sjz_menu").next().css("width","84%");
            $(".menu_img_ctl_left").show();
            $(this).hide();
        });
});
/*]]>*/