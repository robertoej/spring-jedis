package robert.o.spring.jedis.service.impl

import org.springframework.stereotype.Service
import robert.o.spring.jedis.model.Programmer
import robert.o.spring.jedis.repository.ProgrammerRepository
import robert.o.spring.jedis.service.ProgrammerService

@Service
class ProgrammerServiceImpl(private val programmerRepository: ProgrammerRepository): ProgrammerService {

    override fun getProgrammer(id: String) = programmerRepository.getProgrammer(id)

    override fun setProgrammer(programmer: Programmer) = programmerRepository.setProgrammer(programmer)
}
