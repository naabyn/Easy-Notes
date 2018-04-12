package com.nabin.eassynotess.Repository;

import com.nabin.eassynotess.Model.Note;
import com.nabin.eassynotess.resource.NoteResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note,Long> {

    @Query("select n from  Note n where n.title=:title")
    List<Note> findAllByTitle(@Param("title")String title);

    @Query("select n from Note n where n.userId=:userId" )
    List<Note> findAllByUserId(Long userId);
}
