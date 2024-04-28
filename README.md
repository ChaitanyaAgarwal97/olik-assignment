# Olik Book Store

## Setup Instructions
- Run following commands in terminal:
```shell
git clone https://github.com/ChaitanyaAgarwal97/olik-assignment.git
cd olik-assignment
```
- Create a .env file with following variables:
```shell
MONGO_INITDB_ROOT_USERNAME=example # Replace example with your custom values if you want
MONGO_INITDB_ROOT_PASSWORD=example # Replace example with your custom values if you want
MONGO_INITDB_DATABASE=olikbookstoredb # Replace example with your custom values if you want. Also update application.properties file if this is changed.
ME_CONFIG_MONGODB_ADMINUSERNAME=example # Replace example with your custom values if you want
ME_CONFIG_MONGODB_ADMINPASSWORD=example # Replace example with your custom values if you want
ME_CONFIG_MONGODB_URL=mongodb://example:example@mongo:27017/ # Update if any value above is changed. Syntax: mongodb://{MONGO_INITDB_ROOT_USERNAME}:{MONGO_INITDB_ROOT_PASSWORD}@mongo:27017/
```
- Make sure that docker is installed on your system. 
- Make sure that docker desktop is running.
- Run following command from project directory root:
```shell
docker compose -f docker-compose.yml up --build -d
```
This will generate 2 containers. One is MongoDB container for storing data and other Mongo Express container at port 8081 to get a database dashboard.

## How to run app
Run following command in terminal from project root directory:
```shell
./gradlew bootRun
```
Application will start running on port 8080.

## Endpoints and sample requests
### Books:
1. GET `/api/books`: Returns all the books
2. GET `/api/books?availableBooks=true`: Returns all the books that are available for rent
3. GET `/api/books?currentlyRented=true`: Returns all the books that are currently rented
4. GET `/api/books/{id}`: Returns book with id=id.
```
/api/books/1 # Will return book with id=1.
```
5. POST `/api/books`: Creates book in database with provided object in request body.
```json
{
  "id": "101",
  "title": "The Alchemist",
  "author": "Paulo Coelho",
  "isbn": "978-8-17-223498-0",
  "publicationYear": 1988
}
```
6. PUT `/api/books/{id}`: Updates the fields of book with id=id.
```
/api/books/101 # Will update book with id=101.
```
```json
{
  "id": "101",
  "title": "The Alchemist",
  "author": "1",
  "isbn": "978-8-17-223498-0",
  "publicationYear": 1988
}
```
7. DELETE `/api/books/{id}`: Deletes book with id=id.
```
/api/books/101 # Will delete book with id=101.
```

### Authors:
1. GET `/api/authors`: Returns all the authors
2. GET `/api/authors/{id}`: Returns author with id=id.
```
/api/authors/1 # Will return author with id=1.
```
3. POST `/api/authors`: Creates author in database with provided object in request body.
```json
{
  "id": "1",
  "name": "Paulo Coelho"
}
```
4. PUT `/api/authors/{id}`: Updates the fields of author with id=id.
```
/api/authors/1 # Will update author with id=1.
```
```json
{
  "id": "1",
  "name": "Paulo Coelho", 
  "biography": "Paulo Coelho was born on 24 August 1947 in Rio de Janeiro, Brazil, and attended a Jesuit school. At age 17, Coelho's parents committed him to a mental institution from which he escaped three times before being released at the age of 20."
}
```
5. DELETE `/api/authors/{id}`: Deletes author with id=id.
```
/api/authors/1 # Will delete author with id=1.
```

### Rentals:
1. GET `/api/rentals`: Returns all the rentals
2. GET `/api/rentals/{id}`: Returns rental with id=id.
```
/api/rentals/1 # Will return rental with id=1.
```
3. POST `/api/rentals`: Creates rental in database with provided object in request body.
```json
{
  "id": "1",
  "bookId": "101",
  "renterName": "Paulo Coelho",
  "rentalDate": "2024-01-21T00:00:00.000+00:00"
}
```
4. PUT `/api/returnBook?bookId={id}`: Updates returnDate of rental with bookId=id so that it is marked as available for rent.
```
/api/returnBook?bookId=101 # Will update return date of rental with bookId=101
```