package academy.softserve.eschool.repository;

import academy.softserve.eschool.dto.JournalDTO;
import academy.softserve.eschool.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    @Query(value = "Select distinct subject.id,subject.name,subject.description from class_teacher_subject_link left join subject \n" +
            "on class_teacher_subject_link.subject_id=subject.id\n" +
            "where teacher_id=:idTeacher", nativeQuery=true)
    List<Subject> findSubjectsByTeacher(@Param("idTeacher") int idTeacher);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE subject SET name=:subjectName, description=:subjectDescription WHERE id=:id", nativeQuery=true)
    void editSubject(@Param("id") int id, @Param("subjectName") String name, @Param("subjectDescription") String description);
}
