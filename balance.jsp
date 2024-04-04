<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your Bank - Check Balance</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>



<div class="container">
    <h2>Check Balance</h2>
    <form action="CheckBalance" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
        <button type="submit">Check Balance</button>
    </form>

    <div id="balanceResult">
        <!-- The balance will be displayed here -->
    </div>
</div>

</body>
</html>
