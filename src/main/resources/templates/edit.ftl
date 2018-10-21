<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create user page</title>
</head>
<body>

<form method="post" action="/edit/${userEdit.id}">
    <label for="firstName">First Name
        <input class="input-field" type="text" id="firstName" name="firstName" value="${userEdit.firstName}">
    </label>
    <label for="lastName">Last Name
        <input class="input-field" type="text" id="lastName" name="lastName" value="${userEdit.lastName}">
    </label>
    <input type="submit" value="Update">
</form>

</body>
</html>