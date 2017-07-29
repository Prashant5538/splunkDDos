package com.splunk.ddos.splunkDDos.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
@ComponentScan
public class RedisTemplateConfig {

	@Value("${redis.dbCompartment}")
	private Integer dbCompartment;
	@Value("${redis.hostname}")
	private String hostName;
	@Value("${redis.port}")
	private Integer port;

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		final JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
		connectionFactory.setDatabase(dbCompartment);
		connectionFactory.setHostName(hostName);
		connectionFactory.setPort(port);
		connectionFactory.setPoolConfig(new JedisPoolConfig());
		connectionFactory.setUsePool(true);
		return connectionFactory;
	}

	@Bean
	RedisTemplate<String, Object> objectRedisTemplate() {
		final RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(jedisConnectionFactory());
		template.setDefaultSerializer(new JdkSerializationRedisSerializer());
		return template;
	}

	@Bean
	RedisTemplate<String, String> redisTemplate() {
		final RedisTemplate<String, String> template = new RedisTemplate<>();
		template.setConnectionFactory(jedisConnectionFactory());
		template.setDefaultSerializer(new StringRedisSerializer());
		return template;
	}

}
