package school.cesar.criptocorretora.services

import school.cesar.criptocorretora.repositories.UsuarioRepository
import school.cesar.criptocorretora.validadores.UsuarioValidator

import school.cesar.criptocorretora.util.EmailUtil
import school.cesar.criptocorretora.util.SenhaUtil
import school.cesar.criptocorretora.util.CPFUtil

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.assertThrows
import school.cesar.criptocorretora.entidades.Carteira
import school.cesar.criptocorretora.entidades.Usuario

class UsuarioServiceTest {

    val usuarioRepository = UsuarioRepository()

    val emailUtil = EmailUtil()
    val senhaUtil = SenhaUtil()
    val cpfUtil = CPFUtil()

    val usuarioValidator = UsuarioValidator(cpfUtil, emailUtil, senhaUtil)
    val userExpected = UsuarioService(usuarioValidator, usuarioRepository)

    @Test
    fun `deve adicionar usuario valido `(){
        val cpf = cpfUtil.limpaCPF("440.183.550-68")
        val user = Usuario(1,cpf,"GuiAliDave","GuiAliDave@gmail.com","GuiAliDave123", Carteira())

        userExpected.adicionar(user)
        Assertions.assertEquals(userExpected.buscarPorId(1).id, 1)
    }

    @Test
    fun `Buscar por usuario nao existente`(){
        val cpf = cpfUtil.limpaCPF("440.183.550-68")
        val user = Usuario(1,cpf,"GuiAliDave","GuiAliDave@gmail.com","GuiAliDave123", Carteira())

        userExpected.adicionar(user)

        assertThrows<RuntimeException> {
            userExpected.buscarPorId(2)
        }.also {
            Assertions.assertEquals("Id Não encontrado", it.message)
        }

    }
}