/*<![CDATA[*/
$(document).ready(function(){
    if(!$.isEmptyObject(pageVo)){
        $.ajax({
            type: "get",
            url: pageVo.getUrl(),
            dataType:'json',
            success:function(data){
                eciHandler(data);
            },
            error: function(XMLHttpRequest, textStatus, errorThrown){
                alert(textStatus+"  "+XMLHttpRequest.state());
            }
        });
    }
});
var eciHandler = function(resultData){
    var result = JSON.stringify(resultData); //json对象转成字符串
    var sjzEvt = resultData.data.voList;

    if( sjzEvt.length > 0){
        var bootstrapDiv = $("#"+pageVo.bootstrapDiv.id_).empty();
        <!-- -->
        for (var i = 0; i < sjzEvt.length ; i++){
            // root 元素
            var root_tag = document.createElement("tr");
            root_tag = $(root_tag).addClass(pageVo.rootDiv.class_);

            <!-- 隔行分色 -->
            if(i%2==1){
                root_tag.css("background-color","#edf8ff");
            }

            var obj = sjzEvt[i];
            var map = pageVo.voMapping;
            for(var key in map){

                var val_ = obj[key];

                var td_tag = document.createElement("td");
                if(map[key].tagType == 'text' || map[key].tagType == null){
                    // 1 编号
                    td_tag = $(td_tag).text(val_);
                }
                if(map[key].tagType == 'text_datetime'){
                    val_ = typeof(val_) == 'undefined' ?"":new Date(val_).Format(map[key].dateFormat);
                    td_tag = $(td_tag).text(val_);
                }
                if(map[key].tagType == 'text_type'){
                    // 4 类型标签
                    val_ = map[key].typeMap[val_];
                    td_tag = $(td_tag).text(val_);
                }
                if(map[key].tagType == 'a_operation'){
                    var indexName = map[key].indexName;
                    // 6.1 操作  更新标签
                    if(map[key].updateHref !=null && map[key].updateHref != "" && map[key].updateHref.length > 0){
                        var td_event_opt_a_u = document.createElement("a");
                        td_event_opt_a_u = $(td_event_opt_a_u).attr("href",map[key].updateHref+obj[indexName]);
                        td_event_opt_a_u = $(td_event_opt_a_u).text(map[key].updateTxt);
                        td_tag = $(td_tag).append(td_event_opt_a_u);
                    }
                    // 6.2 分割符
                    td_tag = $(td_tag).append("&nbsp;|&nbsp;");
                    // 6 操作  删除标签
                    if(map[key].deleteHref !=null && map[key].deleteHref != "" && map[key].deleteHref.length > 0){

                        var td_event_opt_a_d = document.createElement("a");
                        td_event_opt_a_d = $(td_event_opt_a_d).attr("href",map[key].updateHref+obj[indexName]);
                        td_event_opt_a_d = $(td_event_opt_a_d).text(map[key].deleteTxt);
                        td_tag = $(td_tag).append(td_event_opt_a_d);
                    }

                }

                // * 标签添加样式
                if(map[key].class_ !=null && map[key].class_.length > 0){
                    td_tag = td_tag.addClass(map[key].class_);
                }
                root_tag.append(td_tag);

            }

            bootstrapDiv.append(root_tag);

        }
    }
    link_paging(resultData.data.currentPage,resultData.data.pageCount,resultData.data.pageSize);
};

/**
 *
 * @param currentPage 当前页
 * @param countPage  总页数
 * @param pageSize  每页显示条数
 */
function link_paging(currentPage,countPage,pageSize){
    $("#previous_page").unbind("click");
    $("#next_page").unbind("click");
    // step1: 已经到达首页
    if(currentPage == 1 && currentPage == countPage){
        $("#previous_page").click(function () {
            data_paging(currentPage,pageSize);
        });
        $("#next_page").click(function () {
            data_paging(currentPage,pageSize);
        });
    }else if(currentPage == countPage){
        $("#previous_page").click(function () {
            data_paging(currentPage-1,pageSize);
        });
        $("#next_page").click(function () {
            data_paging(currentPage,pageSize);
        });
    }else{
        $("#previous_page").click(function () {
            data_paging(currentPage-1,pageSize);
        });
        $("#next_page").click(function () {
            data_paging(currentPage+1,pageSize);
        });
    }

}

function data_paging(currentPage,pageSize){
    $.ajax({
        type: "GET",
        url: pageVo.bUrl+currentPage+"_"+pageSize,
        dataType:'json',
        success:function(data){
            eciHandler(data);
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            alert(textStatus+"  "+XMLHttpRequest.state());
        }
    });
}


/*]]>*/