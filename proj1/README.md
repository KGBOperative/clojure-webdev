# proj1

Chapter 1 of "Web Developement in Clojure" : creates a basic guestbook web app

## Prerequisites

You will need [Leiningen][1] 2.0 or above installed. Also requires the [H2 Driver][2] to be in your classpath to run the compiled, standalone server.

[1]: https://github.com/technomancy/leiningen

[2]: http://www.h2database.com/html/main.html

## Running

To start a web server for the application, run:

    $ lein run

To create and run a standalone server:

    $ lein uberjar

    $ java -jar proj1.jar migrate && java -jar proj1.jar

## License

Copyright © 2016 MIT
