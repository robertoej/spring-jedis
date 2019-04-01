package robert.o.spring.jedis.repository

import robert.o.spring.jedis.model.Programmer

interface ProgrammerListRepository {

    fun addProgrammer(programmer: Programmer)

    fun listProgrammers(): List<Programmer>

    fun size(): Long
}
