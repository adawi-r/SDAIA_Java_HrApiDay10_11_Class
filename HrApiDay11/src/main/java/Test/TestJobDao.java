package Test;
import org.example.DAO.JobDAO;
import org.example.dto.JobFilterDto;
import org.example.models.Job;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.extension.ExtendWith;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class TestJobDao {

    @Mock
    JobFilterDto filter;

    @InjectMocks
    JobDAO dao;

    @Test
    public void testUpdateJobs() throws SQLException, ClassNotFoundException {

        Job j = new Job(2,"test",4000,9000);

        Assertions.assertDoesNotThrow(() -> dao.updateJob(j));

        Job newj = dao.selectJob(j.getJob_id());

        Assertions.assertNotNull(newj);
                                //before up           //after up
        Assertions.assertEquals(newj.getJob_title(), j.getJob_title());
        Assertions.assertEquals(newj.getMin_salary(), j.getMin_salary());
        Assertions.assertEquals(newj.getMax_salary(), j.getMax_salary());

    }

//    @Test
//    public void testUpdateJobs() throws SQLException, ClassNotFoundException {
//
//        when(filter.getMax_salary()).thenReturn(9000.0);
//        when(filter.getLimit()).thenReturn(null);
//
//        Assertions.assertDoesNotThrow(() -> dao.selectAllJob(filter));
//
//        ArrayList<Job> jobs = dao.selectAllJob(filter);
//
//        Assertions.assertNotNull(jobs);
//        Assertions.assertTrue(jobs.size() != 0);
//        for (Job j : jobs) {
//            Assertions.assertEquals(9000.0, (j.getMax_salary()));
//        }
//
//    }
}
