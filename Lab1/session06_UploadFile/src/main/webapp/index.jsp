<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
        }
        form {
            display: inline-block;
            margin-top: 50px;
            border: 1px solid #ccc;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            font-size: 24px;
            margin-bottom: 20px;
        }
        input[type="file"] {
            margin-bottom: 10px;
        }
        input[type="submit"], input[type="reset"] {
            padding: 10px 20px;
            margin: 10px;
            border: none;
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
            border-radius: 5px;
        }
        input[type="reset"] {
            background-color: #f44336;
        }
    </style>
</head>
<body>
<form action="upload" method="post" enctype="multipart/form-data">
    <h1>Upload multi-files</h1>
    <div>
        <label for="file1">File #1:</label>
        <input type="file" name="file1" id="file1">
    </div>
    <div>
        <label for="file2">File #2:</label>
        <input type="file" name="file2" id="file2">
    </div>
    <div>
        <label for="file3">File #3:</label>
        <input type="file" name="file3" id="file3">
    </div>
    <div>
        <label for="file4">File #4:</label>
        <input type="file" name="file4" id="file4">
    </div>
    <div>
        <label for="file5">File #5:</label>
        <input type="file" name="file5" id="file5">
    </div>
    <div>
        <input type="submit" value="Upload">
        <input type="reset" value="Reset">
    </div>
</form>
</body>
</html>