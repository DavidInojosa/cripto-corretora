package school.cesar.criptocorretora

import school.cesar.criptocorretora.controllers.OperationsController

object CriptoMain {

    @JvmStatic
    fun main(args: Array<String>) {
        OperationsController.init()
    }
}