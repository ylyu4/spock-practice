import spock.lang.Specification

class DataDrivenSpec extends Specification{


    void "maximum of two numbers"() {
        expect:
        // exercise math method for a few different inputs
        Math.max(1, 3) == 3
        Math.max(7, 4) == 7
        Math.max(0, 0) == 0
    }

    void "maximum of two numbers test 1"() {
        expect:
        Math.max(a, b) == c

        where:
        a | b | c
        1 | 3 | 3
        7 | 4 | 7
        0 | 0 | 0
    }

    void "maximum of two numbers test 2"() {
        expect:
        Math.max(a, b) == c

        where:
        a | b || c
        1 | 3 || 3
        7 | 4 || 7
        0 | 0 || 0

    }

    void "maximum of two numbers another test 2"() {
        expect:
        Math.max(a, b) == c

        where:
        a ; b ;; c
        1 ; 3 ;; 3
        7 ; 4 ;; 7
        0 ; 0 ;; 0
    }


    void "maximum of two numbers another test 3"() {
        expect:
        Math.max(a, b) == c

        where:
        a << [1, 7, 0]
        b << [3, 4, 0]
        c << [3, 7, 0]
    }
}
