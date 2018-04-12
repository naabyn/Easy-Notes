package com.nabin.eassynotess.converter;

import com.nabin.eassynotess.Model.Note;
import com.nabin.eassynotess.resource.NoteResource;

import java.util.List;

public interface NoteConvertServicw {
    NoteResource convertNote(Note note);

    List<NoteResource> convertList(List<Note> notesByTitle);
}
