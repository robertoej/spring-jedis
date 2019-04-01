package robert.o.spring.jedis.service

import robert.o.spring.jedis.model.Programmer

interface ProgrammerListService {

    fun addProgrammer(programmer: Programmer)

    fun listProgrammers(): List<Programmer>

    fun size(): Long
}
