import com.mycompany.p2lab2metodologiauribejair.StringCalculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class StringCalculatorTest {
    private StringCalculator calc;
    @BeforeAll
    public static void SET_UP_CLASS() {
    }
    @AfterAll
    public static void TEAR_DOWN_CLASS() {
    }
    @BeforeEach
    public void SET_UP() {
        calc = new StringCalculator();
    }
    @AfterEach
    public void TEAR_DOWN() {
    }
    @Test
    public void CADENA_VACIA_RETORNA_CERO() {
        assertEquals(0, calc.add(""));
    }
    @Test
    public void UN_NUMERO_RETORNA_SU_VALOR() {
        assertEquals(1, calc.add("1"));
        assertEquals(5, calc.add("5"));
    }
    @Test
    public void DOS_NUMEROS_SE_SUMAN() {
        assertEquals(3, calc.add("1,2"));
        assertEquals(7, calc.add("3,4"));
    }
    @Test
    public void N_NUMEROS_SE_SUMAN() {
        assertEquals(6, calc.add("1,2,3"));
        assertEquals(10, calc.add("1,2,3,4"));
    }
    @Test
    public void SOPORTA_SALTOS_DE_LINEA() {
        assertEquals(6, calc.add("1\n2,3"));
        assertEquals(10, calc.add("1\n2\n3,4"));
    }
    @Test
    public void SOPORTA_DELIMITADOR_PERSONALIZADO() {
        assertEquals(3, calc.add("//;\n1;2"));
        assertEquals(10, calc.add("//|\n2|3|5"));
    }
    @Test
    public void LANZA_EXCEPCION_CON_NEGATIVOS() {
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> calc.add("1,-2,3,-4")
        );
        assertTrue(ex.getMessage().contains("-2"));
        assertTrue(ex.getMessage().contains("-4"));
    }
}
