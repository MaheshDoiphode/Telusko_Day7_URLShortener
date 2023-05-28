# Telusko_Day7_URLShortener
# URL Shortener Project

This project aims to provide a user-friendly interface for shortening URLs. It consists of an Angular application, a Spring API, and a PostgreSQL database.

## Angular Application

The Angular application plays a vital role in the URL shortening process. It comprises the following components:

- **Home Component:** This component allows users to enter a URL and click a button to shorten it. It communicates with the Spring API to handle URL shortening. Users can also register and log in using the provided forms.

- **MockService:** This service manages user authentication. It validates user credentials and maintains a user database. By default, there is a predefined user with the email 'admin@mail.com' and password 'password'.

## Spring API

The Spring API acts as the backend for the URL shortener project. It provides RESTful endpoints for managing URL mappings. It consists of the following components:

- **URLMapping Entity:** This entity represents a URL mapping, storing the original URL and its corresponding shortened URL.

- **URLService:** This service handles the management of URL mappings. It offers methods to retrieve all URL mappings and add new ones.

- **URLGenerate Component:** This component generates unique shortened URLs using an algorithm based on permutations of predefined characters. It ensures that each original URL has a distinct shortened URL.

## PostgreSQL Database

The project employs an online PostgreSQL database to store URL mappings persistently. The Spring API interacts with this database to store and retrieve URL mappings.

Project Flow:

1. Start the Spring application on `localhost:8080`. It connects to the PostgreSQL database to manage URL mappings.

2. Launch the Angular application on `localhost:4200`. It provides a user interface for URL shortening and user authentication.

3. In the Angular application, navigate to the registration page to register a new user. Provide an email and password, which will be stored in the PostgreSQL database via the Spring API.

4. After registration, users can access the login page and enter their credentials. The login page uses the MockService to validate the user's credentials. If valid, the user is redirected to the home page.

5. On the home page, users can enter a URL in the input field and click the "Shorten URL" button. The Angular application sends an HTTP POST request to the Spring API with the original URL.

6. The Spring API generates a unique shortened URL using the URLGenerate component. It stores the mapping in the PostgreSQL database and returns the shortened URL as the response.

7. The Angular application receives the shortened URL response and displays it on the home page.

This concludes the flow of the URL shortener project. The Angular application interacts with the Spring API for URL shortening and user authentication, while the Spring API utilizes the PostgreSQL database for storing and retrieving URL mappings.
