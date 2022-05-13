import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import school.cesar.criptocorretora.services.DollarService

class DollarServiceTest {

    @Test
    fun `deve pegar valor do dolar atual que é entre 4 e 5`(){
        val dollarExpected = DollarService()
        val dollar = dollarExpected.pegarValorDollarAtual().toDouble()

        Assertions.assertTrue(dollar < 5.1 && dollar > 3.9 )
    }
}