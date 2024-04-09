We have three microservices here. The user service saves user information to the user table when a user is created and also creates an event, sending it to Kafka under the topic 'user_created'. 
Subsequently, we have two services that consume this event: the Transaction service retrieves the IDs and balance amounts of users for transaction processes and writes them to the 'user-wallet' table. If a transaction occurs, it emits an event named 'transaction_created', which is listened to by the user service to update the user's balance field. 
Our Notification service listens to the 'user_created' topic and sends a notification to the registered email using the Java Mail Sender.

![kafka görüntüsü 2024-04-09 042038](https://github.com/teomangungoren/sample-kafka/assets/105017822/d865e0be-3a14-41b4-a6e1-20ea3bd41412)
