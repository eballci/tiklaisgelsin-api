# Tıkla İş Gelsin Application Programming Interface

## Overview
This package is created to be a resilient back-end service for our mobile and web applications.

## Requirements
In order to run this application on your machine, you must have the following tools.
* Git
* JDK 17 (or later)
* Docker Desktop
* Maven

## Installation
You can run this application on your machine. To do so, follow these instructions.
* #### Clone this repository
````shell
foo@bar:~$ git clone https://github.com/eballci/tiklaisgelsin-api.git
foo@bar:~$ cd tiklaisgelsin-api
````

* #### Build JAR file
````shell
foo@bar:~/tiklaisgelsin-api$ mvn clean install
````

* #### Run project
````shell
foo@bar:~/tiklaisgelsin-api$ docker-compose up
````

## Usage
Postman is recommended for using this application. Alternatively, you can use cURL which is out-of-the-box on major OS (i.e. macOS, Windows, Ubuntu).

The application uses the '8080' port automatically on localhost.

## Contributors
* Emre BALCI
* Beytullah SAYDAM
* Muhammed TOPSAKAL

## LICENSE
MIT License

Copyright (c) EMRE BALCI, Beytullah SAYDAM, Muhammed TOPSAKAL

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.