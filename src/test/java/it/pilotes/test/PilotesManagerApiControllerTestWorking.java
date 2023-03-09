package it.pilotes.test;


import it.pilotes.h2db.springboot.SpringBootH2Application;
import it.pilotes.h2db.springboot.config.PilotesConfig;
import it.pilotes.h2db.springboot.controller.PilotesManagerApiController;
import it.pilotes.h2db.springboot.entity.CustomerEntity;
import it.pilotes.h2db.springboot.repositry.CustomerRepository;
import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;


@ContextConfiguration(classes = { PilotesConfig.class }, loader = AnnotationConfigContextLoader.class)
@SpringBootTest(classes = SpringBootH2Application.class)
@AutoConfigureMockMvc(addFilters = false)
@TestInstance(Lifecycle.PER_CLASS)
public class PilotesManagerApiControllerTestWorking {

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  PilotesManagerApiController toTest;

  private static final long ID = 1;
  private static final String NAME = "john";

  @Test
  public void givenStudent_whenSave_thenGetOk() {
/*
    Student student = new Student(ID, NAME);
    customerRepository.save(student);
*/

    CustomerEntity student2 = customerRepository.findById(ID).get();

  }

/*  @Test
  public void givenStudentWithTags_whenSave_thenGetByTagOk() {
    Student student = new Student(ID, NAME);
    student.setTags(Arrays.asList("full time", "computer science"));
    customerRepository.save(student);

    Student student2 = customerRepository.retrieveByTag("full time").get(0);
    assertEquals("name incorrect", NAME, student2.getName());
  }

  @Test
  public void givenMultipleStudentsWithTags_whenSave_thenGetByTagReturnsCorrectCount() {
    Student student = new Student(0, "Larry");
    student.setTags(Arrays.asList("full time", "computer science"));
    customerRepository.save(student);

    Student student2 = new Student(1, "Curly");
    student2.setTags(Arrays.asList("part time", "rocket science"));
    customerRepository.save(student2);

    Student student3 = new Student(2, "Moe");
    student3.setTags(Arrays.asList("full time", "philosophy"));
    customerRepository.save(student3);

    Student student4 = new Student(3, "Shemp");
    student4.setTags(Arrays.asList("part time", "mathematics"));
    customerRepository.save(student4);

    List<Student> students = customerRepository.retrieveByTag("full time");
    assertEquals("size incorrect", 2, students.size());
  }

  @Test
  public void givenStudentWithTags_whenSave_thenGetByNameAndTagOk() {
    Student student = new Student(ID, NAME);
    student.setTags(Arrays.asList("full time", "computer science"));
    customerRepository.save(student);

    Student student2 = customerRepository.retrieveByNameFilterByTag("John", "full time").get(0);
    assertEquals("name incorrect", NAME, student2.getName());
  }*/

}
