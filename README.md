
![js-standard-style](https://img.shields.io/badge/code%20style-Google_Style-brightgreen.svg?style=flat)
![js-standard-style](https://img.shields.io/badge/build-passing-green)
![js-standard-style](https://img.shields.io/badge/release-v1.0.0-blue)
![js-standard-style](https://img.shields.io/badge/license-MIT-green)

# Recruitment task

## Table of Contents
  - [Table of Contents](#table-of-contents)
  - [About The Project](#about-the-project)
  - [Technology stack](#technology-stack)
  - [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
  - [API Reference](#api-reference)
  - [License](#license)
  - [Contact](#contact)
## About The Project

Pretius recrutation task

## Getting Started

### Prerequisites

* [java 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
* [Maven 3.6.3](https://maven.apache.org/download.cgi)

### Installation

1. Clone the repo
```sh
$ git clone https://github.com/mateusz58/PretiusTask.git
$ cd PretiusTask
```
2. Set up initial build of project
```sh
$ mvn clean package
```
3. Launch application with the following command
```sh
$ mvn spring-boot:run
```

## API Reference

### Admin panel

  - `admin/*` administration panel for managing users

### invoice related

- `/invoices/`<br> display/add/delete/modify invoices stored in database
- `invoices/{id}`<br> get/delete/modify invoice based on given id
- `invoices/byNumber?=<number>`<br> display/delete/modify invoice based on its number
  
## License

[MIT](https://tldrlegal.com/license/mit-license)

## Contact

  - Email: matp321@gmail.com
  - Project Link: [Recruitment task github](https://github.com/mateusz58/PretiusTask.git)