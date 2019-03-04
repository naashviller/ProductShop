<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Products</title>
</head>
<body>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<table>
    <div>
        <tr>
        <#list products as product>
            <td>${product.name}</td>
            <td>${product.cost}</td>
            <td>
                <button type="submit" id="${product.id}" onclick="addToBasket(this.id)">Купить!</button>
            </td>
            <br/>
        </#list>
        </tr>
        <button>Корзина</button>

    </div>
</table>

<script type="text/javascript">
    function addToBasket(id) {
        $.ajax({
            type: "POST",
            url: "/api/add/"+id,
            ContentType: "json",
            data: {id: id} /*
            success: function (res) {
                var result = "",



            .html(result);

            },
            error: function () {
                alert("Error while request!")
            }
*/
        });


    }
</script>


</body>
</html>