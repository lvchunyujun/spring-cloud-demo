/*<![CDATA[*/
$(document).ready(function(){
    $.ajax({
        type: "POST",
        url: "http://localhost:7100/eventIndex/1_6",
        dataType:'jsonp',
        jsonp: "callback",
        jsonpCallback:"eciHandler",
        success:function(data){

        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            alert(textStatus+"  "+XMLHttpRequest.state());
        }
    });
});
var eciHandler = function(resultData){
    var result = JSON.stringify(resultData); //json对象转成字符串
    var sjzEvt = resultData.data.voList;

    if(sjzEvt.length>0){
        $("#content").empty();

        for ( var i = 0; i <sjzEvt.length; i++){
            var main_cell_div = document.createElement("div");
            main_cell_div = $(main_cell_div).addClass("ei_count_main_cell");

            var main_time = document.createElement("div");
            var main_content = document.createElement("div");
            main_time = $(main_time).addClass("ei_count_main_time");
            main_content = $(main_content).addClass("ei_count_main_content");

            var evTime = new Date(sjzEvt[i].eventTime);
            $(main_time).append(evTime.Format("yyyy-MM-dd"));
            $(main_content).append(sjzEvt[i].eventContent);
            main_cell_div = $(main_cell_div).append(main_time).append(main_content);
            $("#content").append(main_cell_div);

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
        type: "POST",
        url: "http://localhost:6010/eventIndex/"+currentPage+"_"+pageSize,
        dataType:'jsonp',
        jsonp: "callback",
        jsonpCallback:"eciHandler",
        success:function(data){

        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            alert(textStatus+"  "+XMLHttpRequest.state());
        }
    });
}
/*]]>*/