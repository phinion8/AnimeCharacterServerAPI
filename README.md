# Anime Character Server API Using Ktor Framework With Pagination Support

# Description
The Kotlin Ktor Server with Pagination is a web server application developed using Kotlin and Ktor framework. It provides an API endpoint that supports pagination, allowing clients to retrieve data in smaller chunks for improved performance and efficiency. This server is designed to handle large datasets and provide pagination functionality to enhance the user experience.

# Features
1. Pagination: Retrieve data in smaller, paginated chunks to optimize performance.
2. Customizable Page Size: Configure the number of items per page according to your requirements.
3. Flexible Sorting: Sort data based on specific criteria to facilitate easy data manipulation.
4. Robust Error Handling: Provide meaningful error responses for various scenarios, such as invalid pagination parameters.

# Usage
The Kotlin Ktor Server with Pagination provides an API endpoint that supports pagination. Here's a brief overview of how to use the server:

Retrieve Paginated Data:

Send a GET request to the /api/data endpoint.
Specify the pagination parameters in the query string:
page: The page number to retrieve (e.g., /api/data?page=1).
size: The number of items per page (e.g., /api/data?size=10).
Sort Data:

Include an optional sort parameter in the query string to specify sorting criteria (e.g., /api/data?sort=name:asc).
Use the following format for sorting: <field>:<direction>, where <field> is the field to sort by, and <direction> can be asc for ascending or desc for descending.
Error Handling:

If invalid pagination parameters are provided (e.g., negative page)


