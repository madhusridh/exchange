## How to Run

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



