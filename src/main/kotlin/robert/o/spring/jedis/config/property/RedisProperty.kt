package robert.o.spring.jedis.config.property

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties("redis")
class RedisProperty {

    var hostname = ""
    var port = 0
    var jedis = JedisProperty()
}
