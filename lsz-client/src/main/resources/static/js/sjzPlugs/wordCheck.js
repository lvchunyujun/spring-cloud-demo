/*<![CDATA[*/
/**
 *   单词选择器遮罩层功能；
 *   demo: 1.
 *         2.重写workCheck对象;
 *
 *   调用页面需要重写
 * @type {{checkType: string,                     // 1.选择类型："radio"=单选，"check"=复选选
 *         checkedFun: workCheck.checkedFun,      // 2.选中回调函数：
 *         uncheckedFun: workCheck.uncheckedFun}} // 3.取消回调函数：
 */

var workCheck = {
    checkType:"check",
    checkedFun:function(obj){},
    uncheckedFun:function(obj){}
}


function startDialogOpen() {
    $("#_sjz_word_meta_div").show();
    $("#_dialog_close").bind("click",dialogClose);
    $("#_sjz_word_meta_c").empty();
    loadingWord(0);
}

function dialogOpen(){

}
function dialogClose(){
    $("#_sjz_word_meta_div").hide();
}

function loadingWord(parentCode) {
    var _url = "/admin/nl/wordMeta/getListByPWMC/";

    $.ajax({
        type: "get",
        url: _url+parentCode,
        dataType:'json',
        success:function(data){
            parseData(data);
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            alert(textStatus+"  "+XMLHttpRequest.state());
        }
    });
}

function parseData(data){

    var _resultCode = data.resultCode;
    if(_resultCode == '0000'){
        var _data = data.data;

        if(!_data.length > 0){
            return;
        }

        var _ul = "<ul class='_word_list'></ul>";
        for(var i = 0 ; i < _data.length ; i++){
            var _word = _data[i];
            var _li = "<li ></li>";

            // 图片
            var _img = "<img src='/images/common/add.png'/>";
            _img = $(_img).attr("status","add");
            _img = $(_img).bind("click",_word,function(obj){
                var status = $(this).attr("status");
                // 清理状态
                if(workCheck.checkType == 'check'){
                }else{
                    $(this).parent().parent().parent().find("img").attr("status","add").attr("src","/images/common/add.png");
                }
                var _code = $(this).next().attr("attrcode");
                if(status == "add"){
                    $(this).attr("status","checked").attr("src","/images/common/checked.png");
                    workCheck.checkedFun(obj.data);
                }else if(status == "checked"){
                    $(this).attr("status","add").attr("src","/images/common/add.png");
                    workCheck.uncheckedFun(obj.data);
                }
            });
            _li = $(_li).append(_img);
            // 文本
            var _p = "<p attrcode='"+_word.wordMetaCode+"'>"+_word.wordMetaZh+"</p>";
            // 绑定单击事件
            _p = $(_p).bind("click",function(){
                $(this).parent().siblings().css("color","#fff");
                var _wordMetaCode = $(this).attr("attrcode");
                $(this).parent().parent().nextAll().remove();
                loadingWord(_wordMetaCode);
                $(this).parent().css("color","#000");
            });
            _li = $(_li).append(_p);

            _ul = $(_ul).append(_li);
        }
        $("#_sjz_word_meta_c").append(_ul);
    }
}


/*]]>*/