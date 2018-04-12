package com.nabin.eassynotess.converter;

import com.nabin.eassynotess.Model.Note;
import com.nabin.eassynotess.resource.NoteResource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteConverteServiceImpl implements NoteConvertServicw{
    @Override
    public NoteResource convertNote(Note note) {
        return NoteResource.builder()
                .content(note.getContent())
                .createdDate(note.getCreatedAt())
                .status(note.getStatus())
                .noteId(note.getId())
                .title(note.getTitle())
                .name(note.getUser().getDisplayName()
                        +" ("+note.getUser().getUsername()+" )")
                        .build();
    }

    @Override
    public List<NoteResource> convertList(List<Note> notesByTitle) {
        List<NoteResource> noteResourceList= new ArrayList<>();
        for (Note note:notesByTitle){
            noteResourceList.add(convertNote(note));
        }
        return noteResourceList;
    }


}
