package com.ymmihw.springframework.testing;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = Spring5JUnit5ConcurrentIntegrationTest.SimpleConfiguration.class)
public class Spring5JUnit5ConcurrentIntegrationTest
    implements ApplicationContextAware, InitializingBean {

  @Configuration
  public static class SimpleConfiguration {
  }

  private ApplicationContext applicationContext;

  private boolean beanInitialized = false;

  @Override
  public final void afterPropertiesSet() throws Exception {
    this.beanInitialized = true;
  }

  @Override
  public final void setApplicationContext(final ApplicationContext applicationContext)
      throws BeansException {
    this.applicationContext = applicationContext;
  }

  @Test
  public final void verifyApplicationContextSet() throws InterruptedException {

    TimeUnit.SECONDS.sleep(2);
    assertNotNull(this.applicationContext,
        "The application context should have been set due to ApplicationContextAware semantics.");
  }

  @Test
  public final void verifyBeanInitialized() throws InterruptedException {
    TimeUnit.SECONDS.sleep(2);
    assertTrue(this.beanInitialized,
        "This test bean should have been initialized due to InitializingBean semantics.");
  }

}
