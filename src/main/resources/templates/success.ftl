<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Products</title>
</head>
<body>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>

<#--<div>
    <tr>
    <#list products as product>
        <td>${product.name}</td>
        <td>${product.cost}</td>
        <td>
            <button type="submit" id="result" onClick="addProduct();">Купить!</button>
        </td>
        <br/>
    </#list>
    </tr>
</div>-->

<script type="text/javascript">
    function addProduct() {
        $.ajax({
            type: "POST",
            url: "/add",
            ContentType: "json",
            data: {
                id: $('#id').val()
            },
            success: function (res) {
                var result = "",


                        $('#result').html(result);

            },
            error: function () {
                alert("Error while request!")
            }

        });

    }
</script>


</body>
</html>