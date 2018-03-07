A [Giter8][g8] template for showcasing Publish-Subcribe messaging pattern in lagom.

# lagom-streaming
A basic application to implement Publish-Subscribe messaging pattern in lagom. There are 2 endpoints in this application. One for publishing the temprature to a particular topic and second for subscribing to that topic to get the temprature.

### Publish:
End point: /api/temperature/publish/2

It will publish the temprature to the topic 2.

### Subscribe:
End point: /api/temperature/subscribe/2

It will subscribe to the topic 2 to get the temprature.

# Clone the application
sbt new knoldus/lagom-pub-sub.g8
cd lagom-pub-sub/
sbt clean compile

# Run application
Hit the below command

sbt runAll

## Test the application
1. You need to subscribe to the topic 2 from the websocket client using /api/subscribe/publish/2
2. Then you need to publish the temprature to the topic 2 using /api/temperature/publish/2 using curl or postman.
3. Then verify the response on websocket client.
4. As soon as the temprature will be published, it will be consumed by subscriber.

----------------
Written in 2017​ by Rishi Khandelwal

To the extent possible under law, the author(s) have dedicated all copyright and related
and neighboring rights to this template to the public domain worldwide.
This template is distributed without any warranty. See <http://creativecommons.org/publicdomain/zero/1.0/>.

[g8]: http://www.foundweekends.org/giter8/
