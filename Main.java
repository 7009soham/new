Here are the code snippets categorized for HTML, CSS, JavaScript, and PHP tasks from the provided practical slips. Each snippet is concise and aligned with the exam topics.  

---

## **HTML & CSS Code Snippets**

### **1. Create Lists (Slip 1)**
```html
<!DOCTYPE html>
<html>
<head><title>Lists</title></head>
<body>
    <h3>Ordered List</h3>
    <ol>
        <li>Item 1</li>
        <li>Item 2</li>
        <li>Item 3</li>
    </ol>
    <h3>Unordered List</h3>
    <ul>
        <li>Item A</li>
        <li>Item B</li>
        <li>Item C</li>
    </ul>
</body>
</html>
```

### **2. Resume Using HTML & CSS (Slip 4)**
```html
<!DOCTYPE html>
<html>
<head>
    <title>Resume</title>
    <style>
        body { font-family: Arial, sans-serif; line-height: 1.6; }
        .container { width: 70%; margin: auto; }
        h1 { color: #333; }
        section { margin: 20px 0; }
    </style>
</head>
<body>
    <div class="container">
        <h1>John Doe</h1>
        <p><b>Email:</b> john@example.com | <b>Phone:</b> 123-456-7890</p>
        <section>
            <h2>Education</h2>
            <ul>
                <li>Bachelor of Science in Computer Science</li>
                <li>XYZ University, 2023</li>
            </ul>
        </section>
        <section>
            <h2>Skills</h2>
            <ul>
                <li>HTML, CSS, JavaScript</li>
                <li>PHP, MySQL</li>
            </ul>
        </section>
    </div>
</body>
</html>
```

### **3. HTML Calculator with JavaScript (Slip 8)**
```html
<!DOCTYPE html>
<html>
<head><title>Calculator</title></head>
<body>
    <h1>Calculator</h1>
    <input id="num1" type="number" placeholder="Enter number 1">
    <input id="num2" type="number" placeholder="Enter number 2">
    <button onclick="calculate('+')">Add</button>
    <button onclick="calculate('-')">Subtract</button>
    <button onclick="calculate('*')">Multiply</button>
    <button onclick="calculate('/')">Divide</button>
    <h2 id="result">Result: </h2>
    <script>
        function calculate(op) {
            let num1 = parseFloat(document.getElementById('num1').value);
            let num2 = parseFloat(document.getElementById('num2').value);
            let result = eval(`${num1} ${op} ${num2}`);
            document.getElementById('result').textContent = 'Result: ' + result;
        }
    </script>
</body>
</html>
```

---

## **PHP Code Snippets**

### **1. PHP Data Types (Slip 1)**
```php
<?php
$int = 10;
$float = 20.5;
$string = "Hello, PHP!";
$bool = true;
$array = [1, 2, 3];
echo "Integer: $int\nFloat: $float\nString: $string\nBoolean: $bool\nArray: ";
print_r($array);
?>
```

### **2. PHP CRUD Operations (Slip 2 & 3)**
```php
<?php
$mysqli = new mysqli("localhost", "root", "", "placement");

// Create
$mysqli->query("CREATE TABLE IF NOT EXISTS courses (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50))");
$mysqli->query("INSERT INTO courses (name) VALUES ('PHP'), ('MySQL')");

// Read
$result = $mysqli->query("SELECT * FROM courses");
while ($row = $result->fetch_assoc()) {
    echo "{$row['id']} - {$row['name']}<br>";
}

// Update
$mysqli->query("UPDATE courses SET name='Advanced PHP' WHERE id=1");

// Delete
$mysqli->query("DELETE FROM courses WHERE id=2");
?>
```

### **3. PHP File Handling (Slip 12 & 19)**
```php
<?php
$file = "example.txt";

// Create and Write
file_put_contents($file, "Hello, World!");

// Read
if (file_exists($file)) echo file_get_contents($file);

// Append
file_put_contents($file, "\nAppended Text", FILE_APPEND);

// Delete
unlink($file);
?>
```

### **4. PHP Sessions and Cookies (Slip 6)**
```php
<?php
// Start Session
session_start();
$_SESSION['user'] = "John";

// Display Session
echo "Session User: " . $_SESSION['user'];

// Set Cookie
setcookie("user", "John", time() + 3600);

// Display Cookie
echo "Cookie User: " . $_COOKIE['user'] ?? "Cookie Expired";
?>
```

### **5. PHP Pagination (Slip 3)**
```php
<?php
$mysqli = new mysqli("localhost", "root", "", "mydb");
$limit = 5; // Limit rows per page
$page = isset($_GET['page']) ? $_GET['page'] : 1;
$offset = ($page - 1) * $limit;

// Fetch paginated results
$result = $mysqli->query("SELECT * FROM mytable LIMIT $offset, $limit");
while ($row = $result->fetch_assoc()) {
    echo "{$row['id']} - {$row['name']}<br>";
}

// Pagination Links
$total = $mysqli->query("SELECT COUNT(*) as total FROM mytable")->fetch_assoc()['total'];
$total_pages = ceil($total / $limit);

for ($i = 1; $i <= $total_pages; $i++) {
    echo "<a href='?page=$i'>$i</a> ";
}
?>
```

---

## **JavaScript Code Snippets**

### **Form Validation**
```html
<form onsubmit="return validateForm()">
    <input id="name" type="text" placeholder="Name">
    <input id="email" type="email" placeholder="Email">
    <button type="submit">Submit</button>
</form>
<script>
    function validateForm() {
        let name = document.getElementById('name').value;
        let email = document.getElementById('email').value;
        if (name === "" || email === "") {
            alert("All fields are required!");
            return false;
        }
        return true;
    }
</script>
```

---
o
This cheat sheet provides the essential snippets required for your exams. Let me know if you need additional explanations or variations!
  Here’s the continuation of the code snippets from the provided slips:

---

## **PHP Advanced Concepts**

### **1. Traits and Namespaces (Slip 3)**
```php
<?php
namespace MyNamespace;
trait Logger {
    public function log($message) {
        echo "Log: $message";
    }
}

class MyClass {
    use Logger;
}

$obj = new MyClass();
$obj->log("This is a message.");
?>
```

---

### **2. Error and Exception Handling (Slip 5 & 19)**
```php
<?php
try {
    $db = new PDO("mysql:host=localhost;dbname=testdb", "root", "");
    echo "Connected successfully";
} catch (PDOException $e) {
    echo "Connection failed: " . $e->getMessage();
} finally {
    echo "Attempted to connect to database.";
}
?>
```

---

### **3. PHP Constants and Static Variables (Slip 6)**
```php
<?php
// Constants
define("SITE_NAME", "MyWebsite");
echo SITE_NAME;

// Static Variable
function counter() {
    static $count = 0;
    $count++;
    echo $count;
}
counter();
counter();
?>
```

---

### **4. Abstract Classes and Interfaces (Slip 17)**
```php
<?php
abstract class Animal {
    abstract public function sound();
}

interface Flyable {
    public function fly();
}

class Bird extends Animal implements Flyable {
    public function sound() {
        echo "Chirp";
    }
    public function fly() {
        echo "I can fly!";
    }
}

$bird = new Bird();
$bird->sound();
$bird->fly();
?>
```

---

## **JavaScript Interactivity**

### **1. Change Background Color (Slip 13)**
```html
<button onclick="changeBgColor('red')">Red</button>
<button onclick="changeBgColor('blue')">Blue</button>
<script>
    function changeBgColor(color) {
        document.body.style.backgroundColor = color;
    }
</script>
```

---

### **2. Switch Bulb On/Off (Slip 13)**
```html
<img id="bulb" src="bulb_off.png" alt="Bulb">
<button onclick="toggleBulb()">Switch On/Off</button>
<script>
    function toggleBulb() {
        let bulb = document.getElementById('bulb');
        bulb.src = bulb.src.includes("off") ? "bulb_on.png" : "bulb_off.png";
    }
</script>
```

---

## **Database Connectivity**

### **1. Prepared Statement Execution (Slip 8)**
```php
<?php
$mysqli = new mysqli("localhost", "root", "", "testdb");

$stmt = $mysqli->prepare("INSERT INTO users (name, email) VALUES (?, ?)");
$stmt->bind_param("ss", $name, $email);

$name = "John Doe";
$email = "john@example.com";
$stmt->execute();

echo "Record inserted.";
$stmt->close();
?>
```

---

### **2. File Upload/Download (Slip 10)**
```php
<?php
// File Upload
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $file = $_FILES['file'];
    if ($file['type'] == "image/jpeg" || $file['type'] == "image/png") {
        move_uploaded_file($file['tmp_name'], "uploads/" . $file['name']);
        echo "File uploaded successfully!";
    } else {
        echo "Only JPEG and PNG files are allowed.";
    }
}
?>

<form method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <button type="submit">Upload</button>
</form>
```

---

## **Miscellaneous PHP Concepts**

### **1. Method Overloading and Overriding (Slip 7)**
```php
<?php
class Base {
    public function greet() {
        echo "Hello from Base!";
    }
}

class Derived extends Base {
    public function greet() {
        echo "Hello from Derived!";
    }
}

$obj = new Derived();
$obj->greet(); // Calls the overridden method
?>
```

---

### **2. Pagination (Slip 20)**
```php
<?php
$mysqli = new mysqli("localhost", "root", "", "mydb");
$limit = 10;
$page = isset($_GET['page']) ? $_GET['page'] : 1;
$offset = ($page - 1) * $limit;

$result = $mysqli->query("SELECT * FROM items LIMIT $offset, $limit");
while ($row = $result->fetch_assoc()) {
    echo $row['id'] . " - " . $row['name'] . "<br>";
}

$total_items = $mysqli->query("SELECT COUNT(*) AS count FROM items")->fetch_assoc()['count'];
$total_pages = ceil($total_items / $limit);

for ($i = 1; $i <= $total_pages; $i++) {
    echo "<a href='?page=$i'>$i</a> ";
}
?>
```

---

Let me know if you'd like even more advanced snippets or further breakdowns of specific topics!
  Here’s a compilation of **JavaScript practical examination code snippets** based on the slips provided:

---

## **1. Login and Registration Form Validation (Slip 2)**

```html
<form id="loginForm" onsubmit="return validateLogin()">
    <h3>Login</h3>
    <input type="text" id="loginUsername" placeholder="Username">
    <input type="password" id="loginPassword" placeholder="Password">
    <button type="submit">Login</button>
</form>

<form id="registerForm" onsubmit="return validateRegister()">
    <h3>Register</h3>
    <input type="text" id="regUsername" placeholder="Username">
    <input type="password" id="regPassword" placeholder="Password">
    <input type="password" id="confirmPassword" placeholder="Confirm Password">
    <button type="submit">Register</button>
</form>

<script>
    function validateLogin() {
        const username = document.getElementById('loginUsername').value;
        const password = document.getElementById('loginPassword').value;
        if (!username || !password) {
            alert("All fields are required.");
            return false;
        }
        alert("Login successful!");
        return true;
    }

    function validateRegister() {
        const username = document.getElementById('regUsername').value;
        const password = document.getElementById('regPassword').value;
        const confirmPassword = document.getElementById('confirmPassword').value;
        if (!username || !password || !confirmPassword) {
            alert("All fields are required.");
            return false;
        }
        if (password !== confirmPassword) {
            alert("Passwords do not match.");
            return false;
        }
        alert("Registration successful!");
        return true;
    }
</script>
```

---

## **2. Display User Details from a Registration Form (Slip 3)**

```html
<form id="registrationForm" onsubmit="return displayDetails(event)">
    <h3>Register</h3>
    <input type="text" id="name" placeholder="Name" required>
    <input type="email" id="email" placeholder="Email" required>
    <input type="number" id="age" placeholder="Age" required>
    <button type="submit">Submit</button>
</form>

<div id="details"></div>

<script>
    function displayDetails(event) {
        event.preventDefault();
        const name = document.getElementById('name').value;
        const email = document.getElementById('email').value;
        const age = document.getElementById('age').value;
        const detailsDiv = document.getElementById('details');
        detailsDiv.innerHTML = `<h3>User Details</h3><p>Name: ${name}</p><p>Email: ${email}</p><p>Age: ${age}</p>`;
        return false;
    }
</script>
```

---

## **3. Change Background, Font Color, and Font Size (Slip 13)**

```html
<button onclick="changeBackgroundColor('lightblue')">Change Background</button>
<button onclick="changeFontColor('red')">Change Font Color</button>
<button onclick="changeFontSize('20px')">Change Font Size</button>

<p id="text">This is a sample text.</p>

<script>
    function changeBackgroundColor(color) {
        document.body.style.backgroundColor = color;
    }
    function changeFontColor(color) {
        document.getElementById('text').style.color = color;
    }
    function changeFontSize(size) {
        document.getElementById('text').style.fontSize = size;
    }
</script>
```

---

## **4. Switch On and Off a Bulb (Slip 13)**

```html
<img id="bulb" src="bulb_off.png" alt="Bulb">
<button onclick="toggleBulb()">Switch On/Off</button>

<script>
    function toggleBulb() {
        const bulb = document.getElementById('bulb');
        bulb.src = bulb.src.includes('off') ? 'bulb_on.png' : 'bulb_off.png';
    }
</script>
```

---

## **5. HTML Calculator (Slip 8)**

```html
<h3>Calculator</h3>
<input type="number" id="num1" placeholder="Number 1">
<input type="number" id="num2" placeholder="Number 2">
<select id="operator">
    <option value="+">Add</option>
    <option value="-">Subtract</option>
    <option value="*">Multiply</option>
    <option value="/">Divide</option>
</select>
<button onclick="calculate()">Calculate</button>
<p id="calcResult">Result: </p>

<script>
    function calculate() {
        const num1 = parseFloat(document.getElementById('num1').value);
        const num2 = parseFloat(document.getElementById('num2').value);
        const operator = document.getElementById('operator').value;
        const result = eval(`${num1} ${operator} ${num2}`);
        document.getElementById('calcResult').innerText = `Result: ${result}`;
    }
</script>
```

---

## **6. Demonstrate HTML Window Events (Slip 12)**

```html
<h3>Window Events</h3>
<button onclick="onClick()">Click Me</button>
<input type="text" onfocus="onFocus()" onblur="onBlur()" placeholder="Focus/Blur Here">
<div onmouseover="onMouseOver()" onmouseout="onMouseOut()">Hover Over Me</div>

<script>
    function onClick() { alert("Button clicked!"); }
    function onFocus() { console.log("Input focused."); }
    function onBlur() { console.log("Input lost focus."); }
    function onMouseOver() { console.log("Mouse hovered."); }
    function onMouseOut() { console.log("Mouse left."); }
</script>
```

---

## **7. Image, Video, and Audio Demo (Slip 18)**

```html
<h3>Multimedia Elements</h3>

<img src="example.jpg" alt="Sample Image" width="300">
<video controls>
    <source src="sample.mp4" type="video/mp4">
    Your browser does not support the video tag.
</video>
<audio controls>
    <source src="sample.mp3" type="audio/mpeg">
    Your browser does not support the audio tag.
</audio>
```

---

## **8. HTML Cursor Types (Slip 17)**

```html
<h3>Cursor Types</h3>
<div style="cursor: pointer;">Pointer</div>
<div style="cursor: crosshair;">Crosshair</div>
<div style="cursor: move;">Move</div>
<div style="cursor: text;">Text</div>
<div style="cursor: wait;">Wait</div>
```

---

Let me know if you need additional snippets or further explanation!

  Here are examples of **functionalities** in **HTML, CSS, JavaScript, PHP, and AngularJS**, demonstrating basic and commonly required features:

---

## **HTML Functionalities**

### **1. Form Submission**
```html
<form action="/submit" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name">
    <button type="submit">Submit</button>
</form>
```

### **2. Table with Merged Cells**
```html
<table border="1">
    <tr>
        <th colspan="2">Name</th>
        <th rowspan="2">Age</th>
    </tr>
    <tr>
        <td>First</td>
        <td>Last</td>
    </tr>
</table>
```

---

## **CSS Functionalities**

### **3. Responsive Design with Media Queries**
```html
<style>
    body {
        font-family: Arial, sans-serif;
    }

    .box {
        width: 50%;
        margin: auto;
        background-color: lightblue;
        text-align: center;
        padding: 20px;
    }

    @media (max-width: 600px) {
        .box {
            width: 90%;
        }
    }
</style>

<div class="box">Responsive Box</div>
```

### **4. Animated Button**
```html
<style>
    .btn {
        padding: 10px 20px;
        background-color: blue;
        color: white;
        border: none;
        transition: background-color 0.3s, transform 0.3s;
    }

    .btn:hover {
        background-color: darkblue;
        transform: scale(1.1);
    }
</style>

<button class="btn">Hover Me</button>
```

---

## **JavaScript Functionalities**

### **5. Show/Hide Content**
```html
<p id="content" style="display: none;">This is hidden content.</p>
<button onclick="toggleContent()">Show/Hide Content</button>

<script>
    function toggleContent() {
        const content = document.getElementById('content');
        content.style.display = content.style.display === 'none' ? 'block' : 'none';
    }
</script>
```

### **6. Dropdown Menu**
```html
<select onchange="showSelectedValue(this.value)">
    <option value="Option 1">Option 1</option>
    <option value="Option 2">Option 2</option>
    <option value="Option 3">Option 3</option>
</select>
<p id="selectedValue">Selected Value: None</p>

<script>
    function showSelectedValue(value) {
        document.getElementById('selectedValue').textContent = "Selected Value: " + value;
    }
</script>
```

---

## **PHP Functionalities**

### **7. Save Form Data to a File**
```php
<?php
if ($_SERVER["REQUEST_METHOD"] === "POST") {
    $name = $_POST['name'];
    file_put_contents("data.txt", $name . "\n", FILE_APPEND);
    echo "Data saved successfully!";
}
?>

<form method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name">
    <button type="submit">Save</button>
</form>
```

---

### **8. Display Records from a Database**
```php
<?php
$mysqli = new mysqli("localhost", "root", "", "testdb");

$result = $mysqli->query("SELECT * FROM users");
echo "<table border='1'><tr><th>ID</th><th>Name</th></tr>";
while ($row = $result->fetch_assoc()) {
    echo "<tr><td>{$row['id']}</td><td>{$row['name']}</td></tr>";
}
echo "</table>";
?>
```

---

## **AngularJS Functionalities**

### **9. Real-Time Data Binding**
```html
<!DOCTYPE html>
<html ng-app="myApp">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
</head>
<body ng-controller="myCtrl">
    <input type="text" ng-model="name" placeholder="Enter your name">
    <p>Hello, {{ name }}!</p>

    <script>
        angular.module('myApp', []).controller('myCtrl', function ($scope) {
            $scope.name = "User";
        });
    </script>
</body>
</html>
```

---

### **10. List Rendering**
```html
<!DOCTYPE html>
<html ng-app="myApp">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
</head>
<body ng-controller="myCtrl">
    <ul>
        <li ng-repeat="item in items">{{ item }}</li>
    </ul>

    <script>
        angular.module('myApp', []).controller('myCtrl', function ($scope) {
            $scope.items = ["Item 1", "Item 2", "Item 3"];
        });
    </script>
</body>
</html>
```

---

Let me know if you want specific functionalities or further expansions for these topics!

      <style>
    p::before {
        content: "👉 ";
    }
    p::after {
        content: " 👈";
    }
</style>

<p>This paragraph has decorative symbols before and after.</p>
  Here’s a detailed guide to **AngularJS**, covering its basic functionalities, concepts, and code examples:

---

## **What is AngularJS?**

AngularJS is a **JavaScript framework** developed by Google to build dynamic, single-page web applications (SPAs). It extends HTML with additional attributes and binds data to HTML using JavaScript.

---

## **Key Features of AngularJS**

1. **Two-Way Data Binding**: Synchronizes data between the model (JavaScript) and the view (HTML).
2. **Directives**: Extends HTML with custom attributes (e.g., `ng-app`, `ng-model`, `ng-repeat`).
3. **Dependency Injection**: Handles the creation and management of objects and dependencies.
4. **Filters**: Formats data displayed to users (e.g., currency, date).
5. **MVC Architecture**: Divides the application into Model, View, and Controller.

---

## **AngularJS Basics**

### **1. Setting Up AngularJS**
Include the AngularJS library in your HTML file using a CDN:
```html
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
```

---

### **2. AngularJS Basic Example**
```html
<!DOCTYPE html>
<html ng-app="myApp">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
</head>
<body ng-controller="myCtrl">
    <h1>{{ message }}</h1>

    <script>
        angular.module('myApp', [])
        .controller('myCtrl', function($scope) {
            $scope.message = "Hello, AngularJS!";
        });
    </script>
</body>
</html>
```

---

## **AngularJS Functionalities**

### **3. Two-Way Data Binding**
```html
<!DOCTYPE html>
<html ng-app="myApp">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
</head>
<body ng-controller="myCtrl">
    <input type="text" ng-model="name">
    <p>Hello, {{ name }}!</p>

    <script>
        angular.module('myApp', [])
        .controller('myCtrl', function($scope) {
            $scope.name = "John Doe";
        });
    </script>
</body>
</html>
```

---

### **4. ng-repeat (List Rendering)**
```html
<!DOCTYPE html>
<html ng-app="myApp">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
</head>
<body ng-controller="myCtrl">
    <ul>
        <li ng-repeat="item in items">{{ item }}</li>
    </ul>

    <script>
        angular.module('myApp', [])
        .controller('myCtrl', function($scope) {
            $scope.items = ["Item 1", "Item 2", "Item 3"];
        });
    </script>
</body>
</html>
```

---

### **5. Filters**
```html
<!DOCTYPE html>
<html ng-app="myApp">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
</head>
<body ng-controller="myCtrl">
    <p>Original: {{ amount }}</p>
    <p>Currency: {{ amount | currency }}</p>
    <p>Uppercase: {{ name | uppercase }}</p>

    <script>
        angular.module('myApp', [])
        .controller('myCtrl', function($scope) {
            $scope.amount = 1234.56;
            $scope.name = "angularjs";
        });
    </script>
</body>
</html>
```

---

### **6. Form Validation**
```html
<!DOCTYPE html>
<html ng-app="myApp">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
</head>
<body ng-controller="myCtrl">
    <form name="myForm">
        <input type="text" ng-model="user.name" placeholder="Enter name" required>
        <span ng-show="myForm.$dirty && myForm.$invalid">Name is required!</span>
    </form>

    <script>
        angular.module('myApp', [])
        .controller('myCtrl', function($scope) {
            $scope.user = {};
        });
    </script>
</body>
</html>
```

---

### **7. Dependency Injection**
```html
<!DOCTYPE html>
<html ng-app="myApp">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
</head>
<body ng-controller="myCtrl">
    <p>{{ serviceMessage }}</p>

    <script>
        angular.module('myApp', [])
        .controller('myCtrl', function($scope, myService) {
            $scope.serviceMessage = myService.getMessage();
        })
        .service('myService', function() {
            this.getMessage = function() {
                return "Hello from AngularJS Service!";
            };
        });
    </script>
</body>
</html>
```

---

### **8. Routing with ngRoute**
**Install AngularJS routing using the CDN:**
```html
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular-route.min.js"></script>
```

**Example Code:**
```html
<!DOCTYPE html>
<html ng-app="myApp">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular-route.min.js"></script>
</head>
<body>
    <a href="#!home">Home</a> | <a href="#!about">About</a>
    <div ng-view></div>

    <script>
        angular.module('myApp', ['ngRoute'])
        .config(function($routeProvider) {
            $routeProvider
            .when("/home", {
                template: "<h1>Welcome to Home</h1>"
            })
            .when("/about", {
                template: "<h1>About Us</h1>"
            })
            .otherwise({
                redirectTo: "/home"
            });
        });
    </script>
</body>
</html>
```

---

### **9. Create a Custom Directive**
```html
<!DOCTYPE html>
<html ng-app="myApp">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
</head>
<body>
    <custom-directive></custom-directive>

    <script>
        angular.module('myApp', [])
        .directive('customDirective', function() {
            return {
                template: "<h1>This is a custom directive!</h1>"
            };
        });
    </script>
</body>
</html>
```

---

### **10. HTTP Request (Fetching Data)**
```html
<!DOCTYPE html>
<html ng-app="myApp">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
</head>
<body ng-controller="myCtrl">
    <ul>
        <li ng-repeat="post in posts">{{ post.title }}</li>
    </ul>

    <script>
        angular.module('myApp', [])
        .controller('myCtrl', function($scope, $http) {
            $http.get("https://jsonplaceholder.typicode.com/posts")
            .then(function(response) {
                $scope.posts = response.data;
            });
        });
    </script>
</body>
</html>
```

---

Let me know if you’d like to dive deeper into specific AngularJS concepts!
  
