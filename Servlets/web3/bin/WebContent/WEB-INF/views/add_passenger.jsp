<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>World Adventures Airlines</title>
</head>

<body>
    <div class="container">
        <div class="title">Add Passenger</div>
        <fieldset>
            <legend>Passenger Details</legend>
            <form action="AddPassenger" method="post">
                <div class="inputfield">
                    <label for="firstname" class="inpulabel">First Name: </label>
                    <input name="firstname" type="text"></input>
                </div>
                <div class="inputfield">
                    <label for="lastname" class="inpulabel">Last Name: </label>
                    <input name="lastname" type="text"></input>
                </div>
                <div class="inputfield">
                    <label for="dob" class="inpulabel">Date of Birth: </label>
                    <input name="dob" type="text"></input>
                </div>
                <div class="inputfield">
                    <label for="gender" class="inpulabel">Gender: </label>
                    <select name="gender">
                        <option value="male">Male</option>
                        <option value="female">Female</option>
                    </select>
                </div>
                <div class="inputfield">
                    <input name="submit" type="submit" value="Add Passenger"></input>
                </div>

            </form>
        </fieldset>
    </div>
</body>

</html>