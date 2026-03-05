package ru.itmo.spring.lesson5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.itmo.spring.lesson5.dao.GroupDao;
import ru.itmo.spring.lesson5.dao.StudentDao;
import ru.itmo.spring.lesson5.model.Group;
import ru.itmo.spring.lesson5.repository.GroupRepository;
import ru.itmo.spring.lesson5.repository.StudentRepository;

import java.util.List;

@SpringBootApplication
//@EntityScan({"lesson5", "lesson4"})
public class HibernateRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(HibernateRunner.class);
//        GroupDao groupRepository = applicationContext.getBean(GroupDao.class);
        GroupRepository groupRepository = applicationContext.getBean(GroupRepository.class);

        List<Group> allGroups = groupRepository.findAll();
        allGroups.stream().filter(it -> it.getId() == 2L).findFirst().ifPresent(
                it -> {
                    it.setGroupName("1235");
                    groupRepository.saveAndFlush(it);
                }
        );
        Group group = new Group();
        group.setGroupName("Test123");
        groupRepository.save(group);

        System.out.println(allGroups);
        String newGroupName = "From IDEA";
        groupRepository.deleteByGroupName(newGroupName);

        groupRepository.insert(newGroupName);
        System.out.println(groupRepository.findAll());
        groupRepository.update(2L, "IT");
        System.out.println(groupRepository.findAll());
        System.out.println("----------------");
//        StudentDao studentRepository = applicationContext.getBean(StudentDao.class);
        StudentRepository studentRepository = applicationContext.getBean(StudentRepository.class);
        studentRepository.assignToGroup(3L, groupRepository.findById(2L).orElse(null));

        System.out.println(studentRepository.findById(3L).orElse(null));
        System.out.println(studentRepository.findAll());
    }
}
