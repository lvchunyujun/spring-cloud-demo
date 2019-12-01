/*<![CDATA[*/
// 验证表达式
function regExp_checked() {
    var re_p = $("input[name='regExpPattern']").val();
    var re_d = $("textarea[name='regExpDemo']").val();

    $.ajax({
        type: "get",
        url: "/admin/nlRegExp/check",
        data:{
            regExpPattern:re_p,
            regExpDemo:re_d
        },
        dataType:'json',
        success:function(data){

            var checked = data.resultCode;
            checked = checked != null && checked == '0000';
            if(checked){
                $(".check_img_msg").attr("src","/images/check_success.png");
            }else  {
                $(".check_img_msg").attr("src","/images/check_fail.png");
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            alert(textStatus+"  "+XMLHttpRequest.state());
        }
    });

}

/*]]>*/