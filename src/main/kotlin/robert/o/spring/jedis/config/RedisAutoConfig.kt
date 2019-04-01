package robert.o.spring.jedis.config

import org.apache.commons.pool2.impl.GenericObjectPoolConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import robert.o.spring.jedis.config.property.RedisProperty
import robert.o.spring.jedis.model.Programmer

@Configuration
class RedisAutoConfig(private val redisProperty: RedisProperty) {

    @Bean
    fun jedisClientConfiguration(): JedisClientConfiguration {

        val poolConfig = GenericObjectPoolConfig()
        poolConfig.maxTotal = redisProperty.jedis.pool.maxTotal
        poolConfig.maxIdle = redisProperty.jedis.pool.maxIdle
        poolConfig.minIdle = redisProperty.jedis.pool.minIdle

        return JedisClientConfiguration.builder()
                .usePooling()
                .poolConfig(poolConfig)
                .build()
    }

    @Bean
    fun jedisConnectionFactory(jedisClientConfiguration: JedisClientConfiguration): JedisConnectionFactory {

        val redisConfig = RedisStandaloneConfiguration()
        redisConfig.hostName = redisProperty.hostname
        redisConfig.port = redisProperty.port

        return JedisConnectionFactory(redisConfig, jedisClientConfiguration)
    }

    @Bean
    fun redisTemplate(jedisConnectionFactory: JedisConnectionFactory): RedisTemplate<String, Programmer> {

        val redisTemplate = RedisTemplate<String, Programmer>()
        redisTemplate.setConnectionFactory(jedisConnectionFactory)

        return redisTemplate
    }

    @Bean
    fun valueOps(redisTemplate: RedisTemplate<String, Programmer>) = redisTemplate.opsForValue()

    @Bean
    fun listOps(redisTemplate: RedisTemplate<String, Programmer>) = redisTemplate.opsForList()
}
