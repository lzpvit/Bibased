/**
 * Created by LZP on 2018/3/25.
 */
var send_message_board = function () {
    var result = "null";
    var data = '{"name":"name","email":"0","content":"2018525"}';
    var x=$("#form_message").serializeArray();
    var t="{";
    $.each(x, function(i, field){
        t+="\""+field.name+"\":\""+field.value+"\"";
        if(x.length-1!=i){t+=',';}
    });
    t+="}";
    $.ajax({
        type:"POST",
        contentType : 'application/json',
        url :"/ajax",
        cache: false,
        async : false,
        dataType:"json",
        data : t,
        success:function(json){
            // alert(json['message_board_insert']);
        },
        error:function () {
            alert("¡Ù—‘ ß∞‹");
        }
    });
    return result;
}
