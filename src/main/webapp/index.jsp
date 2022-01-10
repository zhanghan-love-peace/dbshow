<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>

<body>
<div class="container">
    <div class="card">
        <div class="card-body">
            <div id="test-msg">这里用来现实消息</div>
            <button type="button" class="btn btn-outline-primary" id="test">点击测试后端链接</button>
        </div>
    </div>
</div>
</body>

<script>
    $("#test").click(() => {
        console.log("clicked!");
        $.ajax({
            url: "third-data",
            type: "GET",
            dataType: "text",
            success: result => {
                console.log("ajax success");
                console.log(result);
                $("#test-msg").text(result);
            },
            error: msg => {
                console.log("ajax error");
            }
        });
    });
</script>

</html>