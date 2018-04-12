package com.nabin.eassynotess.service;

//import com.nabin.eassynotess.Dto.NoteDto;
import com.nabin.eassynotess.Model.Note;
import com.nabin.eassynotess.dto.NoteDto;
import com.nabin.eassynotess.resource.NoteResource;
//import com.nabin.eassynotess.Resource.NoteResource;

import javax.validation.Valid;
import java.util.List;

public interface NoteService {

    List<Note> findAllNotes();

    Note addNeuuNote(NoteDto noteDto);

    Note deleteNotes(Long id);


    Note updateNote(NoteDto noteDto, Long id);

    Note findById(Long id);

    List<Note> getNotesByTitle(String title);


    List<Note> getNotesByUserId(Long userId);
}
