package robert.o.spring.jedis.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import robert.o.spring.jedis.model.Programmer
import robert.o.spring.jedis.service.ProgrammerListService

@RestController
@RequestMapping("programmers")
class ProgrammersController(private val programmerListService: ProgrammerListService) {

    @GetMapping
    fun list() = programmerListService.listProgrammers()

    @GetMapping
    fun size() = programmerListService.size()

    @PutMapping
    fun put(programmer: Programmer) = programmerListService.addProgrammer(programmer)
}
