A [Giter8][g8] template for showcasing Publish-Subscribe messaging pattern in Lagom.

# lagom-streaming
A basic application to implement the Publish-Subscribe messaging pattern in lagom. There are 2 endpoints in this application. One for publishing the temperature to a particular topic and second for subscribing to that topic to get the temperature.

### Publish:
End point: **/api/temperature/publish/2**

It will publish the temperature to the topic 2.

### Subscribe:
End point: **/api/temperature/subscribe/2**

It will subscribe to the topic 2 to get the temperature.

# Clone the application
sbt new knoldus/lagom-pub-sub.g8

cd lagom-pub-sub/

sbt clean compile

# Run application
Hit the below command

sbt runAll

## Test the application
1. You need to subscribe to the topic 2 from the web socket client using **/api/subscribe/publish/2**
2. Then you need to publish the temperature to the topic 2 using **/api/temperature/publish/2** using curl or postman.
3. Then verify the response on WebSocket client.
4. As soon as the temperature will be published, it will be consumed by the subscriber.

----------------
Written in 2018 by Rishi Khandelwal

To the extent possible under law, the author(s) have dedicated all copyright and related
and neighboring rights to this template to the public domain worldwide.
This template is distributed without any warranty. See <http://creativecommons.org/publicdomain/zero/1.0/>.

[g8]: http://www.foundweekends.org/giter8/
