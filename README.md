# Cars' API with Spring Boot 3

This project is RESTful APIs study that perform local CRUD operations. It was developed by following instructions from the [RESTful API with SpringBoot](https://www.udemy.com/course/springboot-essencial/) course, taught by Ricardo Lecheta on Udemy.

## Tech Stack

- **Language:** Java
- **Build and Management Tool:** Maven
- **Database:** MySQL
- **Framework:** Spring
  - Spring Boot 3
  - Spring Security 6
- **Testing:** JUnit and H2 database
- **Boilerplate reduction:** Lombok
- **Object Mapping:** Model Mapper

## Running Locally

### Requisites

To run this project in your local machine you must have:

- **JDK**[^1]
- **Maven**[^2]
- **MySQL** (another database would work, but make sure to check its syntax)[^3]
- **Postman**[^4]

[^1]: JDK stands for Java Development Kit, which is required to develop Java applications locally. I recommend using an open version of JDK ([Which Version of JDK Should I Use?](https://whichjdk.com/)).

[^2]: Maven is a project manager and build tool. If you need it, [follow these instructions](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html).

[^3]: If you are not familiar with MySQL command line or prefer to use a GUI, I recommend installing MySQL Workbench. The left-side column of the [MySQL documentation](https://dev.mysql.com/doc/refman/8.0/en/getting-mysql.html) has a manual for installation on different OS.

[^4]: Postman is a tool to test APIs. [Postman Installation](https://www.postman.com/downloads/)

<br>

Clone the project:

```bash
  git clone https://github.com/alexandrehcr/restful-api-with-spring-boot-3.git
```

Go to the project directory:

```bash
  cd my-project
```

### Setting the database

The database schema and insert examples are placed in the MySQL folder. From the project directoy, run:

```bash
  cd mysql
```

Initialize the MySQL shell replacing `<your_user_name>` with your username, then enter your password when the terminal prompts you to do so:

```bash
  mysql.exe --user=<your_user_name> --password 
```

Next, you can create and populate the database by copying and pasting the `schema.sql` and `inserts.sql` files into the terminal, or by using the MySQL Workbench query window. This will create the `cars_api` database with the tables: `cars`, `users`, `roles`, and `user_roles`, and populate them.

Finally, update the `spring.datasource.username` and `spring.datasource.passord` properties in the `src/main/resources/application.properties` file to match your MySQL login.

----

Go back to the project directory and build it:

```bash
  cd ../
```

```bash
mvn clean install
```

Go to the target folder:

```bash
  cd target
```

Run the generated `.jar` file, and you're ready to test:

```bash
  java -jar cars-0.0.1-SNAPSHOT.jar
```

## API Reference

The database has two registered roles: `USER` and `ADMIN`. All users must register and authenticate through basic authentication to use the API. The `insert.sql` file contains two registered users: `user` and `admin`, with passwords and roles corresponding to their usernames.

Users with `USER` privilege can only `GET` data, while `ADMIN` users can also `POST`, `PUT`, and `DELETE` data. For `POST` and `PUT` requests, `ADMIN` users must include a JSON request body with the appropriate fields.

Successful `GET`, `POST`, and `DELETE` requests returns status `200 OK`. Sucessfull `POST` requests return `201 Created`.

For `ADMIN` users, requests to not found resources return status `404 Not Found`. For user without `ADMIN` privilege, only `GET` requests return 404. Otherwise, the response is `403 Forbidden`.

Requests to endpoints that don't support `DELETE` or `PUT` return `405 Method Not Allowed`.

`POST` requests without body return `400 Bad Request`.


### Get the user's account details

```http
GET /userinfo
```

### Get all the cars records

```http
GET /api/cars
```


### Get all the records by category

```http
GET /api/cars/category/${category} 
```

| Path Variable | Description                        |
|:--------------|:-----------------------------------|
| `category`    | The category to filter records by. |


### Get a single record

```http
GET /api/cars/${id}
```

| Path Variable | Description                                                        |
|:--------------|:-------------------------------------------------------------------|
| `id`          | Returns the car whose ID corresponds to to the path variable `id`. |


### Register a car

```http
POST /api/cars
```

In the request body, include the car's data in JSON format. The `name` field is required, but the other fields are optional and will default to `null` if not specified:

```JSON
{
  "name": "${carName}",
  "category": "${carCategory}",
  "description": "${carDescription}"
}
```

After the request is processed successfully, the API will return a response with status `201 Created` and a Location header indicating the URL of the newly created car resource. You can use this URL to retrieve the car or update it later.


### Update a car

```http
POST /api/cars/${id}
```

| Path Variable | Description                        |
|:--------------|:-----------------------------------|
| `id`          | The `id` of the car to be updated. |

In the request body, specify the fields to be updated using JSON format:

```JSON
{
  "name": "${newCarName}",
  "category": "${newCarCategory}",
  "description": "${newCarDescription}"
}
```

If a field is omitted, the corresponding property will not be changed. To set a field to null, include the property name followed by `"null"` in the request body:

```JSON
{
  "description": "null"
}
```

The `id` field cannot be changed.


### Delete a car

```http
DELETE /api/cars/${id}
```

| Path Variable | Description                        |
|:--------------|:-----------------------------------|
| `id`          | The `id` of the car to be deleted. |
