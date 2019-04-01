package robert.o.spring.jedis.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import robert.o.spring.jedis.model.Programmer
import robert.o.spring.jedis.service.ProgrammerService

@RestController
@RequestMapping("programmer")
class ProgrammerController(private val programmerService: ProgrammerService) {

    @GetMapping("id")
    fun get(id: String) = programmerService.getProgrammer(id)

    @PostMapping
    fun post(programmer: Programmer) = programmerService.setProgrammer(programmer)
}
