<%--
  Created by IntelliJ IDEA.
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <link href="core/js/lib/artDialog/skins/blue.css" rel="stylesheet" />
    <script src="core/js/lib/jquery/1.9.1/jquery.js"></script>
    <script src="core/js/lib/artDialog/jquery.artDialog.js"></script>
    <script src="core/js/lib/artDialog/plugins/iframeTools.source.js"></script>

    <script language="javascript">

        function showModalDialog(){
            $.dialog.open("art_dialog_test.jsp", {height:'80%', width:'80%', lock: true});

//            $.dialog({
//                title: "模态弹出框",
//                content: '这个是直接让你显示HTML代码，例Hello<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR> 这个是直接让你显示HTML代码，例Hello<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR>这个是直接让<BR> ',
//                lock: true,
//                width: 800,
//                height: 300,
//                left: '0%',
//                top: '0%',
//                resize: true,
//                drag: true
//            });
        }
    </script>
</head>
<body>
    <input type="button" value="显示模态窗口" onclick="showModalDialog()" />
</body>
</html>