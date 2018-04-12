package com.nabin.eassynotess.controller;



import com.nabin.eassynotess.Model.Note;

import com.nabin.eassynotess.converter.NoteConvertServicw;
import com.nabin.eassynotess.dto.NoteDto;
import com.nabin.eassynotess.resource.NoteResource;
import com.nabin.eassynotess.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api")

public class ApplicationController {
    private final NoteService noteService;
    private final NoteConvertServicw noteConvertServicw;


    @Autowired
    public ApplicationController(NoteService noteService, NoteConvertServicw noteConvertServicw) {
        this.noteService = noteService;

        this.noteConvertServicw = noteConvertServicw;
    }

    @GetMapping(value = "/notes")
    public List <Note> findall(){
        return noteService.findAllNotes();
    }

    @PostMapping(value = "/notes")
    public NoteResource addNewNote(@RequestBody NoteDto noteDto){
        return noteConvertServicw.convertNote((noteService.addNeuuNote(noteDto)));
    }

    @PostMapping(value = "/notes/delete/{id}")
    public Note deleteUpdate(@PathVariable(value = "id")Long Id){
        return noteService.deleteNotes(Id);
    }

    @PutMapping(value = "/notes/update/{id}")
    public NoteResource update(@PathVariable(value = "id")Long Id,
                               @RequestBody NoteDto noteDto){
        return noteConvertServicw.convertNote(noteService.updateNote(noteDto,Id));
    }

    @GetMapping(value = "notes/{id}")
    public Note getNoteById(@PathVariable(value = "id")Long Id){
        return noteService.findById(Id);
    }

    @GetMapping(value = "notes/title")
    public List<NoteResource> getNoteByTitle(@RequestParam(value = "title")String title){
        return noteConvertServicw.convertList(noteService.getNotesByTitle(title));
    }

    @GetMapping(value = "notes/user/{UserId}")
    public List <NoteResource> getNoteByUserId(@PathVariable(value = "id")Long UserId){
        return noteConvertServicw.convertList( noteService.getNotesByUserId(UserId));
    }


}
