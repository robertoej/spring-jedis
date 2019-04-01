package robert.o.spring.jedis.repository

import robert.o.spring.jedis.model.Programmer

interface ProgrammerRepository {

    fun getProgrammer(id: String): Programmer?

    fun setProgrammer(programmer: Programmer)
}
