package school.cesar.criptocorretora.validadores

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Test
import school.cesar.criptocorretora.entidades.Carteira
import school.cesar.criptocorretora.entidades.Usuario
import school.cesar.criptocorretora.util.CPFUtil
import school.cesar.criptocorretora.util.EmailUtil
import school.cesar.criptocorretora.util.SenhaUtil

class UsuarioValidatorTest {

    //valida campos obrigatórios
    @Test
    fun `deve lancar excecao quando Nome estiver em branco`() {
        val cpfUtil = CPFUtil()
        val emailUtil = EmailUtil()
        val senhaUtil = SenhaUtil()

        val userExpected = Usuario(12345, "44018355068", "", "GuiAliDave@gmail.com", "GuiAliDave123", Carteira())
        val userValidator = UsuarioValidator(cpfUtil, emailUtil, senhaUtil)

        assertThrows<RuntimeException> {
            userValidator.valida(userExpected)
        }.also {
            Assertions.assertEquals("O nome deve ser preenchido", it.message)
        }
    }

    @Test
    fun `deve lancar excecao quando CPF estiver em branco`() {
        val cpfUtil = CPFUtil()
        val emailUtil = EmailUtil()
        val senhaUtil = SenhaUtil()

        val userExpected = Usuario(12345, "", "GuiAliDave", "GuiAliDave@gmail.com", "GuiAliDave123", Carteira())
        val userValidator = UsuarioValidator(cpfUtil, emailUtil, senhaUtil)

        assertThrows<RuntimeException> {
            userValidator.valida(userExpected)
        }.also {
            Assertions.assertEquals("O cpf deve ser preenchido", it.message)
        }
    }

    @Test
    fun `deve lancar excecao quando Email estiver em branco`() {
        val cpfUtil = CPFUtil()
        val emailUtil = EmailUtil()
        val senhaUtil = SenhaUtil()

        val userExpected = Usuario(12345, "44018355068", "GuiAliDave", "", "GuiAliDave123", Carteira())
        val userValidator = UsuarioValidator(cpfUtil, emailUtil, senhaUtil)

        assertThrows<RuntimeException> {
            userValidator.valida(userExpected)
        }.also {
            Assertions.assertEquals("O e-mail deve ser preenchido", it.message)
        }
    }

    @Test
    fun `deve lancar excecao quando Senha estiver em branco`() {
        val cpfUtil = CPFUtil()
        val emailUtil = EmailUtil()
        val senhaUtil = SenhaUtil()

        val userExpected = Usuario(12345, "44018355068", "GuiAliDave", "GuiAliDave@gmail.com", "", Carteira())
        val userValidator = UsuarioValidator(cpfUtil, emailUtil, senhaUtil)

        assertThrows<RuntimeException> {
            userValidator.valida(userExpected)
        }.also {
            Assertions.assertEquals("A senha deve ser preenchido", it.message)
        }
    }

    //valida tamanho campos

    @Test
    fun `deve lancar excecao quando Nome tiver mais de 200 caracteres`(){
        val cpfUtil = CPFUtil()
        val emailUtil = EmailUtil()
        val senhaUtil = SenhaUtil()

        val userExpected = Usuario(12345,"44018355068","GuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDaveGuiAliDave","GuiAliDave@gmail.com","GuiAliDave123", Carteira())
        val userValidator = UsuarioValidator(cpfUtil, emailUtil, senhaUtil)

        assertThrows<RuntimeException> {
            userValidator.valida(userExpected)
        }.also {
            Assertions.assertEquals("O campo nome deve ter menos de 200 caracteres", it.message)
        }
    }

    @Test
    fun `deve lancar excecao quando CPF nao tiver 11 caracteres`(){
        val cpfUtil = CPFUtil()
        val emailUtil = EmailUtil()
        val senhaUtil = SenhaUtil()

        val userExpected = Usuario(12345,"12345","GuiAliDave","GuiAliDave@gmail.com","GuiAliDave123", Carteira())
        val userValidator = UsuarioValidator(cpfUtil, emailUtil, senhaUtil)

        assertThrows<RuntimeException> {
            userValidator.valida(userExpected)
        }.also {
            Assertions.assertEquals("O campo cpf deve ter 11 caracteres numericos", it.message)
        }
    }

    @Test
    fun `deve lancar excecao quando Senha nao tiver entre 8 e 15 caracteres`(){
        val cpfUtil = CPFUtil()
        val emailUtil = EmailUtil()
        val senhaUtil = SenhaUtil()

        val userExpected = Usuario(12345,"44018355068","GuiAliDave","GuiAliDave@gmail.com","asdf", Carteira())
        val userValidator = UsuarioValidator(cpfUtil, emailUtil, senhaUtil)

        assertThrows<RuntimeException> {
            userValidator.valida(userExpected)
        }.also {
            Assertions.assertEquals("O campo confirmação senha deve ter entre 8 e 15 caracteres", it.message)
        }
    }

    // valida formatos campos

    @Test
    fun `deve lancar excecao quando CPF for invalido`(){
        val cpfUtil = CPFUtil()
        val emailUtil = EmailUtil()
        val senhaUtil = SenhaUtil()

        val userExpected = Usuario(12345,"12345678910","GuiAliDave","GuiAliDave@gmail.com","asdfghjk", Carteira())
        val userValidator = UsuarioValidator(cpfUtil, emailUtil, senhaUtil)

        assertThrows<RuntimeException> {
            userValidator.valida(userExpected)
        }.also {
            Assertions.assertEquals("O cpf é invalido", it.message)
        }
    }

    @Test
    fun `deve lancar excecao quando Email for invalido`(){
        val cpfUtil = CPFUtil()
        val emailUtil = EmailUtil()
        val senhaUtil = SenhaUtil()

        val userExpected = Usuario(12345,"44018355068","GuiAliDave","GuiAliDave@gmail","asdfghjk", Carteira())
        val userValidator = UsuarioValidator(cpfUtil, emailUtil, senhaUtil)

        assertThrows<RuntimeException> {
            userValidator.valida(userExpected)
        }.also {
            Assertions.assertEquals("O e-mail deve seguir o formato palavra@palavra.palavra", it.message)
        }
    }

    @Test
    fun `deve lancar excecao quando Senha for invalida`(){
        val cpfUtil = CPFUtil()
        val emailUtil = EmailUtil()
        val senhaUtil = SenhaUtil()

        val userExpected = Usuario(12345,"44018355068","GuiAliDave","GuiAliDave@gmail.com","..........", Carteira())
        val userValidator = UsuarioValidator(cpfUtil, emailUtil, senhaUtil)

        assertThrows<RuntimeException> {
            userValidator.valida(userExpected)
        }.also {
            Assertions.assertEquals("A senha deve conter numeros, letras maisculas e minusculas", it.message)
        }
    }
}