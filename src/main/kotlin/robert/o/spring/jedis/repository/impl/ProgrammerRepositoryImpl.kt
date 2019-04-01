package robert.o.spring.jedis.repository.impl

import org.springframework.data.redis.core.ValueOperations
import org.springframework.stereotype.Repository
import robert.o.spring.jedis.model.Programmer
import robert.o.spring.jedis.repository.ProgrammerRepository

@Repository
class ProgrammerRepositoryImpl(private val valueOps: ValueOperations<String, Programmer>): ProgrammerRepository {

    override fun getProgrammer(id: String) = valueOps.get(id)

    override fun setProgrammer(programmer: Programmer) = valueOps.set(programmer.id, programmer)
}
