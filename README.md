This project provides a RESTful API for registering players in a game, and The API also supports player progression tracking and a global leaderboard. 

Tech Stack

Backend: Java, Spring Boot

Database: MySQL

Security: Spring Security, JWT Authentication

Build Tool: Gradle

 Clone the Repository

 git clone https://github.com/yourusername/game-portal-api.git
 cd game-portal-api

2️⃣ Configure the Database

Create a MySQL database and update application.properties:

spring.datasource.url=jdbc:mysql://sql12.freesqldatabase.com:3306/sql12765461?useSSL=false&serverTimezone=UTC
spring.datasource.username=sql12765461
spring.datasource.password=QDydKlJvG8
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

3️⃣ Build and Run the Application

./gradlew bootRun

API Endpoints

1️⃣ Player Registration

📌 Endpoint: POST /games_portal/api/players/register🔒 Access: Public
{"username": "sneha", "deviceId": "12345", "platform": "Android","password":"12344"}

2️⃣ Save Progrss of the data
📌 Endpoint: POST /games_portal/api/players/playerProgress🔒 Access: Public
{
    "level": "10",
    "Rank": "45",
    "currency": "rupees",
    "country": "India",
    "rewardsCollected00": "gold",
    "playerId": "3"}
    
3️⃣ Save Score of Player on leaderBoard
📌 Endpoint: POST /games_portal/api/players/submitScore
{
    "playerId": "10",
    "gameId": "45",
    "score": "90",
    "country": "India"
}
4️⃣ Leaderboard (Global & Country-Specific)
📌 Endpoint: games_portal/api/players/top-players/global?getX=2

📌 Endpoint: games_portal/api/players/top-players/game?gameId=1&limit=2

📌 Endpoint: games_portal/api/players/top-players/game?gameId=1&country="India"&limit=2
