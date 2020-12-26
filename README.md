# Spring Batch Lightmin Transaction Demo

This example demonstrates a problem with Spring Batch Lightmin.
Per default spring data jpa repositories can be used directly and each method execution are wrapped with a correct transaction.
As soon as one enabels Spring Batch Lightmin, the repository methods are not executed in a transaction anymore.

e.g. enable spring boot lightmin:

```java
@SpringBootApplication
@EnableLightminEmbedded
@EnableLightminJdbcConfigurationRepository
public class LightminTransactionApplication {
    ...
}
```

example of spring data jpa repository usage:

```java
	@Bean
	public CommandLineRunner demo(PersonRepository repository) {
		return (args) -> {
			LOGGER.info("init data...");
			// save some persons
			repository.save(new Person("Starter", "Meister"));
			LOGGER.info("init data done");
		};
	}
```

This demo application has a test case which shows the problem: `LightminTransactionApplicationTests`. The test case passes, as soon as `@EnableLightminEmbedded` and `@EnableLightminJdbcConfigurationRepository` are commented/deactovated.

This is reported at: https://github.com/tuxdevelop/spring-batch-lightmin/issues/52
