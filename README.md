# Java Multi-threaded Web Crawler

A concurrent web crawler built in Java.

This project crawls websites starting from a given URL, fetching all links on the page, and recursively following those links up to a user-defined depth. It uses Java's concurrency utilities to process multiple pages simultaneously.

## Features

- **Multi-threaded execution**: Uses `ExecutorService` to fetch multiple pages concurrently.
- **Thread-safe structures**: Uses `ConcurrentHashMap` for tracking visited URLs and a `LinkedBlockingQueue` for pending URLs to avoid race conditions.
- **Phase synchronization**: Uses Java's `Phaser` to coordinate worker threads and ensure all tasks complete before the program terminates.
- **HTML parsing**: Uses [Jsoup](https://jsoup.org/) to fetch and parse web pages.

## How to test the crawler

### Requirements
- Java 23 or higher
- Maven

### Running the project

1. Clone the repository to your local machine.
2. Build the project and download dependencies using Maven:
   ```bash
   mvn clean install
   ```
3. Run the main class `com.example.WebCrawler`. You can run this from your IDE, or via the terminal using Maven:
   ```bash
   mvn exec:java -Dexec.mainClass="com.example.WebCrawler"
   ```
4. The program will prompt you for three inputs:
   - **Start URL:** The full URL to start crawling (e.g., `https://example.com`).
   - **Max Depth:** The maximum depth for the recursive crawl. A depth of 2 or 3 is recommended for testing.
   - **Max Threads:** The number of concurrent worker threads to spawn.

The program will output the links it finds and display the total execution time once the crawl finishes.

## Future scope

Here are a few things planned for future updates:

- **Robots.txt parsing**: Add support for parsing and respecting `robots.txt` rules before crawling a site.
- **Database storage**: Move visited URLs and scraped data from in-memory storage to a persistent database like PostgreSQL.
- **Data extraction**: Add functionality to scrape specific content (like article text or images) instead of just extracting links.
- **Rate limiting**: Implement rate limiting to avoid sending too many requests to a single server in a short period.
- **Web UI**: Build a dashboard to track the crawler's progress instead of relying on terminal output.
