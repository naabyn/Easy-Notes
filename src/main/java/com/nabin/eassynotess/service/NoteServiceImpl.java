package com.nabin.eassynotess.service;


import com.nabin.eassynotess.Exception.ResourceNotFoundException;
import com.nabin.eassynotess.Model.Note;
import com.nabin.eassynotess.Model.Status;
import com.nabin.eassynotess.Model.User;
import com.nabin.eassynotess.Repository.NoteRepository;
import com.nabin.eassynotess.dto.NoteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    public final NoteRepository noteRepository;
    private final UserService userService;
    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository,
                           UserService userService) {
        this.noteRepository = noteRepository;
        this.userService = userService;
    }

    @Override
    public List<Note> findAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note addNeuuNote(NoteDto noteDto) {
       // User user=userService.findById(noteDto.getUserId());
        Note note= new Note();
        note.setContent(noteDto.getContent());
        note.setTitle(noteDto.getTitle());
        note.setUser(userService.findById(noteDto.getUserId()));
        note.setStatus(Status.ACTIVE);
        return noteRepository.save(note);
    }

    @Override
    public Note deleteNotes(Long Id) {
        return noteRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Note","id",Id ));
        //return noteRepository.delete(note);
    }

    @Override
    public Note updateNote(NoteDto noteDto, Long Id) {
        Note note=noteRepository.findById(Id)
                .orElseThrow(()->new ResourceNotFoundException("Note","id",Id));
        note.setTitle(noteDto.getTitle());
        note.setContent(noteDto.getContent());

        return noteRepository.save(note);
    }

    @Override
    public Note findById(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Note","id",id));

    }

    @Override
    public List<Note> getNotesByTitle(String title) {
        return noteRepository.findAllByTitle(title);
    }

    @Override
    public List<Note> getNotesByUserId(Long userId) {
        return noteRepository.findAllByUserId(userId);
    }
}

