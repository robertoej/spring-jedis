package robert.o.spring.jedis.service

import robert.o.spring.jedis.model.Programmer

interface ProgrammerService {

    fun getProgrammer(id: String): Programmer?

    fun setProgrammer(programmer: Programmer)
}
