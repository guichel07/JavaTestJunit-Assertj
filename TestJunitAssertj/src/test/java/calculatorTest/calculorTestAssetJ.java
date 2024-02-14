package calculatorTest;

import calculator.calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


import java.time.Duration;
import java.time.Instant;



public class calculorTestAssetJ {
    private  calculator cal ;
    public Instant debutTemps;
    public Instant finTemps;


    /**
     *cette methode permet d intisaliser la methode
     */

    @BeforeEach
    public void intCalculator(){
        cal = new calculator() ;
    }

    /**
     * cette fpnction remets toutes les fonctions à null
     */

    @AfterEach
    void intCalculorToNull(){
        cal = null ;
    }

    /**
     * Cette methode marque le temps de debut d'une fonction
     */

    @BeforeEach
    void tempsDebut(){

        debutTemps = Instant.now() ;
    }

    /**
     *  cette methode marque le temps de fin d'une fonction
     */
    @AfterEach
    void tempsFin(){
        finTemps = Instant.now() ;

    }

    @AfterEach
    void tempsExecution(){

        long  dure = Duration.between(debutTemps ,finTemps).toMillis() ;
        System.out.println("Temps d'execution : > " + dure ) ;
    }






}
