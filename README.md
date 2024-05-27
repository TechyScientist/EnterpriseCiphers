# Enterprise Ciphers
A Java Enterprise Web App featuring many ciphering algorithms

### Installation and Use
This app comes in three components, bundled in one wrapper project: ciphers-ejb (Enterprise Java Beans), ciphers-web (Web app and Servlet Deployments) and ciphers-ear (containing references to ciphers-ejb and ciphers-web).

To build this project, you will need maven and wildfly installed.

1. Download the code and unzip it.
2. Ensure Wildfly is started.
3. Open a command prompt window, and go to the ciphers-app directory
4. ``mvn clean install wildfly:deploy``
5. Navigate to [https://localhost:8080/ciphers](https://localhost:8080/ciphers) to see the main list of algorithms.
6. Select a link to view an algorithm's page, and follow the instructions on that page to use it. You will also be able to read about an algorithm on its page.

### Supported Algorithms
The algorithms currently supported by the web app are:
* Enigma (Information Incomplete)
* Ohaver's Algorithm
* Shuffle Transposition Cipher
* Caesar Substitution Cipher

Support for the following algorithms is planned:
* Matrix Transposition Cipher
