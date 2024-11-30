package edu.uoc.pac4;

import edu.uoc.pac4.activity.*;
import edu.uoc.pac4.execution.Execution;
import edu.uoc.pac4.university.University;
import edu.uoc.pac4.university.UniversityException;
import edu.uoc.pac4.user.Student;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DSLabStreamTest {

    private DSLab dsLab;
    private Student student1, student2, student3;

    @BeforeEach
    public void setUp() throws Exception {
        dsLab = new DSLab(
                "Distributed Systems Lab",
                "A lab for distributed systems",
                1, 0, 0,
                2_000_000_000L, // CPU
                new University(
                        "Universitat Oberta de Catalunya",
                        "UOC",
                        LocalDate.of(1994, 10, 6),
                        "Avinguda del Tibidabo, 39-43",
                        "www.uoc.edu"
                )
        );

        student1 = new Student("student@uoc.edu", "Name", "Surname");
        student2 = new Student("student2@uoc.edu", "Name2", "Surname2");;
        student3 = new Student("student3@uoc.edu", "Name3", "Surname3");

        Activity quiz1 = new ActivityQuiz("Quiz 1", "First Quiz", ActivityQuizType.MULTIPLE_CHOICE);
        Activity javaLab = new ActivityProgrammingJava("Java Lab", "Programming in Java", 50, "17", "7.5");
        Activity cppLab = new ActivityProgrammingCpp("C++ Lab", "Programming in C++", 30, "g++", "C++11");
        Activity pythonLab = new ActivityProgrammingPython("Python Lab", "Programming in Python", 20, "3.9", true);

        dsLab.addActivity(quiz1);
        dsLab.addActivity(javaLab);
        dsLab.addActivity(cppLab);
        dsLab.addActivity(pythonLab);

        new Execution(8.5, student1, quiz1);
        new Execution(7.0, student2, quiz1);
        new Execution(9.0, student1, javaLab);
        new Execution(6.5, student3, cppLab);
    }

    @Test
    @Order(1)
    @DisplayName("getActivityNames")
    public void testGetActivityNames() throws UniversityException, DSLabException {
        List<String> activityNames = dsLab.getActivityNames();

        assertNotNull(activityNames);
        assertEquals(4, activityNames.size());
        assertTrue(activityNames.contains("Quiz 1"));
        assertTrue(activityNames.contains("Java Lab"));
        assertTrue(activityNames.contains("C++ Lab"));
        assertTrue(activityNames.contains("Python Lab"));

        DSLab emptyDSLab = new DSLab(
                "Empty Lab",
                "No activities",
                1, 0, 0,
                2_000_000_000L,
                new University(
                        "Universitat Oberta de Catalunya",
                        "UOC",
                        LocalDate.of(1994, 10, 6),
                        "Avinguda del Tibidabo, 39-43, 08035 Barcelona, España",
                        "www.uoc.edu"
                )
        );
        assertTrue(emptyDSLab.getActivityNames().isEmpty());
    }

    @Test
    @Order(2)
    @DisplayName("getProgrammingActivitiesOrdered")
    public void testGetProgrammingActivitiesOrdered() {
        List<ActivityProgramming> programmingActivities = dsLab.getProgrammingActivitiesOrdered();

        assertNotNull(programmingActivities);

        assertEquals(3, programmingActivities.size());
        assertEquals("C++ Lab", programmingActivities.get(0).getName());
        assertEquals("Java Lab", programmingActivities.get(1).getName());
        assertEquals("Python Lab", programmingActivities.get(2).getName());
    }

    @Test
    @Order(3)
    @DisplayName("getExecutionsCountByActivityType")
    public void testGetExecutionsCountByActivityType() throws ActivityException, UniversityException, DSLabException {
        Map<String, Long> executionsByType = dsLab.getExecutionsCountByActivityType();

        assertNotNull(executionsByType);

        assertEquals(4, executionsByType.size());
        assertEquals(2, executionsByType.get("ActivityQuiz"));
        assertEquals(1, executionsByType.get("ActivityProgrammingJava"));
        assertEquals(1, executionsByType.get("ActivityProgrammingCpp"));
        assertTrue(executionsByType.containsKey("ActivityProgrammingPython"));

        Activity quiz2 = new ActivityQuiz("Quiz 2", "Second Quiz", ActivityQuizType.MULTIPLE_CHOICE);

        dsLab.addActivity(quiz2);
        new Execution(9, student1, quiz2);

        executionsByType = dsLab.getExecutionsCountByActivityType();

        assertEquals(4, executionsByType.size());
        assertEquals(3, executionsByType.get("ActivityQuiz"));
        assertEquals(1, executionsByType.get("ActivityProgrammingJava"));
        assertEquals(1, executionsByType.get("ActivityProgrammingCpp"));
        assertEquals(0, executionsByType.get("ActivityProgrammingPython"));

        Activity activityPy = new ActivityProgrammingPython("Python", "My custom exercise", 25.0, "3.9", true);
        dsLab.addActivity(activityPy);

        new Execution(8.0, student1, activityPy);

        executionsByType = dsLab.getExecutionsCountByActivityType();

        assertEquals(4, executionsByType.size());
        assertEquals(3, executionsByType.get("ActivityQuiz"));
        assertEquals(1, executionsByType.get("ActivityProgrammingJava"));
        assertEquals(1, executionsByType.get("ActivityProgrammingCpp"));
        assertEquals(1, executionsByType.get("ActivityProgrammingPython"));

        DSLab noExecutionsDSLab = new DSLab(
                "No Executions",
                "Empty Executions",
                1, 0, 0,
                2_000_000_000L,
                new University(
                        "Universitat Oberta de Catalunya",
                        "UOC",
                        LocalDate.of(1994, 10, 6),
                        "Avinguda del Tibidabo, 39-43, 08035 Barcelona, España",
                        "www.uoc.edu"
                )
        );
        noExecutionsDSLab.addActivity(new ActivityQuiz("Quiz No Exec", "Quiz without executions", ActivityQuizType.TRUE_FALSE));
        Map<String, Long> emptyExecutionsByType = noExecutionsDSLab.getExecutionsCountByActivityType();
        assertEquals(1, emptyExecutionsByType.size());
        assertEquals(0, emptyExecutionsByType.get("ActivityQuiz"));
    }
}
