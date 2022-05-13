package school.cesar.criptocorretora.validadores

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Test
import school.cesar.criptocorretora.entidades.Cripto
import java.math.BigDecimal

class CriptoValidatorTest {

    @Test
    fun `deve lancar excecao quando nome de cripto estiver em branco `(){

        val expectedResult = Cripto(12345678910, "", BigDecimal(4))
        val validator = CriptoValidador()

        assertThrows<RuntimeException> {
            validator.valida(expectedResult)
        }.also {
            Assertions.assertEquals("O campo nome deve ser preenchido", it.message)
        }
    }

}