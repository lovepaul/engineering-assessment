
# Project Overview

This project is designed to manage and analyze food truck data in San Francisco. It consists of four key components:

1. **Database Initialization**:  
   The project includes an SQL script (`mobile_food_facility_permit.sql`) that initializes the database by creating the necessary tables and inserting initial data. The database schema is designed to store food truck permit information, including details like facility type, location, and permit status.

2. **CSV to MySQL Data Import (Python Script)**:  
   A Python script (`csv2mysql.py`) is provided to automate the process of importing CSV data (`Mobile_Food_Facility_Permit.csv`) into the MySQL database. The script parses the CSV file and inserts the data into the appropriate tables in the MySQL database. It ensures the data is formatted and stored correctly for easy querying.

3. **Backend Service (Spring Boot Application)**:  
   The `foodcar` directory contains a Spring Boot application that serves as the backend service for this project. It is responsible for managing the food truck data, providing REST APIs for CRUD operations, and handling business logic related to food truck permits. The backend communicates with the MySQL database to fetch and store data.

4. **Frontend Application (React)**:  
   The `food-truck-app` directory contains a React application that serves as the frontend for this project. It interacts with the Spring Boot backend through the provided APIs, allowing users to view and search for food truck information in San Francisco. The frontend also provides filtering options based on various criteria such as location, permit status, and type of facility.

## Key Files and Directories

- `csv2mysql.py`: Python script for importing CSV data into the MySQL database.
- `foodcar/`: Spring Boot backend application.
- `food-truck-app/`: React frontend application.
- `Mobile_Food_Facility_Permit.csv`: CSV file containing food truck permit data.
- `mobile_food_facility_permit.sql`: SQL script for initializing the MySQL database schema.
- `README.md`: Project overview and setup instructions.

## Getting Started

1. Initialize the database by running the SQL script:
   ```bash
   mysql -u username -p database_name < mobile_food_facility_permit.sql
   ```

2. Use the Python script to import the CSV data into the database:
   ```bash
   python csv2mysql.py
   ```

3. Run the Spring Boot application:
   ```bash
   cd foodcar
   ./mvnw spring-boot:run
   ```

4. Start the React frontend application:
   ```bash
   cd food-truck-app
   npm install
   npm start
   ```

## Conclusion

This project provides a complete system for managing and querying food truck data in San Francisco, from database setup and data import to backend services and a user-friendly frontend interface.
