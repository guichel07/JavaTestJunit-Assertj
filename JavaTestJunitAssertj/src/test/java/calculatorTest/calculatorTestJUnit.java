package calculatorTest;

import calculator.calculator;

public class calculatorTestJUnit {

    private static Instant startedAt;
    private calculator  cal ;

    @BeforeEach
    /**
     *
     */
    public void beforeCalculator(){
       // System.out.println("Avant le test initialisation de la l'objet ") ;
        cal = new calculator() ;
    }

    /**
     *
     */
    @AfterEach
    public void afterCalculator(){
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
    @ParameterizedTest (name = "{0} x 0 doit etre égal à 0")
    @ValueSource (ints = {1,2,8,0})
    public void SommeTest(double  arg){

        assertEquals(arg ,cal.somme(arg , 0));
    }

    /**
     *
     * @param arg1
     * @param arg2
     * @param expectResult
     */
    @ParameterizedTest(name = "{0} + {1} should equal to {2}")
    @CsvSource({ "1,1,2", "2,3,5", "42,57,99" })
    public void add_shouldReturnTheSum_ofMultipleIntegers(double  arg1, double  arg2, double  expectResult) {
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

    public void MultipleTest(){
        assertEquals(8.0,cal.multiple(2,4) ) ;
    }

    @Timeout(3)
    @Test
    public void multipicationTestDurée() {
        // Arrange

        // Act
        cal.multiple(2.0,9.0) ;

        // Assert
        // ...
        assertThat(2).isEqualTo(2);
    }


}
