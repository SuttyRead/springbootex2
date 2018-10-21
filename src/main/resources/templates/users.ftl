<html>
<head>
    <title>Title</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Please Sign Up!
    </div>
    <form method="post" action="/users">
        <label for="firstName">First Name
            <input class="input-field" type="text" id="firstName" name="firstName">
        </label>
        <label for="lastName">Last Name
            <input class="input-field" type="text" id="lastName" name="lastName">
        </label>
        <input type="submit" value="Add user">
    </form>
</div>

<div class="form-style-2">
    <div class="form-style-2-heading">
        Already in System!
    </div>
    <table>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
        </tr>

            <#list usersFromServer as user>
                <tr>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td><a href="UserController?action=updateUser&userId=${user.id}">Update</a></td>
                    <td><a href="UserController?action=deleteUser&userId=${user.id}">Delete</a></td>
                </tr>
            </#list>


    </table>
</div>
</body>
</html>