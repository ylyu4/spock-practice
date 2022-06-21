import spock.lang.Ignore
import spock.lang.IgnoreRest
import spock.lang.Specification

class TestExampleSpec extends Specification{

    void "events are published to all subscribers"() {
        given:
        def subscriber1 = Mock(Subscriber)
        def subscriber2 = Mock(Subscriber)
        def publisher = new Publisher()
        publisher.add(subscriber1)
        publisher.add(subscriber2)

        when:
        publisher.fire("event")

        then:
        1 * subscriber1.receive("event")
        1 * subscriber2.receive("event")
    }




    void "get the max number"() {
        when:
        def x = Math.max(1, 2)

        then:
        x == 2
    }



    void "another way of get the max number"() {
        expect:
        Math.max(1, 2) == 2
    }


    void "offered PC matches preferred configuration -- test 1"() {
        when:
        def pc = new PC()

        then:
        pc.vendor == "Sunny"
        pc.clockRate >= 2333
        pc.ram >= 4096
        pc.os == "Linux"
    }

    void "offered PC matches preferred configuration -- test 2"() {
        when:
        def pc = new PC()

        then:
        matchesPreferredConfiguration(pc)
    }

    void matchesPreferredConfiguration(pc) {
        pc.vendor == "Sunny"
        pc.clockRate >= 2333
        pc.ram >= 4096
        pc.os == "Linux"
    }


    void "offered PC matches preferred configuration -- test 3"() {
        when:
        def pc = new PC()

        then:
        matchesPreferredConfigurationWithDetails(pc)
    }

    void matchesPreferredConfigurationWithDetails(pc) {
        assert pc.vendor == "Sunny"
        assert pc.clockRate >= 2333
        assert pc.ram >= 4096
        assert pc.os == "Linux"
    }


    void "offered PC matches preferred configuration"() {
        when:
        def pc = new PC()

        then:
        with(pc) {
            vendor == "Sunny"
            clockRate >= 2333
            ram >= 4096
            os == "Linux"
        }
    }
}
