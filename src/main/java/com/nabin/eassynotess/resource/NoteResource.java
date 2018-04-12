package com.nabin.eassynotess.resource;

import com.nabin.eassynotess.Model.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class NoteResource {

    private Long noteId;
    private String title;
    private String content;
    private Date createdDate;
    private Status status;
    private String name;

}
