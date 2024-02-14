package calculatorTest;

import calculator.calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

    class calculatorTestjunit {


    private static Instant startedAt;
    private calculator  cal ;

         /**
          *
          */
    @BeforeEach
    void beforeCalculator(){
       // System.out.println("Avant le test initialisation de la l'objet ") ;
        cal = new calculator() ;
    }

    /**
     *
     */
    @AfterEach
    void afterCalculator(){
       // System.out.println("Appel après chaque test");
        cal = null;
    }

    /**
     *
     */
    @BeforeAll
    static void initStartingTime(){
        //System.out.println("Appel avant tous les tests");
        startedAt = Instant.now() ;
    }

    /**
     *
     */
    @AfterAll
    static void showTestDuration(){
        //System.out.println("Appel après tous les tests") ;
        Instant endeAt = Instant.now() ;
        long  duration = Duration.between(startedAt , endeAt ).toMillis() ;
        System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
    }

    /**
     *
     */
    @ParameterizedTest(name = "{0} x 0 doit etre égal à 0")
    @ValueSource(ints = {1,2,8,0})
    void SommeTest(double  arg){

        assertEquals(arg ,cal.somme(arg , 0));
    }

    /**
     *
     *
     */
    @ParameterizedTest(name = "{0} + {1} should equal to {2}")
    @CsvSource({ "1,1,2", "2,3,5", "42,57,99" })
    void add_shouldReturnTheSum_ofMultipleIntegers(double  arg1, double  arg2, double  expectResult) {
        // Arrange -- Tout est prêt !

        // Act
        double  actualResult = cal.somme(arg1, arg2) ;

        // Assert
        assertEquals(expectResult, actualResult);
    }

    /**
     *
     */
    @Test

    void MultipleTest(){
        assertEquals(8.0,cal.multiple(2,4) ) ;
    }

    @Timeout(3)
    @Test
    void multipicationTestDure() {
        // Arrange

        // Act
        cal.multiple(2.0,9.0) ;

        // Assert
        // ...
        assertThat(2).isEqualTo(2);
    }


}
