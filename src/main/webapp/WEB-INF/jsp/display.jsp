<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Maintenance</title>
        <style>
            /*table {border-collapse: collapse; }*/
            table, tr, th, td {border: 1px solid black; }
        </style>
    </head>
    <body>
        <h1>Products</h1>
        ${displayProducts}
		<br>
        <form action="/ProductMaintenance/addProduct" method="post">
            <input type="hidden" name="action" value="updateRequest">
            <input type="hidden" name="productCode" value="null">
            <input type="hidden" name="code" value="null">
            <input type="hidden" name="description" value="null">
            <input type="hidden" name="price" value="null">
            <input type="submit" value="Add Product"></input>
        </form>
    </body>
</html>