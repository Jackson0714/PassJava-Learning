

email.html



``` html
<!DOCTYPE html>
<html>
<head>
        <meta charset="UTF-8">
        <title>${ENV,var="JOB_NAME"}-第${BUILD_NUMBER}次构建日志</title>
</head>
<body leftmargin="8" marginwidth="0" topmargin="8" marginheight="4" offset="0">
<table width="95%" cellpadding="0" cellspacing="0"
        style="font-size: 11pt; font-family: Tahoma,Arial,Helvetica,sans-serif">
    <tr>
        <td>(本邮件是程序自动下发，请勿回复！)</td>
    </tr>
    <tr>
        <td><h2>
            <font color="#0000FF">构建结果 - ${BUILD_STATUS}</font> 
        </h2></td>
    </tr>
    <tr>
        <td><br />
            <b><font color="#0B610B">构建信息</font></b>
            <ht size="2" width="100%" byte="center" /></td>
    </tr>
    <tr>
        <td>

            <ul>
                <li>项目名称&nbsp;:&nbsp; ${PROJECT_NAME}</li>
                <li>构建编号&nbsp;:&nbsp; 第${BUILD_NUMBER}</li>
                <li>触发方式&nbsp;:${CAUSE}</li>
                <li>构建日志&nbsp;: <a href="${BUILD_URL}console">${BUILD_URL}console</a></li>
                <li>构建&nbsp;&nbsp; Url&nbsp;: &nbsp;<a href="${BUILD_URL}">${BUILD_URL}</a></li>
                <li>工作目录&nbsp;:&nbsp; <a href="${PROJECT_URL}workflow-stage">${PROJECT_URL}workflow-stage</a></li>
                <li>项目&nbsp;:&nbsp;Url&nbsp;:&nbsp;<a href="${PROJECT_URL}">${PROJECT_URL}</a></li>
            </ul>
        </td>
    </tr>
    <tr>

        <td><font color="#0B610B">Changes Since Last
            Successful Build:</font></b>
            <hr size="2" width="100%" byte="center" /></td>
    </tr>
    <tr>
        <td> 
            <ul>
                <li>历史变更记录 : <a href="${PROJECT_URL}changes">${PROJECT_URL}changes</a></li>
            </ul> ${CHANGES_SINCE_LAST_SUCCESS,reverse=true, format="Changes for Build #%n:<br />%c<br />",showPaths=true,changesFormat="<pre>[%a]<br />%m</pre>",pathFormat="%p"}
        </td>
    </tr>   
    <tr>
        <td><b><font color="#0B610B">Failed Test Results</font></b>
            <hr size="2" width="100%" byte="center" /></td>
    </tr>
    <tr>
        <td><pre
                style="font-size: 11pt; font-family: Tahoma,Aarial,Helvetica,sans-serif">$FAILED_TESTS</pre>
                <br />
        </td>
    </tr>
    <tr>
        <td><font><font color="#0B610B">构建日志（最后100行）：</font></b>
            <hr size="2" width="100%" byte="center" /></td>
    </tr>
    <tr>
        <td><textarea cols="80" rows="30" readonly="readonly"
                style="font-family: Courier New">${BUILD_LOG,maxLines=100}</textarea>
        </td>
    </tr>
</table>
</body>
</html>
```

