package school.cesar.criptocorretora.services

import school.cesar.criptocorretora.validadores.CriptoValidador
import school.cesar.criptocorretora.builders.CriptoBuilder
import school.cesar.criptocorretora.repositories.CriptoRepository
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.assertThrows


class CriptoServiceTest {
    val criptoValidador = CriptoValidador()
    val criptoBuilder = CriptoBuilder()
    val criptoRepository = CriptoRepository()
    val criptoService = CriptoService(criptoBuilder, criptoValidador, criptoRepository)

    @Test
    fun `deve buscar cripto ja existente, validar e adicionar`(){
        criptoService.add("GuiAliDaveCripto", BigDecimal(4))

        Assertions.assertEquals(criptoService.buscarPorId(0).id, 0)
    }

    @Test
    fun `deve lançar excecao caso id da cripto nao exista`(){
        criptoService.add("GuiAliDaveCripto", BigDecimal(4))

        assertThrows<RuntimeException> {
            criptoService.buscarPorId(4)
        }.also {
            Assertions.assertEquals("Id não existente", it.message)
        }

    }
}