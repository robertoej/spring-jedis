package robert.o.spring.jedis.service.impl

import robert.o.spring.jedis.model.Programmer
import robert.o.spring.jedis.repository.ProgrammerListRepository
import robert.o.spring.jedis.service.ProgrammerListService

class ProgrammerListServiceImpl(private val programmerListRepository: ProgrammerListRepository): ProgrammerListService {

    override fun addProgrammer(programmer: Programmer) = programmerListRepository.addProgrammer(programmer)

    override fun listProgrammers() = programmerListRepository.listProgrammers()

    override fun size() = programmerListRepository.size()
}
