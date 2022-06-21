import spock.lang.Shared
import spock.lang.Specification

class SharedFieldSpec extends Specification{


    @Shared
    Integer staticNumber



    void "should get the integer value after calculation"() {
        given:
        staticNumber = 3
        def i = 3

        when:
        def result = staticNumber + i

        then:
        assert result == 6
    }

    void "should get the another integer value after calculation"() {
        given:
        def i = 3

        when:
        def result = staticNumber + i

        then:
        assert result == 6
    }
}
