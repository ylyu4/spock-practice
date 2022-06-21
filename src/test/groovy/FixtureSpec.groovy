import spock.lang.FailsWith
import spock.lang.Specification

class FixtureSpec extends Specification {

    Stack stack

    def setup() {
        stack = new Stack()
        assert stack.empty
    }


    void "should thrown empty stack exception" () {
        when:
        stack.pop()

        then:
        thrown(EmptyStackException)
        stack.empty
    }

//    @FailsWith(value = EmptyStackException)
    void "should thrown empty stack exception in another other" () {
        when:
        stack.pop()

        then:
        def e = thrown(EmptyStackException)
        e.cause == null
    }
}
