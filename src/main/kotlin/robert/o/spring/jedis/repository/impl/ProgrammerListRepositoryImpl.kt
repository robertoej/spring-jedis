package robert.o.spring.jedis.repository.impl

import org.springframework.data.redis.core.ListOperations
import org.springframework.stereotype.Repository
import robert.o.spring.jedis.model.Programmer
import robert.o.spring.jedis.repository.ProgrammerListRepository

@Repository
class ProgrammerListRepositoryImpl(private val listOps: ListOperations<String, Programmer>): ProgrammerListRepository {

    private val key = "PROGRAMMER_LIST"

    override fun addProgrammer(programmer: Programmer) { listOps.leftPush(key, programmer) }

    override fun listProgrammers(): MutableList<Programmer> = listOps.range(key, 0, -1)!!

    override fun size() = listOps.size(key)!!
}
