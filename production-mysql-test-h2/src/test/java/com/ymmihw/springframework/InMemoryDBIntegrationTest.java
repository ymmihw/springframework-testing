package com.ymmihw.springframework;

import static org.junit.Assert.assertEquals;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
public class InMemoryDBIntegrationTest {

  @Resource
  private StudentRepository studentRepository;

  private static final long ID = 1;
  private static final String NAME = "john";

  @Test
  public void givenStudent_whenSave_thenGetOk() {
    Student student = new Student(ID, NAME);
    studentRepository.save(student);

    Student student2 = studentRepository.getOne(ID);
    assertEquals("name incorrect", NAME, student2.getName());
  }
}
