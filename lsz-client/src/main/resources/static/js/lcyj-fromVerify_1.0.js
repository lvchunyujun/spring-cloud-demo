/**
 * from 表单校验
 *
 * v1.0
 *
 */
/*<![CDATA[*/
var ProcessFrom =
{
    /**
     * 插入 From表单
     */
    submitFrom:function(fromId,url){
        var $eventId = $("#"+fromId).find("input[name='id']");
        var $eventTime = $("#"+fromId).find("input[name='eventTime']");
        var $eventContent = $("#"+fromId).find("textarea[name='eventContent']");
        var $eventType = $("#"+fromId).find("select[name='eventType']");

        var eventId = $eventId != null ? $eventId.val() : "";
        var eventContentVal = $eventContent !=null ? $eventContent.val() : "";
        var eventTimeVal = $eventTime !=null ? $eventTime.val() : "";
        var eventTypeVal = $eventType !=null ? $eventType.val() : "";

        var data = {
            "id":eventId,
            "eventTime": eventTimeVal,
            "eventContent": eventContentVal,
            "eventType":eventTypeVal};

        var from_data_ = {data:data,url:url};
        this.ajaxPost.call(from_data_);
    },
    ajaxPost:function(){
        $.ajax({
            type: "POST",
            contentType: "application/json;charset=UTF-8",
            url: this.url,
            data:JSON.stringify(this.data),
            dataType:'json',
            success:function(data){
                $("form span").empty();
                var code = data.resultCode;
                var msg = data.resultMsg;
                if(code=='0000'){
                    window.open(msg,"_parent");
                }else if(code=='0100' || code=='0110'){
                    $(".event_date_ span").text(msg);
                }else if(code=='0200' || code=='0210' || code=='0220'){
                    $(".event_content_ span").text(msg);
                }else{
                    $(".event_date_ span").text(msg);
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown){

            }
        });
    },
    /**
     * 后置处理
     */
    beforePro:function(data){

    },
    /**
     * 非空校验:
     * Object.isBlank(null)      = true
     * Object.isBlank("")        = true
     * Object.isBlank(" ")       = true
     * Object.isBlank("bob")     = false
     * Object.isBlank("  bob  ") = false
     * @param obj 字符串对象
     * @returns {boolean}
     */
    isBlank:function(obj){
        if(typeof obj === 'undefined' ||
            obj === null ||
            obj === '' ||
            obj.length == 0 ||
            obj.trim().length == 0){
            return true;
        }else{
            return false;
        }
    },
    /**
     * 非空校验
     * Object.isBlank(null)      = true
     * Object.isBlank("")        = true
     * Object.isBlank(" ")       = false
     * Object.isBlank("bob")     = false
     * Object.isBlank("  bob  ") = false
     * @param obj
     */
    isEmpty:function(obj){
        if(typeof obj === 'undefined' ||
            obj === null ||
            obj === '' ||
            obj.length == 0){
            return true;
        }else{
            return false;
        }
    },
    /*是否带有小数*/
    isDecimal:function(strValue){
        var  objRegExp = new RegExp("^\d+\.\d+$");
        return  objRegExp.test(strValue);
    },
    /*校验是否中文名称组成 */
    ischina:function(str){
        var reg = new RegExp("^[\u4E00-\u9FA5]{2,4}$");   /*定义验证表达式*/
        return reg.test(str);     /*进行验证*/
    },
    /*校验是否全由8位数字组成 */
    isNumLength:function(str,strLen){
        var reg = new RegExp("^[0-9]{"+strLen+"}$");   /*定义验证表达式*/
        return reg.test(str);     /*进行验证*/
    },
    isCharLength:function(str,strLen){
        var reg = new RegExp("^[a-zA-Z0-9]{"+strLen+"}$");   /*定义验证表达式*/
        return reg.test(str);     /*进行验证*/
    },
    /*校验电话码格式 */
    isTelCode:function(str) {
        var reg= new RegExp("^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$");
        return reg.test(str);
    },
    /*校验邮件地址是否合法 */
    isEmail:function(str) {
        var reg= new RegExp("^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
        return reg.test(str);
    },
    isLength:function(targetLength){
        if(typeof obj !== 'undefined' &&
            obj !== null &&
            obj.trim().length == targetLength ){
            return true;
        }else{
            return false;
        }
        return true;
    },
    checkLength:function(str){
        var reg = new RegExp("^[A-Za-z0-9]{5,18}$");
        return reg.test(str);
    },
    checkPasswd:function(str){
        var reg= new RegExp("[A-Za-z]+[0-9]");
        return reg.test(str);
    },
    // 检查是否为数字
    isNumVerify:function (str) {
        var reg = new RegExp("[0-9]");
        return reg.test(str);
    },
    ifDate:function(str){

    }
}

/*]]>*/