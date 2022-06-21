import spock.lang.Specification

class MockSpec extends Specification {

    void "should send messages to all subscribers in mock"() {
        given:
        Publisher publisher = new Publisher()
        Subscriber subscriber = Mock()
        Subscriber subscriber2 = Mock()

        publisher.subscriberList << subscriber // << is a Groovy shorthand for List.add()
        publisher.subscriberList << subscriber2

        when:
        publisher.fire("hello")

        then:
        1 * subscriber.receive("hello")
        1 * subscriber2.receive("hello")
    }




    void "should send messages to all subscribers in stub"() {
        given:
        Subscriber subscriber1 = Stub()
        Subscriber subscriber2 = Stub{
            receive("hello") >> "I'm subscriber 2"
        }

        Publisher publisher = new Publisher()
        publisher.subscriberList << subscriber1
        publisher.subscriberList << subscriber2

        subscriber1.receive(_ as String) >> "I'm subscriber 1"

        when:
        publisher.fire("hello")

        then:
        "I'm subscriber 1" == subscriber1.receive("hello")
        "I'm subscriber 2" == subscriber2.receive("hello")

    }


    void "should send messages to all subscribers in spy"() {
        given:
        Subscriber subscriber1 = Spy()
        Subscriber subscriber2 = Spy()

        Publisher publisher = new Publisher()
        publisher.subscriberList << subscriber1
        publisher.subscriberList << subscriber2

        when:
        publisher.fire("hello")

        then:
        1 * subscriber1.receive("hello")
        1 * subscriber2.receive("hello")

    }

    void "should send messages to all subscribers in partial mock"() {
        given:
        MessagePersister persister = Spy {
            isPersistable() >> true
        }

        when:
        persister.receive("msg")

        then:
        1 * persister.persist("msg")

    }
}
