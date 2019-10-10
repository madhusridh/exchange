## How to Run

To run the application
- Clone the repository into your local machine
- run 
  docker-compose up

## Notification APP

- NotificationApp is the exhange to which producers publish the notification detail
- The application puts the message into appropriate queue
  - for simplicity, if the "to" in the JSON request body contains "@", it is pushed into the email queue. 
  - for other requests, the message is pushed into the Slack queue. 
  - Sample JSON request looks like 
  ```
      {
        "from" : "producer@test.com",
        "to" : "subscriber@test.com",
        "messageBody" : "Sample Email Message",
        "messageSubject" : "Sample Email Subject"
      }
- RabbitMQ should be up and running for the notification to work

## Notification Client
- The notification client application has RabbitMQ listeners configured
- When a message is pushed into the queue, the appropriate listener picks up the message for processing
- The client is stubbed to log the message into H2 Database 

To Test the application, use below sample URLs

Use below HTTP request to test email client
```
POST http://localhost:8081/message/
{
      "from" : "producer@test.com",
      "to" : "subscriber@test.com",
      "messageBody" : "Sample Email Message",
      "messageSubject" : "Sample Email Subject"
}
```
Use below to test Slack stub
```
POST http://localhost:8081/message/ 
{
      "from" : "producer@test.com",
      "to" : "slack-reciever",
      "messageBody" : "Sample slack Message",
      "messageSubject" : "Sample slack Subject"
}
```
To view the messages from client 
```
GET http://localhost:8085/message/ 
```




