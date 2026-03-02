package ru.itmo.spring.lesson5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.itmo.spring.lesson5.dao.GroupDao;
import ru.itmo.spring.lesson5.dao.StudentDao;

@SpringBootApplication
//@EntityScan({"lesson5", "lesson4"})
public class HibernateRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(HibernateRunner.class);
        GroupDao groupDao = applicationContext.getBean(GroupDao.class);

        System.out.println(groupDao.findAll());
        String newGroupName = "From IDEA";
        groupDao.deleteByName(newGroupName);

        groupDao.insert(newGroupName);
        System.out.println(groupDao.findAll());
        groupDao.update(2L, "IT");
        System.out.println(groupDao.findAll());
        System.out.println("----------------");
        StudentDao studentDao = applicationContext.getBean(StudentDao.class);
        studentDao.assignToGroup(3L, groupDao.findById(2L).orElse(null));

        System.out.println(studentDao.findById(3L).orElse(null));
        System.out.println(studentDao.findAll());
    }
}
