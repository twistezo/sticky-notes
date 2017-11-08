[![Build Status](https://travis-ci.org/twistezo/sticky-notes.svg?branch=master)](https://travis-ci.org/twistezo/sticky-notes)

## Sticky-Notes

### Description
RESTful secured web service for manage to-do notes and users (non-commercial)

### Tools
Java, Spring, Hibernate, MySQL, Thymeleaf, Bootstrap, JavaScript

### Features WEB
- spring security (registration, login)
- bcrypted passwords
- access permissions
- forms validation
- CRUD operations
- MySQL database

### Features ANDROID
- consuming JSONs from RESTful web service

### Source code ANDROID
github.com/twistezo/sticky-notes-android-client

### Requirements
Java, mySQL, Maven

### Run, Test
```
// prepare new user and empty DB
mysql -u root -p -e 'CREATE DATABASE IF NOT EXISTS sticky_notes_db;'
mysql -u root -p -e "CREATE USER 'dev'@'localhost' IDENTIFIED BY 'dev';"
mysql -u root -p -e "GRANT ALL ON sticky_notes_db.* TO 'dev'@'localhost';"

// default username/password -> admin/admin
mvn spring-boot:run -> localhost:8080
mvn test
```

### Screenshots


<table>
    <tr>
        <td>
            <img src="https://i.imgur.com/9bdYdUr.png" width="500">
        </td>
    </tr>
    <tr>
        <td>
            <img src="http://i.imgur.com/GNY490G.png" width="500">
        </td>
        <td>
            <img src="http://i.imgur.com/Z7EzZtR.png" width="500">
        </td>
    </tr>
    </tr>
    <tr>
        <td>
            <img src="http://i.imgur.com/0DWk564.png" width="500">
        </td>
        <td>
            <img src="http://i.imgur.com/icBlMS3.png" width="500">
        </td>
    </tr>
</table>






</table>
