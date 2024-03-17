<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <link rel="stylesheet" href="style.css">
    <title>form</title>
    </head>
    <body>
        <h1>E-Bookshop</h1>
        <div class="form-container">
            <form action="process" method="post" >
                <br>
                <label>Book name</label>
                <input type="text" name="name" id="name"/>
                <br>
                <label>Book author</label>
                <input type="text" name="author" id="author"/>
                <br>
                <label>Book price</label>
                <input type="text" name="price" id="price"/>
                <br>
                <label>Quantity</label>
                <input type="number" name="quantity" id="quantity"/>
                <br>
                <input type="submit" value="submit" /><br>
                <a href="display">View Inserted Data</a>
            </form>
           
        </div>
          
    </body>
</html>