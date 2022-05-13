package school.cesar.criptocorretora.services

import org.junit.jupiter.api.Test
import io.mockk.mockk
import school.cesar.criptocorretora.entidades.Cripto
import java.math.BigDecimal
import school.cesar.criptocorretora.entidades.Usuario
import school.cesar.criptocorretora.entidades.Carteira
import io.mockk.every
import org.junit.jupiter.api.Assertions

class CarteiraServiceTest {

    @Test
    fun `deve testar compra de cripto`(){

        val criptoExpected = mockk<CriptoService>()
        val cripto = Cripto(1,"GuiAliDaveCripto", BigDecimal(4))

        val userExpected = mockk<UsuarioService>()
        val usuario = Usuario(1,"44018355068","GuiAliDave","GuiAliDave@gmail.com","GuiAliDave123", Carteira() )

        every { userExpected.buscarPorId(1) } returns usuario
        every { criptoExpected.buscarPorId(1) } returns cripto

        val carteiraExpected = CarteiraService(userExpected, criptoExpected)

        carteiraExpected.comprar(1,1,BigDecimal(4))
        usuario.carteira.cripto[cripto]?.let { Assertions.assertEquals(1, it.toInt()) }
    }

    @Test
    fun `deve testar consulta de valores agrupados`(){

        val criptoExpected = mockk<CriptoService>()
        val cripto = Cripto(1,"GuiAliDaveCripto", BigDecimal(4))

        val userExpected = mockk<UsuarioService>()
        val usuario = Usuario(1,"44018355068","GuiAliDave","GuiAliDave@gmail.com","GuiAliDave123", Carteira() )

        every { userExpected.buscarPorId(1) } returns usuario
        every { criptoExpected.buscarPorId(1) } returns cripto

        val carteiraExpected = CarteiraService(userExpected, criptoExpected)

        carteiraExpected.comprar(1,1,BigDecimal(4))
        Assertions.assertEquals(carteiraExpected.consultarValoresAgrupados(1), usuario.carteira.cripto)
    }
}