# Documentation

# Github Links

Backend: https://github.com/EEEEEEYu/OAProject-springboot

Frontend: https://github.com/EEEEEEYu/OAProject-react

# How to build and run

## Environment

OS: MacOS Big Sur 11.6

IDE: Intellij, WebStorm

Command Line Tools: npm, mvn, nginx

## Steps

### Backend

You should have mvn installed

1. cd to project folder
2. run command "mvn clean package"
3. run command "java -jar./target/chainanalysis-0.0.1-SNAPSHOT.jar"

### Frontend: React

You should have npm, nginx installed. You should make sure that the backend server has started.

1. cd to project folder
2. run command "npm install"
3. run command "npm run build"
4. copy folder "build" to "/usr/local/etc/nginx"
5. modify nginx.conf file, change the server config as:

```json
server {
		listen    8888,
		server_name    localhost,
		location / {
				root /usr/local/etc/nginx/build;
				index index.html index.htm;
		}

		location ~/api/v1 {
				proxy_pass http://localhost:8080;
		}
}
```

1. open terminal, run command "nginx"
2. open [localhost:8888](http://localhost:8888) in the browser, you should see the page working correctly

# Features

This full-stack application shows the BTCUSDT/ETHUSDT price(both buy and sell) from two exchanges: Binance and Bittrex. The recommender list will show the best sell/buy prices for these two cryptocurrency.

# Answers to the questions in the email

1. Are there any sub-optimal choices (or short cuts taken due to limited time) in your implementation?
    
    For the frontend app, the UI design may be improved(like using a tab list to switch between different exchanges). For the backend server, the data abstraction is not very good. There could be a better way to abstract the Callable Objects and the While(true) loop. Hardcoding different exchanges reduces maintainability.
    
    Also, the system does not have good fault-tolerance ability. We should design a set of error code and apply these error codes in places where things may go wrong(like database operations, fetching data from third party API). We may add some log components to generate logs for debuggings.
    
2. Is any part of it over-designed? (It is fine to over-design to showcase your skills as long as you are clear about it)
    
    Not many parts are over designed. Both the backend server and frontend app are very basic designs.
    
3. If you have to scale your solution to 100 users/second traffic what changes would you make, if any?
    1. Add a NoSQL database(like Redis) to improve QPS.
    2. Add a ReadWriteLock for the database to get better concurrecy performance.
    3. Switch simple GET request to WebSocket protocol, utilziing broadcast.
    4. If a single server cannot hold for such traffic after optimizations, scale out to multiple servers. Or scale up the single server with better hardware configuration.
4. What are some other enhancements you would have made, if you had more time to do this implementation?
    
    In general, this system needs more fault-tolerance capabilities. For the backend server, design some more generalized data retrieval models. This can significantly increase maintainability, but will require more time and make the design complicated. If we need to get more QPS, we can adopt the pre-mentioned techiques. For the frontend app, design a better UI, like adding exchange list. Or we can also add user management(like user login, adding customized exchanges, setting up email alerts) to implement personalized recommendations.