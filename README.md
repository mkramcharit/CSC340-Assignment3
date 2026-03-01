CSC340 Assignment 3 Character API

This is a Spring Boot Rest API that implements CRUD operations for Characters in a Postgres database hosted on Neon. Characters can be created, read, updated, deleted, and filtered by universe or species.

Base URL
http://localhost:8081/api/characters


Software Installation and How to Run the Project

Prerequisites
Java 17 or newer
Git
Internet connection for Neon SQL

To Run the Project

Clone the repository
git clone <YOUR_REPOSITORY_URL>
cd CSC340-Assignment3

Setup the database
Open file src/main/resources/application.properties
Ensure Neon SQL credentials are correct

Run the Project
./mvnw spring-boot:run

Test that the Server is Running
Open a browser or API client tool and navigate to
http://localhost:8081/api/characters


API Endpoints

Get all characters
GET /api/characters

Example API Request
http://localhost:8081/api/characters

Response
Returns a JSON array of all Characters from the DB


Get Character by ID
GET /api/characters/{id}

Example API Request
http://localhost:8081/api/characters/2

Response
Returns a JSON object of that Character from the DB
Returns a 404 response if Character does not exist


Create Character
POST /api/characters

Example API Request
http://localhost:8081/api/characters

Request Body
{
  "name": "Iron Man",
  "description": "Genius billionaire inventor",
  "universe": "Marvel",
  "species": "Human"
}

Response
Returns the Character that was created with an auto generated characterId


Update a Character
PUT /api/characters/{id}

Example API Request
http://localhost:8081/api/characters/4

Request Body
{
  "name": "Iron Man",
  "description": "Armored Avenger and tech genius",
  "universe": "Marvel",
  "species": "Human"
}

Response
Returns the updated Character
Returns a 404 response if the characterId does not exist


Delete Character
DELETE /api/characters/{id}

Example API Request
http://localhost:8081/api/characters/2

Response
Returns 204 No Content after successful deletion


Filter characters by Universe
GET /api/characters/universe/{universe}

Example API Request
http://localhost:8081/api/characters/universe/Marvel

Response
Returns a JSON array of all Characters from that Universe


Filter characters by Species
GET /api/characters/species/{species}

Example API Request
http://localhost:8081/api/characters/species/Human

Response
Returns a JSON array of all Characters of that species


Demo Video

The demo video demonstrates all of the endpoints for the API and shows both successful and erroneous results for the requests.

Demo video URL
https://uncg-my.sharepoint.com/:v:/g/personal/mkramcharit_uncg_edu/IQDtlo6aA0NpSodjZennmJ6BARAp_mLnJOezZ2IzI6C4xa8